import { Datagrid, List, TextField } from 'react-admin';

export const UserList = () => (
	<List>
		<Datagrid>
			<TextField source="username" />
			<TextField source="role" />
		</Datagrid>
	</List>
);