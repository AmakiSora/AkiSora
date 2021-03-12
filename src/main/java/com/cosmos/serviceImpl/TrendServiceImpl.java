package com.cosmos.serviceImpl;

import com.cosmos.mapper.Mapper;
import com.cosmos.pojo.Trend;
import com.cosmos.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrendServiceImpl implements TrendService {
    @Autowired
    private Mapper mapper;
    @Override
    public List<Trend> QueryAllTrend() {
        return mapper.selectList(null);
    }
}
