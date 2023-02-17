package com.workspace.spaceserver.common;


import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.workspace.spaceserver.common.exception.SpaceException;
import com.workspace.spaceserver.common.exception.code.UserExceptionCode;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;


/**
 * @author nuc
 */
public class BaseController {

    @Value("jwtKey")
    private String jwtKey;

    @Resource
    protected HttpServletRequest request;

    public String getEmail() {
        try {
            String token = request.getHeader("t");
            if (StringUtils.hasText(token)) {
                JWT jwt = JWTUtil.parseToken(token);
                if (jwt.setKey(jwtKey.getBytes()).verify()) {
                    Object uid = jwt.getPayload("email");
                    return uid.toString();
                }
            }
            throw new SpaceException(UserExceptionCode.TOKEN_NOT_EXIST);
        } catch (Exception e) {
            throw new SpaceException(UserExceptionCode.TOKEN_NOT_EXIST);
        }
    }
}