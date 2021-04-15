package com.cosmos.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.cosmos.mapper.AkiUserMapper;
import com.cosmos.mapper.FollowerMapper;
import com.cosmos.pojo.Follower;
import com.cosmos.service.AkiUserService;
import com.cosmos.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class AkiUserServiceImpl implements AkiUserService {
    @Autowired
    private HttpSession session;
    @Autowired
    private AkiUserMapper akiUserMapper;
    @Autowired
    private FollowerMapper followerMapper;
    private final ResponseUtil responseUtil = new ResponseUtil();
    @Override
    public String followState(String id,Boolean State) {
        Follower follower = new Follower();
        follower.setId(id);
        follower.setFansID(session.getAttribute("id").toString());
        if (State){//关注
            return responseUtil.success(JSON.toJSONString(followerMapper.follow(follower)),JSON.toJSONString("关注成功"));
        }else {//取关
            return responseUtil.success(JSON.toJSONString(followerMapper.unfollow(follower)),JSON.toJSONString("取关成功"));
        }
    }
}
