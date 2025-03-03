import { Create, ReferenceInput, SimpleForm, TextInput, required } from 'react-admin';

export const MovieCreate = () => (
	<Create>
		<SimpleForm>
			<TextInput source="title" validate={[required()]} />
			<ReferenceInput source="directorId" reference="directors" />
		</SimpleForm>
	</Create>
);