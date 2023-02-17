package com.workspace.spaceserver.controller;

import com.workspace.spaceserver.common.R;
import com.workspace.spaceserver.params.UserLogInParam;
import com.workspace.spaceserver.params.UserSignInParam;
import com.workspace.spaceserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 注册
     */
    @PostMapping("/signIn")
    public R<Boolean> signIn(@Validated @RequestBody UserSignInParam userSignInParam) {
        return R.ok(userService.signIn(userSignInParam));
    }

    /**
     * 登录
     */
    @PostMapping("/logIn")
    public R<Boolean> logIn(@Validated @RequestBody UserLogInParam userLogInParam) {
        return R.ok(userService.logIn(userLogInParam));
    }

}
