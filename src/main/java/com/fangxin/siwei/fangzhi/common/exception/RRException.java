package com.fangxin.siwei.fangzhi.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lu.dong on 2017/8/9.
 * 自定义异常
 */
public class RRException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code;

    private String err;

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public RRException(String err){
        super(err);
        this.err=err;
    }

    public RRException(String code,String err){
        this.code=code;
        this.err=err;
    }

    public RRException(String err,HttpStatus status){
        this.status=status;
        this.err=err;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}