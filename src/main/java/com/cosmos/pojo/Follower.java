package com.cosmos.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("followers")
public class Follower {//关注类
    @TableId
    @JSONField(name = "NO")
    private Long NO;//编号
    @JSONField(name = "id")
    private String id;//用户id
    @JSONField(name = "fansID")
    private String fansID;//粉丝id
}
