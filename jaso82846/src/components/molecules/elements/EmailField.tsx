import { VFC } from "react";
import ErrorMessage from "components/atoms/elements/ErrorMessage";
import { Form, Input } from "semantic-ui-react";
import { InputFieldProps, RhfRegisterInputFieldProps } from "./ElementProps";

type EmailFieldProps = InputFieldProps & RhfRegisterInputFieldProps;

const EmailField: VFC<EmailFieldProps> = (props: EmailFieldProps) => {
  const {
    label,
    id,
    placeholder,
    isRequired,
    showIcon,
    errorMessage,
    value,
    onChange,
    onBlur,
  } = props;
  const icon: string = showIcon ? "mail" : "";
  const iconPosition: "left" | undefined = showIcon ? "left" : undefined;

  return (
    <Form.Field required={isRequired}>
      <label>{label}</label>
      <Input
        type="email"
        id={id}
        placeholder={placeholder}
        icon={icon}
        iconPosition={iconPosition}
        error={!!errorMessage}
        value={value}
        onChange={onChange}
        onBlur={onBlur}
      />
      <ErrorMessage message={errorMessage} />
    </Form.Field>
  );
};

export default EmailField;
