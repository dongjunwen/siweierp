package com.fangxin.siwei.fangzhi.common.utils;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * @Date:2017/10/24 0024 16:10
 * @Author lu.dong
 * @Description：
 **/
public class UUIDUtils {
    /**
     * 按照类型生成UUID
     * @param type 单据类型
     * @return
     */
    public static String genUUID(String type){
        int randomNum= RandomUtils.nextInt(1,99999);
        return type+"-"+DateUtil.formatCurrentDateTime1()+"-"+String.format("%05d", randomNum);
    }

    public static void main(String[] args) {
        System.err.println(UUIDUtils.genUUID("D"));
    }
}
