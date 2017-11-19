package com.fangxin.siwei.fangzhi.common.enums;

import java.util.Objects;

/**
 * @Date:2017/10/25 0025 14:14
 * @Author lu.dong
 * @Description：
 **/
public enum OrderStatus {
    WAIT_APPLY("WAIT_APPLY","待初审"),
    HAS_CANCEL("HAS_CANCEL","已作废"),
    AUDIT01_SUCCESS("AUDIT01_SUCCESS","初审成功"),
    AUDIT_SUCCESS("AUDIT_SUCCESS","终审成功"),
    ORDER_FINISH("ORDER_FINISH","订单结束");

    String code;
    String message;

    OrderStatus(String code, String message){
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
