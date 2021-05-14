package com.cosmos.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cosmos.mapper.AkiUserMapper;
import com.cosmos.mapper.DynamicMapper;
import com.cosmos.pojo.Dynamic;
import com.cosmos.service.DynamicService;
import com.cosmos.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;
    @Autowired
    private AkiUserMapper akiUserMapper;
    @Autowired
    private HttpSession session;
    private final ResponseUtil responseUtil = new ResponseUtil();
    @Override
    public String QueryAllDynamic() {//查询所有动态
        return responseUtil.success(JSON.toJSONString(dynamicMapper.queryAllDynamic()));
    }
    @Override
    public String QueryMyDynamic() {//查询我的动态
        List<String> followers = akiUserMapper.queryMyFollower(session.getAttribute("id").toString());
        QueryWrapper<Dynamic> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",followers);
        queryWrapper.orderByDesc("uploadTime");
        return responseUtil.success(JSON.toJSONString(dynamicMapper.selectList(queryWrapper)));
    }
}
