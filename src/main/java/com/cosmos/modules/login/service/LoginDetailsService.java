package com.cosmos.modules.login.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cosmos.modules.user.mapper.AkiUserMapper;
import com.cosmos.modules.user.vo.AkiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginDetailsService implements UserDetailsService {//登录处理
    @Autowired
    private AkiUserMapper akiUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;//加密
//    private QueryWrapper<AkiUser> akiUserQueryWrapper = new QueryWrapper<>();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<AkiUser> akiUserQueryWrapper = new QueryWrapper<>();
        akiUserQueryWrapper.eq("id",username).select("id","password");
        AkiUser akiUser =  akiUserMapper.selectOne(akiUserQueryWrapper);
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户不能为空");
        }
        if(akiUser==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        String password = passwordEncoder.encode(akiUser.getPassword());
        return new User(username, password,AuthorityUtils
                .commaSeparatedStringToAuthorityList("角色"));
    }
}
