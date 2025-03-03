import { Edit, SimpleForm, TextInput, ReferenceInput, required } from 'react-admin';

export const BookEdit = () => (
	<Edit>
		<SimpleForm>
			<TextInput source="title" validate={[required()]} />
			<ReferenceInput source="authorId" reference="authors" />
		</SimpleForm>
	</Edit>
);