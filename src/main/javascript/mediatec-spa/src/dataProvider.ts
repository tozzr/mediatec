import { fetchUtils } from "react-admin";

const apiUrl = "http://localhost:8080";

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

const dataProvider = {
	getList: async (resource, params) => {
		const { page, perPage } = params.pagination;
		const { field, order } = params.sort;

		const query = `page=${page - 1}&size=${perPage}&sort=${field},${order.toLowerCase()}`;
		const url = `${apiUrl}/${resource}?${query}`;

		const { json } = await httpClient(url);
		console.log(json._embedded[resource])
		return {
			data: json._embedded[resource],
			total: json.page.totalElements
		};
	},

	getMany: async (resource, params) => {
		const query = params.ids.map(id => `ids=${id}`).join('&');
		const url = `${apiUrl}/${resource}/search/findByIdIn?${query}`;
		const { json } = await httpClient(url);
		return { data: json._embedded[resource] };
	},
	
	getOne: async (resource, params) => {
		const { json } = await httpClient(`${apiUrl}/${resource}/${params.id}`);
		return { data: json };
	},

	update: async (resource, params) => {
		const { json } = await httpClient(`${apiUrl}/${resource}/${params.id}`, {
			method: "PUT",
			body: JSON.stringify(params.data)
		});
		return { data: json };
	},

	create: async (resource, params) => {
		const { json } = await httpClient(`${apiUrl}/${resource}`, {
			method: "POST",
			body: JSON.stringify(params.data)
		});
		return { data: { ...params.data, id: json.id } };
	},

	delete: async (resource, params) => {
		await httpClient(`${apiUrl}/${resource}/${params.id}`, { method: "DELETE" });
		return { data: params.previousData };
	}
};

export default dataProvider;
