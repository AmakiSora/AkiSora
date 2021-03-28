package com.cosmos.controller;

import com.cosmos.pojo.Trend;
import com.cosmos.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin//解决跨域问题
@RestController
public class MainController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private TrendService trendService;
    @GetMapping("/QueryAllTrend")
    public List<Trend> trend(){
        System.out.println("QueryAllTrend");
        return trendService.QueryAllTrend();
    }
    @GetMapping("/QueryFiveTrend")
    public List<Trend> fiveTrend(){
        System.out.println("QueryFiveTrend");
        return trendService.QueryAllTrend();
    }
    @GetMapping("/redis/add")
    public String addRedisData(){
        Trend trend = new Trend();
        trend.setName("123");
        trend.setContent("13523fffvf");
        redisTemplate.opsForValue().set("tr",trend);
        redisTemplate.opsForValue().set("ab","tre214nd");
        return "成功";
    }
    @GetMapping("/redis/del")
    public String delRedisData(){
        redisTemplate.delete("name");
        return "成功";
    }


}
