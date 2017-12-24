package com.fangxin.siwei.fangzhi.common.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * @Date:2017/12/24 0024 14:08
 * @Author lu.dong
 * @Description：
 **/
public class BeanUtilsEx extends BeanUtils {
    private static final Logger logger= LoggerFactory.getLogger(BeanUtilsEx.class);
    static {
        ConvertUtils.register(new DateConvert(), java.util.Date.class);
        ConvertUtils.register(new DateConvert(), String.class);
    }

    public static void copyProperties(Object target, Object source) {
        // 支持对日期copy
        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
        } catch (IllegalAccessException | InvocationTargetException e) {
           logger.error("扩展BeanUtils.copyProperties支持data类型:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
