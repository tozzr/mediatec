import { Create, SimpleForm, TextInput, required } from 'react-admin';

export const MovieCreate = () => (
	<Create>
		<SimpleForm>
			<TextInput source="title" validate={[required()]} />
		</SimpleForm>
	</Create>
);