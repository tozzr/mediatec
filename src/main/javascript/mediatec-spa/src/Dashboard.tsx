import { Card, CardContent, CardHeader, Typography } from "@mui/material";
import { useGetList } from 'react-admin';
import {
	ResponsiveContainer,
	LineChart,
	Line,
	XAxis,
	YAxis,
	CartesianGrid,
	Tooltip,
	Legend,
	BarChart,
	Bar,
} from 'recharts';

const data = [
	{ month: 'Jan', sales: 4000, users: 2400 },
	{ month: 'Feb', sales: 3000, users: 1398 },
	{ month: 'Mar', sales: 2000, users: 9800 },
	{ month: 'Apr', sales: 2780, users: 3908 },
	{ month: 'May', sales: 1890, users: 4800 },
	{ month: 'Jun', sales: 2390, users: 3800 },
	{ month: 'Jul', sales: 3490, users: 4300 },
];

const Dashboard = () => {
	const { data: books, total: totalBooks } = useGetList('books');
	const { data: authors, total: totalAuthors } = useGetList('authors');
	const { data: albums, total: totalAlbums } = useGetList('albums');
	const { data: users, total: totalUsers } = useGetList('users');

	return (
		<div className="grid grid-cols-1 md:grid-cols-3 gap-4 p-4">
			<Card>
				<CardHeader title="Sales Overview" />
				<CardContent>
					<ResponsiveContainer width="100%" height={300}>
						<LineChart data={data}>
							<CartesianGrid strokeDasharray="3 3" />
							<XAxis dataKey="month" />
							<YAxis />
							<Tooltip />
							<Legend />
							<Line type="monotone" dataKey="sales" stroke="#8884d8" />
							<Line type="monotone" dataKey="users" stroke="#82ca9d" />
						</LineChart>
					</ResponsiveContainer>
				</CardContent>
			</Card>

			<Card style={{ marginTop: 20 }}>
				<CardHeader title="User Growth" />
				<CardContent>
					<ResponsiveContainer width="100%" height={300}>
						<BarChart data={data}>
							<CartesianGrid strokeDasharray="3 3" />
							<XAxis dataKey="month" />
							<YAxis />
							<Tooltip />
							<Legend />
							<Bar dataKey="users" fill="#8884d8" />
						</BarChart>
					</ResponsiveContainer>
				</CardContent>
			</Card>

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
