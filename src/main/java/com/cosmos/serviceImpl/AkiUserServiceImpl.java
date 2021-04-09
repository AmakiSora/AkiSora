package com.cosmos.serviceImpl;

import com.cosmos.service.AkiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class AkiUserServiceImpl implements AkiUserService {
    @Autowired
    HttpSession session;
    @Override
    public String focus(String id) {
        System.out.println(session.getAttribute("id"));
        return "{code:500}";
    }
}
