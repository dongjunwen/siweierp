package com.fangxin.siwei.fangzhi.service.audit;


import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SysAuditConfig;
import com.fangxin.siwei.fangzhi.modal.SysAuditLog;

import java.util.List;

/**
 * 
 * Title: 审核状态跳转查询接口
 * Description:
 * @author weichuang.shao
 * @email weichuang.shao@chinaredstar.com
 * @version 1.0.0
 * @date 2016年12月26日
 */
public interface IAuditingService {
	/**
	 * 审核流程处理。
	 * 如果审核过程中出现异常。将会返回错误码和错误信息。
	 * Create On 2016年12月27日
	 * @version 1.0.0
     * @param param
     * 审核参数提交
	 * @return
	 * 返回审核结果
	 */
	Result<SysAuditConfig> auditing(AuditingParam param);

    /**
     * 根据billNo查询费用单操作日志
     *
     * @return
     */
    List<SysAuditLog> querySysAuditLogsBySourceNo(String sourceNo);

	SysAuditLog queryLastOperateSysAuditLogBySourceNo(String sourceNo);

}
