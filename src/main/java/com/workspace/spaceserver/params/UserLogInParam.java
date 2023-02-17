package com.workspace.spaceserver.params;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserLogInParam {
    @Email
    private String email;
    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordAgain;
    @NotEmpty
    private String code;
}
