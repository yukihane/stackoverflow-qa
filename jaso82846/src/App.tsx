import { VFC } from "react";
import { Button, Form } from "semantic-ui-react";
//import { YupJa as yup } from "utils/validations/yup/i18n/YupJa";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import { SubmitHandler, useForm } from "react-hook-form";
import { RhfEmailField } from "components/organisms/elements/RhfEmailField";

type FormValues = {
  email: string;
  email2: string;
};

const schema = yup.object({
  email: yup.string().required().email().label("メールアドレス"),
  email2: yup.string().required().email().label("メールアドレス"),
});

const App: VFC = () => {
  const { control, handleSubmit } = useForm<FormValues>({
    resolver: yupResolver(schema),
  });

  const handleLogin: SubmitHandler<FormValues> = (data) => {
    console.log(data);
  };

  return (
    <Form size="large" onSubmit={handleSubmit(handleLogin)}>
      <RhfEmailField
        id="email"
        name="email"
        placeholder="メールアドレス"
        label="メールアドレス"
        required
        showIcon
        control={control}
      />

      <Button color="teal" fluid size="large">
        Click
      </Button>
    </Form>
  );
};
export default App;
