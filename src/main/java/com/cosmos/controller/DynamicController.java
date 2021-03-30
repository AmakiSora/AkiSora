package com.cosmos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin//解决跨域问题
@RestController
public class DynamicController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @GetMapping("testRedis1")
    public String testRedis(){

        return "test Success";
    }
}
