package com.cosmos.modules.user.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("akiUser")
public class AkiUser {//用户类
    @JSONField(name = "id")
    private String id;//帐号
    @JSONField(name = "name")
    private String name;//用户名
    @JSONField(name = "password")
    private String password;//密码
    @JSONField(name = "avatarURL")
    private String avatarURL;//头像地址
    @JSONField(name = "followNum")
    private int followNum;//关注数
    @JSONField(name = "fansNum")
    private int fansNum;//粉丝数
    @JSONField(name = "dynamicNum")
    private int dynamicNum;//动态数
}
