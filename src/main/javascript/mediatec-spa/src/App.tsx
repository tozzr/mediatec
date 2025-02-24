import {
	Admin,
	Resource,
	ListGuesser,
	EditGuesser,
	ShowGuesser,
} from "react-admin";
import { Layout } from "./Layout";
import dataProvider from "./dataProvider";
import authProvider from "./authProvider";
import { Dashboard } from "./Dashboard";

import { MovieList } from "./movies";
import { UserList } from "./users/UserList";

export const App = () => (
	<Admin
		layout={Layout}
		dataProvider={dataProvider}
		authProvider={authProvider}
		dashboard={Dashboard}
	>
		<Resource name="albums" list={ListGuesser} edit={EditGuesser} show={ShowGuesser} />
		<Resource name="artists" list={ListGuesser} edit={EditGuesser} show={ShowGuesser} />
		<Resource name="books" list={ListGuesser} edit={EditGuesser} show={ShowGuesser} />
		<Resource name="authors" list={ListGuesser} edit={EditGuesser} show={ShowGuesser} />
		<Resource name="movies" list={MovieList} edit={EditGuesser} show={ShowGuesser} />
		<Resource name="users" list={UserList} edit={EditGuesser} show={ShowGuesser} />
	</Admin>
);
