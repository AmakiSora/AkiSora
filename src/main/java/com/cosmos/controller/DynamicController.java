package com.cosmos.controller;

import com.cosmos.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@CrossOrigin//解决跨域问题
@RestController
public class DynamicController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private DynamicService dynamicService;
    @GetMapping("/QueryAllTrend")
    public String trend(HttpServletResponse httpServletResponse){
        return dynamicService.QueryAllTrend();
    }
    @GetMapping("/notLogin/QueryAllDynamic")
    public String QueryAllDynamic(){
        return dynamicService.QueryAllDynamic();
    }
    @GetMapping("testRedis1")
    public String testRedis(){

        return "test Success";
    }
}
