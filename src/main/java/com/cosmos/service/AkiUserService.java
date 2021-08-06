package com.cosmos.service;

import com.cosmos.utils.ResponseMsg;

public interface AkiUserService {
    ResponseMsg<Integer> followState(String id, Boolean State);
}
