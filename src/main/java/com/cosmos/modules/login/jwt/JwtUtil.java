package com.cosmos.modules.login.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;

import java.util.Date;

/**
 * token生成和验证
 */
public class JwtUtil {
    private static final String SALT = "COSMOS";//盐
    private static final long TIME = 2 * 60 * 60 * 1000;//过期时间长度(2小时)
    public String createToken(String id,String user){
        long now = System.currentTimeMillis();
        long expiration = now + TIME;//过期时间
        JwtBuilder jwtBuilder = Jwts.builder()
                //声明的标识{"jti":"xxxx"}
                .setId(id)
                //主体，用户{"sub":"Rose"}
                .setSubject(user)
                //创建日期{"ita":"xxxxxxxxx"}
                .setIssuedAt(new Date())
                //签名算法，后面是盐
                .signWith(SignatureAlgorithm.HS256,SALT)
                //过期时间
                .setExpiration(new Date(expiration))
                //设定自定义申明
//                .claim("性别","男")
                //用map添加
//                .addClaims()
                ;
        String token = jwtBuilder.compact();
//        System.out.println(token);
//        String[] split = token.split("\\.");
//        //头部
//        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
//        //负载
//        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
//        //签名(没有盐无法解密)
//        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
        return token;
    }
    public void parseToken(String token) throws Exception{//解析token
        //获取claims(荷载)
        Claims claims = Jwts.parser()
                .setSigningKey(SALT)
                .parseClaimsJws(token)
                .getBody()//获取
        ;
//        System.out.println(claims.getId());
//        System.out.println(claims.getSubject());
//        System.out.println(claims.getIssuedAt());
//        System.out.println(claims.getExpiration());
//        System.out.println(claims.get(""));//获取自定义申明
    }
}
