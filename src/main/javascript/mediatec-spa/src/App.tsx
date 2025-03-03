import {
	Admin,
	Resource,
	EditGuesser,
	ShowGuesser,
	ListGuesser,
} from "react-admin";
import { Layout } from "./Layout";
import dataProvider from "./dataProvider";
import authProvider from "./authProvider";
import Dashboard from "./Dashboard";

import { AuthorList, AuthorCreate, BookList, BookCreate, BookEdit } from "./books";
import { AlbumList, AlbumCreate, AlbumEdit, ArtistList } from "./music";
import { DirectorCreate, MovieList, MovieCreate, DirectorList } from "./movies";
import { UserList } from "./users/UserList";

export const App = () => (
	<Admin
		layout={Layout}
		dataProvider={dataProvider}
		authProvider={authProvider}
		dashboard={Dashboard}
	>
		<Resource name="authors" list={AuthorList} create={AuthorCreate} edit={EditGuesser} show={ShowGuesser} />
		<Resource name="books" list={BookList} edit={BookEdit} show={ShowGuesser} create={BookCreate} />

		<Resource name="artists" list={ArtistList} edit={EditGuesser} show={ShowGuesser} create={EditGuesser} />
		<Resource name="albums" list={AlbumList} edit={AlbumEdit} show={ShowGuesser} create={AlbumCreate} />

		<Resource name="movies" list={MovieList} edit={EditGuesser} create={MovieCreate} show={ShowGuesser} />
		<Resource name="directors" list={DirectorList} edit={EditGuesser} show={ShowGuesser} create={DirectorCreate} />

		<Resource name="users" list={UserList} edit={EditGuesser} show={ShowGuesser} />
	</Admin>
);
