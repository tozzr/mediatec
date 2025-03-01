import { Create, SimpleForm, TextInput, ReferenceInput, required } from 'react-admin';

export const BookCreate = () => (
	<Create>
		<SimpleForm>
			<TextInput source="title" validate={[required()]} />
			<ReferenceInput source="authorId" reference="authors" />
		</SimpleForm>
	</Create>
);