package com.cosmos.service;

import com.cosmos.pojo.Dynamic;

import java.util.List;
import java.util.Map;

public interface DynamicService {
    List<Map<String, Object>> QueryRangeDynamic(int page, int page_size);//查询部分动态
    List<Dynamic> QueryMyDynamic();//查询我的动态
}
