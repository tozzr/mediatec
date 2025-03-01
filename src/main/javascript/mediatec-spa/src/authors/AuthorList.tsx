import { List, SimpleList } from 'react-admin';

export const AuthorList = () => (
	<List>
		<SimpleList
			primaryText={record => record.name}
		/>
	</List>
);