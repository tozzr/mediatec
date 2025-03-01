import { Card, CardContent, Typography } from "@mui/material";
import { useGetList } from 'react-admin';

const Dashboard = () => {
	const { data: books, total: totalBooks } = useGetList('books');
	const { data: authors, total: totalAuthors } = useGetList('authors');
	const { data: albums, total: totalAlbums } = useGetList('albums');
	const { data: users, total: totalUsers } = useGetList('users');

	return (
		<div className="grid grid-cols-1 md:grid-cols-3 gap-4 p-4">
			<Card>
				<CardContent>
					<Typography variant="h6">Books</Typography>
					<Typography variant="h4">{totalBooks || 0}</Typography>
				</CardContent>
			</Card>
			<Card>
				<CardContent>
					<Typography variant="h6">Authors</Typography>
					<Typography variant="h4">{totalAuthors || 0}</Typography>
				</CardContent>
			</Card>
			<Card>
				<CardContent>
					<Typography variant="h6">Albums</Typography>
					<Typography variant="h4">{totalAlbums || 0}</Typography>
				</CardContent>
			</Card>
			<Card>
				<CardContent>
					<Typography variant="h6">Users</Typography>
					<Typography variant="h4">{totalUsers || 0}</Typography>
				</CardContent>
			</Card>
		</div>
	);
};

export default Dashboard;
