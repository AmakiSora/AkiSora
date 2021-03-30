package com.cosmos.serviceImpl;

import com.cosmos.mapper.DynamicMapper;
import com.cosmos.pojo.Dynamic;
import com.cosmos.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;
    @Override
    public List<Dynamic> QueryAllTrend() {
        return dynamicMapper.selectList(null);
    }
}
