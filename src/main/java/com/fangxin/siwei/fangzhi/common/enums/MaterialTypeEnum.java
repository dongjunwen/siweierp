package com.fangxin.siwei.fangzhi.common.enums;

/**
 * @Date:2017/11/5 0005 15:55
 * @Author lu.dong
 * @Description：
 **/
public enum  MaterialTypeEnum {

    PROD("PROD","成品布"),
    COTTON ("COTTON","面料"),
    PURCHASE("CRAFTS","工艺");

    String code;
    String desc;

    MaterialTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static MaterialTypeEnum parse(String code){
        for (MaterialTypeEnum tmpEnum : values()){
            if (tmpEnum.getCode().equals(code)){
                return tmpEnum;
            }
        }
        return null;
    }

}
