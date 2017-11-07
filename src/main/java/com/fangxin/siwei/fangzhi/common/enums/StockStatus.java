package com.fangxin.siwei.fangzhi.common.enums;

import java.util.Objects;

/**
 * @Date:2017/11/7 0007 17:08
 * @Author lu.dong
 * @Description：
 **/
public enum  StockStatus {
    WAIT_VERIFY("WAIT_VERIFY","待验证"),
    STOCK_SUCCESS("STOCK_SUCCESS","已入库"),
    STOCK_FAIL("STOCK_FAIL","验证不通过");

    String code;
    String message;

    StockStatus(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static final StockStatus matching(String code){
        for(StockStatus status : StockStatus.values()){
            if(Objects.equals(status.getCode(), code)) return status;
        }
        return null;
    }
}
