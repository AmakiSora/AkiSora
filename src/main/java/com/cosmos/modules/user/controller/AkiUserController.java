package com.cosmos.modules.user.controller;

import com.cosmos.modules.user.vo.AkiUser;
import com.cosmos.modules.user.service.AkiUserService;
import com.cosmos.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AkiUserController {
    @Autowired
    private AkiUserService akiUserService;
    @GetMapping("/follow/{id}")//关注操作
    public ResponseMsg<Integer> follow(@PathVariable String id){
        return akiUserService.followState(id,true);
    }
    @GetMapping("/unfollow/{id}")//取关操作
    public ResponseMsg<Integer> unfollow(@PathVariable String id){
        return akiUserService.followState(id,false);
    }
    @GetMapping("/getInfo/{id}")//获取用户信息
    public ResponseMsg<AkiUser> getInfo(@PathVariable String id){ return akiUserService.getInfo(id); }
}
