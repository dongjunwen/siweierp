package com.fangxin.siwei.fangzhi.common.enums;

import java.util.Objects;

/**
 * @Date:2017/10/25 0025 14:33
 * @Author lu.dong
 * @Description：审核动作
 **/
public enum AuditActionEnum {
    AUDIT_PASS("AUDIT_PASS", "通过"),
    AUDIT_REFUSE("AUDIT_REFUSE", "拒绝");

    String code;
    String message;

    AuditActionEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static final AuditActionEnum matching(String code){
        for(AuditActionEnum status : AuditActionEnum.values()){
            if(Objects.equals(status.getCode(), code)) return status;
        }
        return null;
    }
}
