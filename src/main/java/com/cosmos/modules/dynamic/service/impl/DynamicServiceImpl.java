package com.cosmos.modules.dynamic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cosmos.modules.dynamic.mapper.DynamicMapper;
import com.cosmos.modules.dynamic.service.DynamicService;
import com.cosmos.modules.user.mapper.AkiUserMapper;
import com.cosmos.modules.dynamic.vo.Dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;
    @Autowired
    private AkiUserMapper akiUserMapper;
    @Autowired
    private HttpSession session;
    @Override
    public List<Map<String, Object>> QueryRangeDynamic(int page, int page_size) {//查询部分动态
        return dynamicMapper.queryRangeDynamic(page,page_size);
    }
    @Override
    public List<Dynamic> QueryMyDynamic() {//查询我的动态
        List<String> followers = akiUserMapper.queryMyFollower(session.getAttribute("id").toString());
        QueryWrapper<Dynamic> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",followers);
        queryWrapper.orderByDesc("uploadTime");
        return dynamicMapper.selectList(queryWrapper);
    }
}
