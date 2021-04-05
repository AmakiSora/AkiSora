package com.cosmos.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Dynamic {//动态类
    @TableId
    private Long NO;//动态编号
    private String id;//用户id
    private String name;//用户名
    private Timestamp uploadTime;//动态时间戳
    private String content;//内容
}
