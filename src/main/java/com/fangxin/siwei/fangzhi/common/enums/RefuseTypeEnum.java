package com.fangxin.siwei.fangzhi.common.enums;

import java.util.Objects;

/**
 * @Date:2017/11/10 0010 15:02
 * @Author lu.dong
 * @Description：
 **/
public enum RefuseTypeEnum {

    RETURN("RETURN","退货"),
    BUJI("BUJI","补给"),
    FANXIU("FANXIU","返修");

    String code;
    String message;

    RefuseTypeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static final RefuseTypeEnum matching(String code){
        for(RefuseTypeEnum status : RefuseTypeEnum.values()){
            if(Objects.equals(status.getCode(), code)) return status;
        }
        return null;
    }
}
