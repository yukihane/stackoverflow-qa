/* eslint-disable react/destructuring-assignment,
                  @typescript-eslint/no-unsafe-assignment,
                  @typescript-eslint/no-unsafe-member-access,
                  @typescript-eslint/restrict-template-expressions
*/
import { VFC } from "react";
import EmailField from "components/molecules/elements/EmailField";
import { Controller, DeepMap, FieldError, FieldValues } from "react-hook-form";
import { FormInputProps } from "semantic-ui-react";
import { InputFieldProps } from "components/molecules/elements/ElementProps";

export type RhfEmailFieldProps = InputFieldProps & FormInputProps;

export const RhfEmailField: VFC<RhfEmailFieldProps> = (props) => (
  <Controller
    name={props.name}
    control={props.control}
    defaultValue=""
    render={({ field, formState: { errors } }) => (
      <EmailField
        label={props.label}
        id={props.id}
        placeholder={props.placeholder}
        isRequired={props.required}
        showIcon={props.showIcon}
        {...field}
        errorMessage={
          errors[props.name] &&
          `${(errors[props.name] as DeepMap<FieldValues, FieldError>)?.message}`
        }
      />
    )}
  />
);

export default RhfEmailField;
