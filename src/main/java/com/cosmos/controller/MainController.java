package com.cosmos.controller;

import com.cosmos.pojo.Trend;
import com.cosmos.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin//解决跨域问题
@RestController
public class MainController {
    @Autowired
    private TrendService trendService;
    @GetMapping("/QueryAllTrend")
    public List<Trend> trend(){
        return trendService.QueryAllTrend();
    }
}
