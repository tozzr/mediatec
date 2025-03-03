import { Create, ReferenceInput, SimpleForm, TextInput } from 'react-admin';

export const AlbumCreate = () => (
	<Create>
		<SimpleForm>
			<TextInput source="title" />
			<TextInput source="releaseYear" />
			<TextInput source="genre" />
			<ReferenceInput source="artistId" reference="artists" />
		</SimpleForm>
	</Create>
);