package com.cosmos.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.cosmos.mapper.AkiUserMapper;
import com.cosmos.mapper.DynamicMapper;
import com.cosmos.service.DynamicService;
import com.cosmos.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;
    @Autowired
    private AkiUserMapper akiUserMapper;
    private final ResponseUtil responseUtil = new ResponseUtil();
    @Override
    public String QueryAllTrend() {
        return JSON.toJSONString(dynamicMapper.selectList(null));
    }
    @Override
    public String QueryAllDynamic() {
        return responseUtil.success(JSON.toJSONString(dynamicMapper.queryAllDynamic()));
    }

}
