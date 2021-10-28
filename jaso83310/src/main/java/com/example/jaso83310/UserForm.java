package com.example.jaso83310;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm{
  @NotBlank
  private String id;
  @NotBlank
  private String pass;
}
