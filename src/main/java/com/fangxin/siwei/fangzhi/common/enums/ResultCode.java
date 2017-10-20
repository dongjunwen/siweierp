package com.fangxin.siwei.fangzhi.common.enums;

import java.util.Objects;

/**
 * Description:
 *
 * @author sheng.wang
 * @version 1.0.0
 * @email sheng.wang@chinaredstar.com
 * @date: 2016-12-16 16:42
 */
public enum ResultCode {

    COMMON_PARAM_NULL("1001","参数为空"),
    COMMON_PARAM_INVALID("1002","参数不合法"),
    COMMON_DATA_EXISTS("1003", "数据已存在"),
    COMMON_DATA_NOT_EXISTS("1004", "数据不存在"),
    COMMON_ORDER_SOURCE_ERROR("1005", "数据来源方不存在"),
    COMMON_QUERY_ERROR("1006", "数据执行SQL查询错误"),
    SUCCESS("200","操作成功"),
    FAIL("500","系统异常"),
	USER_NO_LOGGED_IN("510","用户未登录"),
	FOR_UNAUTHORIZED("511","用户未授权");

    String code;
    String message;

    ResultCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
    public static final ResultCode matching(String code){
    	for(ResultCode resultCode : ResultCode.values()){
    		if(Objects.equals(resultCode.getCode(), code)) return resultCode;
    	}
    	return null;
    }
}
