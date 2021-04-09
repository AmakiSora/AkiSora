package com.cosmos.serviceImpl.authorizeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {//登录成功处理
    @Autowired
    HttpSession session;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)throws IOException {
        System.out.println("登录成功");
        session.setAttribute("id",authentication.getName());
//        response.setHeader("Access-Control-Allow-Origin","http://localhost:9999");
//        response.setHeader("Access-Control-Allow-Credentials","true");
    }
}
