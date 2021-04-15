package com.cosmos.utils;

/**
 * 响应code：200：成功
 *          401：未授权
 *          403：没有权限
 *          404：未找到资源
 *          500：服务器错误
 */
public class ResponseUtil {//返回工具类
    public String success(String data){//成功，返回数据
        return "{\"code\": 200," +
                "\"data\": " + data + "}";
    }
    public String success(String data,String message){//成功，返回数据和消息
        return "{\"code\": 200," +
                "\"message\": "+ message + ","+
                "\"data\": " + data + "}";
    }
    public String error(){//错误，不返回消息
        return "{\"code\": 500}";
    }
    public String error(String message){//错误，返回消息
        return "{\"code\": 403," +
                "\"message\": "+ message + "}";
    }
}
