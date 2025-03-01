import { Datagrid, List, ReferenceField, TextField } from 'react-admin';

export const BookList = () => (
	<List>
		<Datagrid>
			<ReferenceField source="authorId" reference="authors" />
			<TextField source="title" />
		</Datagrid>
	</List>
);