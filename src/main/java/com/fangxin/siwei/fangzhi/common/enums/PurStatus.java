package com.fangxin.siwei.fangzhi.common.enums;

import java.util.Objects;

/**
 * @Date:2017/11/2 0002 14:18
 * @Author lu.dong
 * @Description：
 **/
public enum PurStatus {

    WAIT_AUDIT("WAIT_AUDIT","待初审"),
    AUDIT01_SUCCESS("AUDIT01_SUCCESS","初审成功"),
    AUDIT_SUCCESS("AUDIT_SUCCESS","终审成功"),
    ORDER_FINISH("ORDER_FINISH","采购结束");

    String code;
    String message;

    PurStatus(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static final OrderStatus matching(String code){
        for(OrderStatus status : OrderStatus.values()){
            if(Objects.equals(status.getCode(), code)) return status;
        }
        return null;
    }
}
