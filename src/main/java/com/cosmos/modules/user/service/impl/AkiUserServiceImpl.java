package com.cosmos.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cosmos.modules.user.mapper.AkiUserMapper;
import com.cosmos.modules.user.mapper.FollowerMapper;
import com.cosmos.modules.user.vo.AkiUser;
import com.cosmos.modules.user.vo.Follower;
import com.cosmos.modules.user.service.AkiUserService;
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

    @Override
    public ResponseMsg<AkiUser> getInfo(String id) {
        QueryWrapper<AkiUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","name","avatarURL","followNum","fansNum","dynamicNum");
        queryWrapper.eq("id",id);
        return ResponseMsg.success(akiUserMapper.selectOne(queryWrapper));
    }

}
