import { Datagrid, List, TextField } from 'react-admin';

export const DirectorList = () => (
	<List>
		<Datagrid>
			<TextField source="name" />
		</Datagrid>
	</List>
);