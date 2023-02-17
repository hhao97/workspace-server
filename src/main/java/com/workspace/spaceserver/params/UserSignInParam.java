package com.workspace.spaceserver.params;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserSignInParam {

    @Email
    private String email;
    @NotEmpty
    @Length(min = 2, max = 8, message = "昵称长度异常（2~8位）")
    private String nickname;
    @NotEmpty
    @Length(min = 6, max = 16, message = "密码长度异常（6~16位）")
    private String password;
    @NotEmpty
    private String code;
}
