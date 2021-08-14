package com.cosmos.utils;

import lombok.Data;

@Data
public class ResponseMsg<T> {
    private int code;//状态值
    private String message;//描述信息
    private T data;//数据
    //成功,仅返回数据
    public static <T>ResponseMsg<T> success(T data){
        ResponseMsg<T> responseMsg = new ResponseMsg<>();
        responseMsg.setCode(Code.SUCCESS.code);
        responseMsg.setData(data);
        return responseMsg;
    }
    //成功,返回数据和提示
    public static <T>ResponseMsg<T> success(T data,String msg){
        ResponseMsg<T> responseMsg = new ResponseMsg<>();
        responseMsg.setCode(Code.SUCCESS.code);
        responseMsg.setMessage(msg);
        responseMsg.setData(data);
        return responseMsg;
    }
    //失败,不返回数据
    public static <T> ResponseMsg<T> fail() {
        ResponseMsg<T> responseMsg = new ResponseMsg<>();
        responseMsg.setCode(Code.FAIL.code);
        responseMsg.setMessage(Code.FAIL.msg);
        return responseMsg;
    }
    //错误,不返回数据
    public static <T> ResponseMsg<T> error() {
        ResponseMsg<T> responseMsg = new ResponseMsg<>();
        responseMsg.setCode(Code.ERROR.code);
        responseMsg.setMessage(Code.ERROR.msg);
        return responseMsg;
    }
    //自定义返回(无数据)
    public static <T> ResponseMsg<T> customize(int code,String msg) {
        ResponseMsg<T> responseMsg = new ResponseMsg<>();
        responseMsg.setCode(code);
        responseMsg.setMessage(msg);
        return responseMsg;
    }
    //自定义返回(带数据)
    public static <T> ResponseMsg<T> customize(int code,String msg,T data) {
        ResponseMsg<T> responseMsg = new ResponseMsg<>();
        responseMsg.setCode(code);
        responseMsg.setMessage(msg);
        responseMsg.setData(data);
        return responseMsg;
    }
    enum Code{
        SUCCESS(200,"成功"),
        FAIL(999,"失败"),
        ERROR(500,"错误");
        private final int code;
        private final String msg;
        Code(int code,String msg){
            this.code = code;
            this.msg = msg;
        }
    }
}