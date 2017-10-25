package com.fangxin.siwei.fangzhi.service.audit;


import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.result.Result;

/**
 * 
 * Title: 审核处理检查接口
 * Description:
 * @author weichuang.shao
 * @email weichuang.shao@chinaredstar.com
 * @version 1.0.0
 * @date 2016年12月26日
 */
public interface IAuditCheckingService {

	AuditTypeEnum getAuditType();

	/**
	 * 审核检查流程
	 * Create On 2016年12月27日
	 * @version 1.0.0
	 * @param param
	 * 检查入参
	 * @return
	 * 审核检查结果
	 */
	Result<String> checking(CurrentStageSearchServiceParam param);
}
