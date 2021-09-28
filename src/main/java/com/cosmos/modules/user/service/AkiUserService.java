package com.cosmos.modules.user.service;

import com.cosmos.modules.user.vo.AkiUser;
import com.cosmos.utils.ResponseMsg;

public interface AkiUserService {
    ResponseMsg<Integer> followState(String id, Boolean State);
    ResponseMsg<AkiUser> getInfo(String id);
}
