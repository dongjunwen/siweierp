package com.fangxin.siwei.fangzhi.common.enums;


/**
 * Created by donglu
 * Date: 2017/2/10.
 * Time: 17:32
 * Desc:
 */
public enum AuditTypeEnum {

    ORDER("ORDER","业务订单");

    String code;
    String desc;

    AuditTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static AuditTypeEnum parse(String code){
        for (AuditTypeEnum tmpEnum : values()){
            if (tmpEnum.getCode().equals(code)){
                return tmpEnum;
            }
        }
        return null;
    }
}
