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
import Dashboard from "./Dashboard";

import { AuthorList, AuthorCreate } from "./authors";
import { BookList, BookCreate } from "./books";

import { AlbumList, ArtistList } from "./music";

import { MovieList, MovieCreate } from "./movies";
import { UserList } from "./users/UserList";

export const App = () => (
	<Admin
		layout={Layout}
		dataProvider={dataProvider}
		authProvider={authProvider}
		dashboard={Dashboard}
	>
		<Resource name="authors" list={AuthorList} create={AuthorCreate} edit={EditGuesser} show={ShowGuesser} />
		<Resource name="books" list={BookList} edit={EditGuesser} show={ShowGuesser} create={BookCreate} />

		<Resource name="artists" list={ArtistList} edit={EditGuesser} show={ShowGuesser} create={EditGuesser} />
		<Resource name="albums" list={AlbumList} edit={EditGuesser} show={ShowGuesser} create={EditGuesser} />

		<Resource name="movies" list={MovieList} edit={EditGuesser} create={MovieCreate} show={ShowGuesser} />
		
		<Resource name="users" list={UserList} edit={EditGuesser} show={ShowGuesser} />
	</Admin>
);
