package com.fangxin.siwei.fangzhi.service.impl.audit.purchase;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.mapper.SwDeliverBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwPurchaseBaseMapper;
import com.fangxin.siwei.fangzhi.modal.SwDeliverBase;
import com.fangxin.siwei.fangzhi.modal.SwPurchaseBase;
import com.fangxin.siwei.fangzhi.service.audit.CurrentStageSearchServiceParam;
import com.fangxin.siwei.fangzhi.service.audit.IAuditCheckingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date:2017/10/25 0025 17:10
 * @Author lu.dong
 * @Description：
 **/
@Service
public class PurchaseAuditCheckingServiceImpl implements IAuditCheckingService {
    @Resource
    SwPurchaseBaseMapper swPurchaseBaseMapper;

   /* @Override
    public AuditTypeEnum getAuditType() {
        return AuditTypeEnum.PURCHASE;
    }*/

    @Override
    public boolean matches(AuditTypeEnum auditTypeEnum) {
        return AuditTypeEnum.PURCHASE.equals(auditTypeEnum);
    }

    @Override
    public Result<String> checking(CurrentStageSearchServiceParam param) {
        Result _result=Result.newSuccess();
        SwPurchaseBase swPurchaseBase=swPurchaseBaseMapper.selectByPurNo(param.getSourceNo());
        String status="";
        if(swPurchaseBase!=null){
            status=swPurchaseBase.getPurStatus();
        }
        _result.setData(status);
        return _result;
    }
}
