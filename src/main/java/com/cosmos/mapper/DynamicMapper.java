package com.cosmos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cosmos.pojo.Dynamic;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DynamicMapper extends BaseMapper<Dynamic> {
    @Select("select dynamic.* ,akiUser.avatarURL from dynamic,akiUser where dynamic.id = akiUser.id order by uploadTime desc")
    List<Map<String,Object>> queryAllDynamic();

}
