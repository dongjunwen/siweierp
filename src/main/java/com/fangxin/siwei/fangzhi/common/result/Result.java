package com.fangxin.siwei.fangzhi.common.result;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;

import java.io.Serializable;

/**
 * @Date:2017/10/19 0019 17:48
 * @Author lu.dong
 * @Description：
 **/
public class Result<T> implements Serializable{
    /**
     * 返回代码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 是否成功
     */
    private boolean success;

    public static <T> Result<T> newSuccess(){
        return newSuccess(ResultCode.SUCCESS,null);
    }

    public static <T> Result<T> newSuccess(T data){
        return newSuccess(ResultCode.SUCCESS,data);
    }

    public static <T> Result<T> newSuccess(ResultCode resultCode, T data){
        return new Result<>(resultCode.getCode(),resultCode.getMessage(),true,data);
    }

    public static <T> Result<T> newError(ResultCode resultCode){
        return new Result<>(resultCode.getCode(),resultCode.getMessage(),false,null);
    }
    public static <T> Result<T> newError(String code,String msg){
        return new Result<>(code,msg,false,null);
    }

    public Result<T> setErrorCode(ResultCode resultCode){
        this.success = false;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        return this;
    }

    public Result<T> setError(String code,String msg){
        this.success = false;
        this.code = code;
        this.message = msg;
        return this;
    }

    public Result(String code, String message, boolean success, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", success=" + success +
                '}';
    }
}
