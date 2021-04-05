package com.cosmos.controller;

import com.cosmos.pojo.Dynamic;
import com.cosmos.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin//解决跨域问题
@RestController
public class MainController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private DynamicService dynamicService;

    @GetMapping("/QueryFiveTrend")
    public List<Dynamic> fiveTrend(){
        System.out.println("QueryFiveTrend");
        return dynamicService.QueryAllTrend();
    }
    @GetMapping("/redis/add")
    public String addRedisData(){
        Dynamic dynamic = new Dynamic();
        dynamic.setName("123");
        dynamic.setContent("13523fffvf");
        redisTemplate.opsForValue().set("tr", dynamic);
        redisTemplate.opsForValue().set("ab","tre214nd");
        return "成功";
    }
    @GetMapping("/redis/del")
    public String delRedisData(){
        redisTemplate.delete("name");
        return "成功";
    }


}
