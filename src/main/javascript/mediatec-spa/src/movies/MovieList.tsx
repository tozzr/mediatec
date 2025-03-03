import { Datagrid, List, ReferenceField, TextField } from 'react-admin';

export const MovieList = () => (
	<List>
		<Datagrid>
			<TextField source="title" />
			<ReferenceField source="directorId" reference="directors" />
		</Datagrid>
	</List>
);