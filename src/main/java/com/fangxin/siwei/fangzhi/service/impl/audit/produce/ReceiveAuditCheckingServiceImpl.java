package com.fangxin.siwei.fangzhi.service.impl.audit.produce;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.mapper.SwDeliverBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwReceiveBaseMapper;
import com.fangxin.siwei.fangzhi.modal.SwDeliverBase;
import com.fangxin.siwei.fangzhi.modal.SwReceiveBase;
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
public class ReceiveAuditCheckingServiceImpl implements IAuditCheckingService {
    @Resource
    SwReceiveBaseMapper swReceiveBaseMapper;

  /*  @Override
    public AuditTypeEnum getAuditType() {
        return AuditTypeEnum.RECEIVE;
    }*/

    @Override
    public boolean matches(AuditTypeEnum auditTypeEnum) {
        return AuditTypeEnum.RECEIVE.equals(auditTypeEnum);
    }

    @Override
    public Result<String> checking(CurrentStageSearchServiceParam param) {
        Result _result=Result.newSuccess();
        SwReceiveBase swReceiveBase=swReceiveBaseMapper.selectByReceiveNo(param.getSourceNo());
        String status="";
        if(swReceiveBase!=null){
            status=swReceiveBase.getRecvStatus();
        }
        _result.setData(status);
        return _result;
    }
}
