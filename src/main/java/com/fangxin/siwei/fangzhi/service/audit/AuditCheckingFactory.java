package com.fangxin.siwei.fangzhi.service.audit;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/25 0025 17:02
 * @Author lu.dong
 * @Description：审核工厂类
 **/
@Component
public class AuditCheckingFactory  {
    //成员变量，存放所有实现IAuditCheckingService接口的类
    @Autowired
    private List<IAuditCheckingService> auditCheckingServiceList;

    public  IAuditCheckingService getAuditCheckingMapping(AuditTypeEnum auditTypeEnum) {
         for(IAuditCheckingService iAuditCheckingService:auditCheckingServiceList){
             if(iAuditCheckingService.matches(auditTypeEnum)){
                 return iAuditCheckingService;
             }
         }
         return  null;
    }
}
