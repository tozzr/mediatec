import { Edit, ReferenceInput, SimpleForm, TextInput } from 'react-admin';

export const AlbumEdit = () => (
	<Edit>
		<SimpleForm>
			<TextInput source="title" />
			<TextInput source="releaseYear" />
			<TextInput source="genre" />
			<ReferenceInput source="artistId" reference="artists" />
		</SimpleForm>
	</Edit>
);