package com.workspace.spaceserver.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.jwt.JWTUtil;
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
import java.util.HashMap;
import java.util.Map;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final static String KEY = "aabb";

    @Override
    public Boolean signIn(UserSignInParam userSignInParam) {
        getuser(userSignInParam.getEmail());

        return save(User.builder().email(userSignInParam.getEmail())
                .password(DigestUtil.md5Hex(userSignInParam.getPassword()))
                .avatar(RandomUtil.randomString(6))
                .nickname(userSignInParam.getNickname())
                .createdAt(new Date())
                .build());
    }

    private User getuser(String userSignInParam) {
        User one = getOne(new LambdaQueryWrapper<User>().eq(User::getEmail, userSignInParam));
        if (one != null) {
            throw new SpaceException(UserExceptionCode.USER_EXIST);
        }
        return one;
    }

    @Override
    public String logIn(UserLogInParam userLogInParam) {
        User getuser = getuser(userLogInParam.getEmail());
        if (!getuser.getPassword().equals(DigestUtil.md5Hex(userLogInParam.getPassword()))) {
            throw new SpaceException(UserExceptionCode.LOGIN_ERROR);
        }

        Map<String, Object> payload = new HashMap<>(3);
        payload.put("nickname", getuser.getNickname());
        payload.put("avatar", getuser.getAvatar());
        payload.put("email", getuser.getEmail());
        return JWTUtil.createToken(payload, KEY.getBytes());
    }
}
