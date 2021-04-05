package com.cosmos.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.cosmos.mapper.AkiUserMapper;
import com.cosmos.mapper.DynamicMapper;
import com.cosmos.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;
    @Autowired
    private AkiUserMapper akiUserMapper;
    @Override
    public String QueryAllTrend() {
        return JSON.toJSONString(dynamicMapper.selectList(null));
    }
    @Override
    public String QueryAllDynamic() { return JSON.toJSONString(dynamicMapper.queryAllDynamic()); }

}
