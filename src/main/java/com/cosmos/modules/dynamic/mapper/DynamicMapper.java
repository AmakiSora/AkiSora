package com.cosmos.modules.dynamic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cosmos.modules.dynamic.vo.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface DynamicMapper extends BaseMapper<Dynamic> {
    @Select("select dynamic.* ,akiUser.avatarURL from dynamic,akiUser where dynamic.id = akiUser.id order by uploadTime desc limit #{page},#{page_size}")
    List<Map<String,Object>> queryRangeDynamic(int page,int page_size);

}
