package com.fangxin.siwei.fangzhi.common.enums;

import java.util.Objects;

/**
 * @Date:2017/10/26 0026 14:25
 * @Author lu.dong
 * @Description：领料单状态
 **/
public enum ReceiveStatus {
    WAIT_APPLY("WAIT_APPLY","待申请"),
    WAIT_AUDIT("WAIT_AUDIT","待初审"),
    AUDIT01_SUCCESS("AUDIT01_SUCCESS","初审成功"),
    AUDIT_SUCCESS("AUDIT_SUCCESS","已领料"),
    HAS_CANCEL("HAS_CANCEL","已作废");

    String code;
    String message;

    ReceiveStatus(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static final ReceiveStatus matching(String code){
        for(ReceiveStatus status : ReceiveStatus.values()){
            if(Objects.equals(status.getCode(), code)) return status;
        }
        return null;
    }
}
