package com.fangxin.siwei.fangzhi.service.audit;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date:2017/10/25 0025 17:02
 * @Author lu.dong
 * @Description：审核工厂类
 * 废弃改类 较厚重
 **/
//@Component
public class AuditCheckingFactoryOld implements ApplicationContextAware {
    //成员变量，存放所有实现IAuditCheckingService接口的类
    private Map<AuditTypeEnum, IAuditCheckingService> auditCheckingMapping;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String,IAuditCheckingService> _checkMap=applicationContext.getBeansOfType(IAuditCheckingService.class);
        auditCheckingMapping=new HashMap<>();
       // _checkMap.forEach()
        for(Map.Entry<String,IAuditCheckingService> checkValue:_checkMap.entrySet()){
          //  auditCheckingMapping.put(checkValue.getValue().getAuditType(),checkValue.getValue());
        }
    }

    public  IAuditCheckingService getAuditCheckingMapping(AuditTypeEnum auditTypeEnum) {
        return auditCheckingMapping.get(auditTypeEnum);
    }
}
