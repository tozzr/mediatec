import { Datagrid, List, ReferenceField, TextField } from 'react-admin';

export const AlbumList = () => (
	<List>
		<Datagrid>
			<ReferenceField source="artistId" reference="artists" />
			<TextField source="title" />
			<TextField source="releaseYear" />
			<TextField source="genre" />
		</Datagrid>
	</List>
);