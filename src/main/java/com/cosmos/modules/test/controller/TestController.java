package com.cosmos.modules.test.controller;

import com.cosmos.modules.dynamic.vo.Dynamic;
import com.cosmos.modules.dynamic.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;


@CrossOrigin//解决跨域问题
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private DynamicService dynamicService;
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
    @GetMapping("/t")
    public String t(){
        dynamicService.QueryRangeDynamic(1,2);
        return "sess";
    }


}
