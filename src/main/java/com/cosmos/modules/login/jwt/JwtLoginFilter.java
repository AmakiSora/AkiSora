package com.cosmos.modules.login.jwt;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录验证拦截器 --  执行顺序在UsernamePasswordAuthenticationFilter 拦截器后
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        System.out.println("到JwtLoginFilter--------------------");
//        String userName = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println(userName);
//        System.out.println(password);
//        //创建未认证的凭证(etAuthenticated(false)),注意此时凭证中的主体principal为用户名
//        JwtLoginToken jwtLoginToken = new JwtLoginToken(userName, password);
//        //将认证详情(ip,sessionId)写到凭证
//        jwtLoginToken.setDetails(new WebAuthenticationDetails(request));
//        //AuthenticationManager获取受支持的AuthenticationProvider(这里也就是JwtAuthenticationProvider),
//        //生成已认证的凭证,此时凭证中的主体为userDetails  --- 这里会委托给AuthenticationProvider实现类来验证
//        // 即 跳转到 JwtAuthenticationProvider.authenticate 方法中认证
//        return this.getAuthenticationManager().authenticate(jwtLoginToken);
//    }
    private boolean postOnly = true;

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String username = this.obtainUsername(request);
            username = username != null ? username : "";
            username = username.trim();
            String password = this.obtainPassword(request);
            password = password != null ? password : "";
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
    }
}
}
