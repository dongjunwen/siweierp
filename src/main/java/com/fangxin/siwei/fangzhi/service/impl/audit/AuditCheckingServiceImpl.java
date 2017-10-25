package com.fangxin.siwei.fangzhi.service.impl.audit;


import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.service.audit.CurrentStageSearchServiceParam;
import com.fangxin.siwei.fangzhi.service.audit.IAuditCheckingService;
import org.springframework.stereotype.Service;

/**
 * 
 * Title: Default error return checking service
 * Description:
 * @author weichuang.shao
 * @email weichuang.shao@chinaredstar.com
 * @version 1.0.0
 * @date 2016年12月28日
 */
@Service
public class AuditCheckingServiceImpl implements IAuditCheckingService {

	@Override
	public Result<String> checking(CurrentStageSearchServiceParam param) {
		Result<String> result = Result.newError(ResultCode.AUDIT_ERROR_NO_CONFIG);
		return result;
	}

}
