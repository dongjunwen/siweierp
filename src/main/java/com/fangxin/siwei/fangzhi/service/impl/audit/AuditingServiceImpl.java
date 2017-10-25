package com.fangxin.siwei.fangzhi.service.impl.audit;


import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.mapper.SysAuditConfigMapper;
import com.fangxin.siwei.fangzhi.mapper.SysAuditLogMapper;
import com.fangxin.siwei.fangzhi.modal.SysAuditConfig;
import com.fangxin.siwei.fangzhi.modal.SysAuditLog;
import com.fangxin.siwei.fangzhi.service.audit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 
 * Title: 审核状态跳转查询接口
 * Description:
 * @author weichuang.shao
 * @email weichuang.shao@chinaredstar.com
 * @version 1.0.0
 * @date 2016年12月26日
 */
@Service
public class AuditingServiceImpl implements IAuditingService {
	@Autowired
	private SysAuditConfigMapper sysAuditConfigMapper;
	@Autowired
	private SysAuditLogMapper sysAuditLogMapper;
	@Resource
	private AuditCheckingFactory auditCheckingFactory;

	@Transactional
	@Override
	public Result<SysAuditConfig> auditing(AuditingParam param) {
		Result<SysAuditConfig> result = Result.newSuccess();
		if(param.getAuditType() == null ||  param.getCurrentStage()== null || param.getAuditAction() == null){
			result.setErrorCode(ResultCode.COMMON_PARAM_NULL);
			result.setMessage("单号为"+param.getSourceNo()+"的"+ResultCode.COMMON_PARAM_NULL.getMessage());
			return result;
		}
		
		Result<String> checkingRet = null;
		IAuditCheckingService checkingServiceImpl=this.auditCheckingFactory.getAuditCheckingMapping(param.getAuditType());
		if(checkingServiceImpl!=null){
			CurrentStageSearchServiceParam searchParamDTO = new CurrentStageSearchServiceParam();
			{
				searchParamDTO.setAuditAction(param.getAuditAction());
				searchParamDTO.setAuditType(param.getAuditType().getCode());
				searchParamDTO.setSourceNo(param.getSourceNo());
			}
			checkingRet = checkingServiceImpl.checking(searchParamDTO);
			if(!Objects.equals(ResultCode.SUCCESS.getCode(), checkingRet.getCode())){
				result.setErrorCode(ResultCode.AUDIT_CHECKING_ERROR);
				result.setMessage("单号为"+param.getSourceNo()+"的"+ResultCode.AUDIT_CHECKING_ERROR.getMessage());
				return result;
			}
		}
		if(checkingRet == null) {
			result.setErrorCode(ResultCode.AUDIT_ERROR_NO_CONFIG);
			result.setMessage("单号为"+param.getSourceNo()+"的"+ResultCode.AUDIT_ERROR_NO_CONFIG.getMessage());
			return result;
		}
		
		if(!Objects.equals(param.getCurrentStage(), checkingRet.getData())){
			result.setErrorCode(ResultCode.AUDIT_CURRENT_STAGE_ERROR);
			result.setMessage("单号为"+param.getSourceNo()+"的当前状态不能再操作!");
			return result;
		}
		SysAuditConfig expAuditConfig = this.sysAuditConfigMapper.findNextStage(param.getAuditType().getCode(), checkingRet.getData(), param.getAuditAction());
		if(expAuditConfig == null) {
			result.setErrorCode(ResultCode.AUDIT_ERROR_NO_CONFIG);
			result.setMessage("单号为"+param.getSourceNo()+"的"+ResultCode.AUDIT_ERROR_NO_CONFIG.getMessage());
			return result;
		}
		
		this.logging(param, expAuditConfig);
		result.setData(expAuditConfig);
		return result;
	}



	@Override
	public List<SysAuditLog> querySysAuditLogsBySourceNo(String sourceNo) {
		return sysAuditLogMapper.querySysAuditLogsBySourceNo(sourceNo);
	}

	@Override
	public SysAuditLog queryLastOperateSysAuditLogBySourceNo(String sourceNo) {
		List<SysAuditLog> billAmtLogs = querySysAuditLogsBySourceNo(sourceNo);
		if (null != billAmtLogs && !billAmtLogs.isEmpty()) {
			return billAmtLogs.get(0);
		}
		return null;
	}

	protected void  logging(AuditingParam param, SysAuditConfig auditConfig) {
		SysAuditLog auditLog = new SysAuditLog();
		auditLog.setAuditAction(auditConfig.getAuditAction());
		auditLog.setAuditActionName(auditConfig.getAuditActionName());
		auditLog.setAuditNo(auditConfig.getAuditNo());
		auditLog.setAuditTime(new Date());
		auditLog.setAuditDesc(param.getAuditDesc());
		auditLog.setAuditType(auditConfig.getAuditType());
		auditLog.setAuditTypeName(auditConfig.getAuditTypeName());
		auditLog.setAuditUserName(param.getAuditUserName());
		auditLog.setAuditUserNo(param.getAuditUserNo());
		auditLog.setCurrentStage(auditConfig.getCurrentStage());
		auditLog.setNextStage(auditConfig.getNextStage());
		auditLog.setSourceNo(param.getSourceNo());
		this.sysAuditLogMapper.insert(auditLog);
	}


}
