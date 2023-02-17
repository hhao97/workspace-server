package com.workspace.spaceserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.workspace.spaceserver.entity.User;
import com.workspace.spaceserver.params.UserLogInParam;
import com.workspace.spaceserver.params.UserSignInParam;

public interface UserService extends IService<User> {
    Boolean signIn(UserSignInParam userSignInParam);

    String logIn(UserLogInParam userLogInParam);
}
