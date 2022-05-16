package jp.spring.jobboard.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountForm {

    private String type;

    @NotBlank(message = "ユーザIDを入力してください")
    private String username;

    @NotBlank(message = "パスワードを入力してください")
    @Size(min = 8, message = "パスワードは8文字以上で入力してください")
    private String password;

    private Boolean active;

}
