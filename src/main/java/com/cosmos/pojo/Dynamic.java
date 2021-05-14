package com.cosmos.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("dynamic")
public class Dynamic {//动态类
    @TableId
    @JSONField(name = "NO")
    private Long NO;//动态编号
    @JSONField(name = "id")
    private String id;//用户id
    @JSONField(name = "name")
    private String name;//用户名
    @JSONField(name = "type")
    private String type;//动态类型
    @JSONField(name = "uploadTime",format="yyyy/MM/dd hh:mm")
    private Timestamp uploadTime;//动态时间戳
    @JSONField(name = "content")
    private String content;//内容
    @TableLogic//逻辑删
    @JSONField(name = "state")
    private int state;//状态 默认为1 删除为0

}
