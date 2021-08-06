package com.cosmos.controller;

import com.cosmos.pojo.Dynamic;
import com.cosmos.service.DynamicService;
import com.cosmos.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


@CrossOrigin//解决跨域问题
@RestController
public class DynamicController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private DynamicService dynamicService;
    @GetMapping("/QueryMyDynamic")
    public List<Dynamic> queryMyDynamic(HttpServletResponse httpServletResponse){
        return dynamicService.QueryMyDynamic();
    }
    @GetMapping("/notLogin/QueryRangeDynamic")
    public List<Map<String, Object>> notLoginQueryRangeDynamic(int page, int page_size){
        return dynamicService.QueryRangeDynamic(page,page_size);
    }
}
