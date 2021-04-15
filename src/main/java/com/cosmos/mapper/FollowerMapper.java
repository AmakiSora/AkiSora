package com.cosmos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cosmos.pojo.Follower;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerMapper extends BaseMapper<Follower> {
    @Insert("replace into followers (id,fansID) values(#{id},#{fansID})")
    int follow(Follower follower);
    @Update("update followers set state = 0 where id = #{id} and fansID = #{fansID}")
    int unfollow(Follower follower);
}
