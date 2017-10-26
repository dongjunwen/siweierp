package com.fangxin.siwei.fangzhi.service.impl.audit.order;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.mapper.SwDeliverBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwOrderBaseMapper;
import com.fangxin.siwei.fangzhi.modal.SwDeliverBase;
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
public class DeliverAuditCheckingServiceImpl implements IAuditCheckingService {
    @Resource
    SwDeliverBaseMapper swDeliverBaseMapper;

    @Override
    public AuditTypeEnum getAuditType() {
        return AuditTypeEnum.DELIVER;
    }

    @Override
    public Result<String> checking(CurrentStageSearchServiceParam param) {
        Result _result=Result.newSuccess();
        SwDeliverBase swDeliverBase=swDeliverBaseMapper.selectByDeliverNo(param.getSourceNo());
        String status="";
        if(swDeliverBase!=null){
            status=swDeliverBase.getDeilverStatus();
        }
        _result.setData(status);
        return _result;
    }
}
