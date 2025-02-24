import { fetchUtils } from "react-admin";

const apiUrl = "http://localhost:8080/api";

const httpClient = (url, options = {}) => {
    const token = localStorage.getItem("token");
    if (!options.headers) {
        options.headers = new Headers({ "Content-Type": "application/json" });
    }
    if (token) {
        options.headers.set("Authorization", `Bearer ${token}`);
    }
    return fetchUtils.fetchJson(url, options);
};

const authProvider = {
    login: async ({ username, password }) => {
        const request = new Request(`${apiUrl}/auth/login`, {
            method: "POST",
            body: JSON.stringify({ username, password }),
            headers: new Headers({ "Content-Type": "application/json" }),
        });

        return fetch(request)
            .then(response => {
                if (response.status < 200 || response.status >= 300) {
                    throw new Error("Login failed");
                }
                return response.json();
            })
            .then(auth => {
                localStorage.setItem("token", auth.token);
                localStorage.setItem("user", auth.username);
                return Promise.resolve();
            });
    },

    logout: () => {
        localStorage.removeItem("token");
        return Promise.resolve();
    },

    checkAuth: () => localStorage.getItem("token") ? Promise.resolve() : Promise.reject(),

    checkError: (error) => {
        if (error.status === 401 || error.status === 403) {
            localStorage.removeItem("token");
            return Promise.reject();
        }
        return Promise.resolve();
    },

    getPermissions: () => Promise.resolve(),
};

export default authProvider;
