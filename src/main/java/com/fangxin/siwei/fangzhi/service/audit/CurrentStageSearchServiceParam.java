package com.fangxin.siwei.fangzhi.service.audit;

/**
 * 
 * Title: 当前阶段状态查询入参
 * Description:
 * @author weichuang.shao
 * @email weichuang.shao@chinaredstar.com
 * @version 1.0.0
 * @date 2016年12月27日
 */
public class CurrentStageSearchServiceParam {
	/**
	 * 来源单号
	 */
	private String sourceNo;
	/**
	 * 审核类型
	 */
    private String auditType;
	/**
	 * 审核动作
	 */
    private String auditAction;
    
	public String getAuditAction() {
		return auditAction;
	}
	
	public String getAuditType() {
		return auditType;
	}
	
	public String getSourceNo() {
		return sourceNo;
	}
	
	public void setAuditAction(String auditAction) {
		this.auditAction = auditAction;
	}
	
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	
	public void setSourceNo(String sourceNo) {
		this.sourceNo = sourceNo;
	}
    
}
