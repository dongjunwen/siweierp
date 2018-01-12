package com.fangxin.siwei.fangzhi.service.impl.audit.order;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.mapper.SwOrderBaseMapper;
import com.fangxin.siwei.fangzhi.modal.SwOrderBase;
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
public class OrderAuditCheckingServiceImpl implements IAuditCheckingService {
    @Resource
    SwOrderBaseMapper swOrderBaseMapper;

  /*public AuditTypeEnum getAuditType() {
        return AuditTypeEnum.ORDER;
    }*/

    @Override
    public boolean matches(AuditTypeEnum auditTypeEnum) {
        return AuditTypeEnum.ORDER.equals(auditTypeEnum);
    }

    @Override
    public Result<String> checking(CurrentStageSearchServiceParam param) {
        Result _result=Result.newSuccess();
        SwOrderBase swOrderBase=swOrderBaseMapper.selectByOrderNo(param.getSourceNo());
        String status="";
        if(swOrderBase!=null){
            status=swOrderBase.getOrderStatus();
        }
        _result.setData(status);
        return _result;
    }
}
