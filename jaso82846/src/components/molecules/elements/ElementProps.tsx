import { ChangeEventHandler, FocusEventHandler } from "react";
import { RefCallBack } from "react-hook-form";

export type InputFieldProps = {
  label?: string;
  id?: string;
  placeholder?: string;
  isRequired?: boolean;
  showIcon?: boolean;
  errorMessage?: string | undefined;
};

export type RhfRegisterInputFieldProps = {
  inputRef?: RefCallBack;
  value: string;
  onChange: ChangeEventHandler<HTMLInputElement>;
  onBlur: FocusEventHandler<HTMLInputElement>;
};
