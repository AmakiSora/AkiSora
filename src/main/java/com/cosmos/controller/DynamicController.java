package com.cosmos.controller;

import com.cosmos.pojo.Dynamic;
import com.cosmos.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin//解决跨域问题
@RestController
public class DynamicController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private DynamicService dynamicService;
    @GetMapping("/QueryAllTrend")
    public List<Dynamic> trend(HttpServletResponse httpServletResponse){
        System.out.println("QueryAllTrend");
        return dynamicService.QueryAllTrend();
    }
    @GetMapping("/notLogin/QueryAllTrend")
    public List<Dynamic> dtrend(){
        System.out.println("QueryAllTrend");
        return dynamicService.QueryAllTrend();
    }
    @GetMapping("testRedis1")
    public String testRedis(){

        return "test Success";
    }
}
