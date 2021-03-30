package com.cosmos.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("akiUser")
public class AkiUser {//用户类
    private String id;//帐号
    private String name;//用户名
    private String password;//密码
    private String avatarURL;//头像地址
}
