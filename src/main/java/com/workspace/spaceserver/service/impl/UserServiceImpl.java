package com.workspace.spaceserver.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workspace.spaceserver.common.exception.SpaceException;
import com.workspace.spaceserver.common.exception.code.UserExceptionCode;
import com.workspace.spaceserver.entity.User;
import com.workspace.spaceserver.mapper.UserMapper;
import com.workspace.spaceserver.params.UserLogInParam;
import com.workspace.spaceserver.params.UserSignInParam;
import com.workspace.spaceserver.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Boolean signIn(UserSignInParam userSignInParam) {
        User one = getOne(new LambdaQueryWrapper<User>().eq(User::getEmail, userSignInParam.getEmail()));
        if (one != null) {
            throw new SpaceException(UserExceptionCode.USER_EXIST);
        }

        return save(User.builder().email(userSignInParam.getEmail())
                .password(DigestUtil.md5Hex(userSignInParam.getPassword()))
                .avatar(RandomUtil.randomString(6))
                .nickname(userSignInParam.getNickname())
                .createdAt(new Date())
                .build());
    }

    @Override
    public Boolean logIn(UserLogInParam userLogInParam) {
        User one = getOne(new LambdaQueryWrapper<User>().eq(User::getEmail, userLogInParam.getEmail()));
        if (one != null) {
            throw new SpaceException(UserExceptionCode.USER_EXIST);
        }

        return null;
    }
}
