package com.cosmos.serviceImpl;

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
