package com.cosmos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cosmos.pojo.AkiUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AkiUserMapper extends BaseMapper<AkiUser> {
    @Select("select id from followers where fansID = #{id} and state = 1")
    List<String> queryMyFollower(@Param("id") String id);
}
