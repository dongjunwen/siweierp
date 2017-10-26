package com.fangxin.siwei.fangzhi.common.enums;

import java.util.Objects;

/**
 * @Date:2017/10/26 0026 14:25
 * @Author lu.dong
 * @Description：发货单状态
 **/
public enum DeliverStatus {
    WAIT_APPLY("WAIT_APPLY","待申请"),
    WAIT_AUDIT("WAIT_AUDIT","待初审"),
    AUDIT01_SUCCESS("AUDIT01_SUCCESS","初审成功"),
    AUDIT_SUCCESS("AUDIT_SUCCESS","已发货"),
    HAS_CANCEL("HAS_CANCEL","已作废");

    String code;
    String message;

    DeliverStatus(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static final DeliverStatus matching(String code){
        for(DeliverStatus status : DeliverStatus.values()){
            if(Objects.equals(status.getCode(), code)) return status;
        }
        return null;
    }
}
