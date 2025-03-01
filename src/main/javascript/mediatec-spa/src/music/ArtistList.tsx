import { Datagrid, List, TextField } from 'react-admin';

export const ArtistList = () => (
	<List>
		<Datagrid>
			<TextField source="name" />
		</Datagrid>
	</List>
);