package com.cosmos.service;

import com.cosmos.pojo.AkiUser;
import com.cosmos.utils.ResponseMsg;

public interface AkiUserService {
    ResponseMsg<Integer> followState(String id, Boolean State);
    ResponseMsg<AkiUser> getInfo(String id);
}
