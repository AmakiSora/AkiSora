package com.cosmos.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.cosmos.mapper.AkiUserMapper;
import com.cosmos.mapper.FollowerMapper;
import com.cosmos.pojo.Follower;
import com.cosmos.service.AkiUserService;
import com.cosmos.utils.ResponseMsg;
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
    @Override
    public ResponseMsg<Integer> followState(String id, Boolean State) {
        Follower follower = new Follower();
        follower.setId(id);
        follower.setFansID(session.getAttribute("id").toString());
        if (State){//关注
            return ResponseMsg.customize(200,"关注成功!",followerMapper.follow(follower));
        }else {//取关
            return ResponseMsg.customize(200,"取关成功!",followerMapper.unfollow(follower));
        }
    }
}
