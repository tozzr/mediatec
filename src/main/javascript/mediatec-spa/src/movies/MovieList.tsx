import { List, SimpleList } from 'react-admin';

export const MovieList = () => (
	<List>
		<SimpleList
			primaryText={record => record.title}
		/>
	</List>
);