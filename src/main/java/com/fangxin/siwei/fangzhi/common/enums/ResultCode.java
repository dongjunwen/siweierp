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

    //基础资料 1100-1199
    USER_PASS_NOT_EQUAL("1100","两次密码不一致"),
    USER_OLD_PASS_ERROR("1101","原始密码错误"),
    // 审核流程错误码 1300 -- 1399
    AUDIT_ERROR_NO_CONFIG("1300", "审核流程不允许"),
    AUDIT_CURRENT_STAGE_ERROR("1301", "当前状态不可操作"),
    AUDIT_CHECKING_ERROR("1302", "审核检查不通过"),
    AUDIT_DOES_NOT_EXIST("1310", "审核状态不存在"),
    AUDIT_ERROR_FOR_OTHER_DEPART("1311", "不能审核其他部门的数据"),



    SUCCESS("200","操作成功"),
    FAIL("500","系统异常"),
	USER_NO_LOGGED_IN("510","用户未登录"),
	FOR_UNAUTHORIZED("511","用户未授权"),
    USERNAME_OR_PASS_ERR("512","用户名或密码错误");

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
