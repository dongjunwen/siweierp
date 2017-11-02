package com.fangxin.siwei.fangzhi.common.enums;


/**
 * Created by donglu
 * Date: 2017/2/10.
 * Time: 17:32
 * Desc:审核类型
 */
public enum AuditTypeEnum {

    ORDER("ORDER","业务订单"),
    DELIVER("DELIVER","发货单"),
    PURCHASE("PUR","采购单");

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
