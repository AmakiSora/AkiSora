package com.cosmos.config;

import com.cosmos.serviceImpl.LoginFailureHandler;
import com.cosmos.serviceImpl.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean//密码加密
    public PasswordEncoder pw(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Override//授权
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//表单登录
                .successHandler(loginSuccessHandler)//登录成功处理
                .failureHandler(loginFailureHandler)//登录失败处理
        ;
        http.authorizeRequests()//对请求授权
                .antMatchers("/login","/404").permitAll()//放行请求
                .anyRequest().authenticated()//拦截所有请求
        ;
        http.sessionManagement()//会话
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)//会话配置，默认需要用时创建会话
                .invalidSessionUrl("/Timeout")//会话超时后跳转
                .sessionFixation().migrateSession()//会话保护方式，默认每次登录账户都创建新会话，旧会话无效，将旧会话属性存进新会话中
        ;
    }
}
