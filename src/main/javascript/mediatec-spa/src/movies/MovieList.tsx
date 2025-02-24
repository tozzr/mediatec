import { Datagrid, List, TextField } from 'react-admin';

export const MovieList = () => (
	<List>
		<Datagrid>
			<TextField source="title" />
		</Datagrid>
	</List>
);