package com.cosmos.modules.user.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("followers")
public class Follower {//关注类
    @JSONField(name = "id")
    private String id;//用户id
    @JSONField(name = "fansID")
    private String fansID;//粉丝id
    @TableLogic//逻辑删
    @JSONField(name = "state")
    private Integer state;//状态 0:未关注 1:f关注i   数据库默认1
}
