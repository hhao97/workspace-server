package com.workspace.spaceserver;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpaceServerApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        String key = "aabb";
        String token = "eyJ0eXAiOiJKV1QiLCJhbAciOiJIUzI1NiJ9.eyJwYXNzV29yZCI6IjY2Njg4OSIsIm5iZiI6MTYzNTE1MDI3NiwiZXhwIjoxNjM1MTUwODc2LCJ1c2VyTmFtZSI6InpoYW5nc2FuIiwiaWF0IjoxNjM1MTUwMjc2fQ.Cq2AHyrZ-Q7U7O5BBPdEIBrm7aDtjQh4ZDvtIcLzQvg";
//        JWT jwt = JWTUtil.parseToken(token);
//

//
//        Object uid = jwt.getPayload("userName");
//        System.out.println((String) uid);


        JWT jwt = JWT.of(token);
        Object uid = jwt.getPayload("userName");

        boolean verifyKey = jwt.setKey(key.getBytes()).verify();
        System.out.println(verifyKey);

        System.out.println((String) uid);
    }

}
