package com.fangxin.siwei.fangzhi.service.impl.audit.stock;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.mapper.SwOrderBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwStockVerifyMapper;
import com.fangxin.siwei.fangzhi.modal.SwOrderBase;
import com.fangxin.siwei.fangzhi.modal.SwStockVerify;
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
public class StockVerifyCheckingServiceImpl implements IAuditCheckingService {
    @Resource
    SwStockVerifyMapper swStockVerifyMapper;

   /* @Override
    public AuditTypeEnum getAuditType() {
        return AuditTypeEnum.STOCKVERIFY;
    }*/

    @Override
    public boolean matches(AuditTypeEnum auditTypeEnum) {
        return AuditTypeEnum.STOCKVERIFY.equals(auditTypeEnum);
    }

    @Override
    public Result<String> checking(CurrentStageSearchServiceParam param) {
        Result _result=Result.newSuccess();
        SwStockVerify swStockVerify=swStockVerifyMapper.selectByStockInNo(param.getSourceNo());
        String status="";
        if(swStockVerify!=null){
            status=swStockVerify.getStatus();
        }
        _result.setData(status);
        return _result;
    }
}
