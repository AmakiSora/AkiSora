package com.cosmos.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Trend {
    @TableId
    private Integer NO;
    private String id;
    private String name;
    private String content;
}
