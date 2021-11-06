package com.example.jaso83449;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter; 

@Getter
@Setter
public class CreateForm {
    @NotBlank
    private String id;
    @NotBlank
    private String pass;
    @NotBlank
    private String reenter;
    @AssertTrue(message = "PASSが一致しません")
        public boolean isCheck() {
            if (pass != reenter) return true;
                return false;
        }
    @NotBlank
    private String name;
    @NotBlank
    private String kana;
    @NotBlank
    private String birth;
    @NotBlank
    private String club;
}
