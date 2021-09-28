package com.cosmos.modules.login.jwt;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token有效性验证拦截器
 */
public class JwtTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("token");
        if (token == null)
            return;
        try{
            JwtUtil jwtUtil = new JwtUtil();
            jwtUtil.parseToken(token);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("失效");
            //todo 失效后返回前端的信息
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);//放行

//        try {
//            String token = httpServletRequest.getHeader("Authentication");
//            if (StringUtils.isEmpty(token)) {
//                httpServletResponse.setContentType("application/json;charset=UTF-8");
//                JsonResult<String> jsonResult = new JsonResult<>();
//                jsonResult.setFail(JsonResponseStatus.TokenFail.getCode(), "未登录");
//                httpServletResponse.getWriter().write(JSON.toJSONString(jsonResult));
//                return;
//            }
//
//            Claims claims = JwtUtils.parseJWT(token);
//            if (JwtUtils.isTokenExpired(claims)) {
//                httpServletResponse.setContentType("application/json;charset=UTF-8");
//                JsonResult<String> jsonResult = new JsonResult<>();
//                jsonResult.setFail(JsonResponseStatus.TokenFail.getCode(), "登陆失效，请重新登陆");
//                httpServletResponse.getWriter().write(JSON.toJSONString(jsonResult));
//                return;
//            }
//
//            JwtUserDetails user = JSON.parseObject(claims.get("userDetails", String.class), JwtUserDetails.class);
//            JwtLoginToken jwtLoginToken = new JwtLoginToken(user, "", user.getAuthorities());
//            jwtLoginToken.setDetails(new WebAuthenticationDetails(httpServletRequest));
//            SecurityContextHolder.getContext().setAuthentication(jwtLoginToken);
//            filterChain.doFilter(httpServletRequest, httpServletResponse);//放行
//        } catch (Exception e) {
//            throw new BadCredentialsException("登陆凭证失效，请重新登陆");
//        }

    }

}
