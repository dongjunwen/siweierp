package com.fangxin.siwei.fangzhi.service.impl.audit.purchase;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.mapper.SwPurchaseBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwReturnBaseMapper;
import com.fangxin.siwei.fangzhi.modal.SwPurchaseBase;
import com.fangxin.siwei.fangzhi.modal.SwReturnBase;
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
public class ReturnAuditCheckingServiceImpl implements IAuditCheckingService {
    @Resource
    SwReturnBaseMapper swReturnBaseMapper;

   /* @Override
    public AuditTypeEnum getAuditType() {
        return AuditTypeEnum.RETURN;
    }*/

    @Override
    public boolean matches(AuditTypeEnum auditTypeEnum) {
        return AuditTypeEnum.RETURN.equals(auditTypeEnum);
    }

    @Override
    public Result<String> checking(CurrentStageSearchServiceParam param) {
        Result _result=Result.newSuccess();
        SwReturnBase swReturnBase=swReturnBaseMapper.selectByReturnNo(param.getSourceNo());
        String status="";
        if(swReturnBase!=null){
            status=swReturnBase.getReturnStatus();
        }
        _result.setData(status);
        return _result;
    }
}
