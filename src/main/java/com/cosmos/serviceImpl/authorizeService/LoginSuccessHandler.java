package com.cosmos.serviceImpl.authorizeService;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cosmos.mapper.AkiUserMapper;
import com.cosmos.pojo.AkiUser;
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
    private HttpSession session;
    @Autowired
    private AkiUserMapper akiUserMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)throws IOException {
        System.out.println("登录成功");
        QueryWrapper<AkiUser> akiUser = new QueryWrapper<>();
        //todo 取消session
        session.setAttribute("id",authentication.getName());
        akiUser.select(AkiUser.class,info->!info.getProperty().equals("password")).eq("id",authentication.getName());
        String s = JSON.toJSONString(akiUserMapper.selectOne(akiUser));//用户信息
        JwtUtil jwtUtil = new JwtUtil();
        String token = "\""+jwtUtil.createToken("nmsl","zfg")+"\"";
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(success(token));
//        response.setHeader("Access-Control-Allow-Origin","http://localhost:9999");
//        response.setHeader("Access-Control-Allow-Credentials","true");
    }
    private String success(String data){//成功，返回数据
        return "{\"code\": 200," +
                "\"token\": " + data + "}";
    }
}
