package com.cosmos.config;

import com.cosmos.serviceImpl.authorizeService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean//密码加密
    public PasswordEncoder pw(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private LoginDetailsHandler loginDetailsHandler;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    private AuthorizeSessionInformationExpiredStrategy authorizeSessionInformationExpiredStrategy;
    @Autowired
    private NoAccessHandler noAccessHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginDetailsHandler);//登录处理
    }
    @Override//授权
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//表单登录
                .permitAll()//允许所有用户
                .loginPage("/login")
//                .loginProcessingUrl("/login")
                .successHandler(loginSuccessHandler)//登录成功处理
                .failureHandler(loginFailureHandler)//登录失败处理
        ;
        http.authorizeRequests()//对请求授权
                .antMatchers("/login","/notLogin/**").permitAll()//放行请求
                .anyRequest().authenticated()//拦截所有请求
        ;
        http.exceptionHandling()//异常处理(权限拒绝、登录失效等)
                .authenticationEntryPoint(noAccessHandler)//匿名用户访问无权限资源时的异常处理(未登录)
        ;
        http.sessionManagement()//会话
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)//会话配置，默认需要用时创建会话
                .invalidSessionUrl("/Timeout")//会话超时后跳转
                .sessionFixation().migrateSession()//会话保护方式，默认每次登录账户都创建新会话，旧会话无效，将旧会话属性存进新会话中
                .maximumSessions(1)//限制同一账号只能有一个session
                .expiredSessionStrategy(authorizeSessionInformationExpiredStrategy)//处理账号被挤下线处理逻辑,会话信息过期策略
        ;
        http.csrf().disable()//关闭csrf(跨站请求劫持)防护
                .cors();//开启跨域
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {//跨域设置
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:9999"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
