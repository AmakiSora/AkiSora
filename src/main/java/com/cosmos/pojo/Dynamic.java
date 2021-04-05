package com.cosmos.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Dynamic {//动态类
    @TableId
    @JSONField(name = "NO")
    private Long NO;//动态编号
    @JSONField(name = "id")
    private String id;//用户id
    @JSONField(name = "name")
    private String name;//用户名
    @JSONField(name = "uploadTime",format="yyyy/MM/dd hh:mm")
    private Timestamp uploadTime;//动态时间戳
    @JSONField(name = "content")
    private String content;//内容

}
