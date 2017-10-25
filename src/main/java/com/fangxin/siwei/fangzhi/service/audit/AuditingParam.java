package com.fangxin.siwei.fangzhi.service.audit;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;

/**
 * 
 * Title:
 * Description:
 * @author weichuang.shao
 * @email weichuang.shao@chinaredstar.com
 * @version 1.0.0
 * @date 2016年12月27日
 */
public class AuditingParam {
	/**
	 * 来源单号
	 */
	private String sourceNo;
	/**
	 * 审核类型
	 */
    private AuditTypeEnum auditType;
	/**
	 * 审核动作
	 */
    private String auditAction;
	/**
	 * 当前阶段
	 */
    private String currentStage;
	/**
	 * 审核人
	 */
    private String auditUserNo;
	/**
	 * 审核人姓名
	 */
    private String auditUserName;
	/**
	 * 审核描述
	 */
    private String auditDesc;
    
	public String getAuditAction() {
		return auditAction;
	}
	
	public String getAuditDesc() {
		return auditDesc;
	}
	

	public String getAuditUserName() {
		return auditUserName;
	}
	
	public String getAuditUserNo() {
		return auditUserNo;
	}
	
	public String getCurrentStage() {
		return currentStage;
	}
	
	public String getSourceNo() {
		return sourceNo;
	}
	
	public void setAuditAction(String auditAction) {
		this.auditAction = auditAction;
	}
	
	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}
	

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}
	
	public void setAuditUserNo(String auditUserNo) {
		this.auditUserNo = auditUserNo;
	}
	
	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}
	
	public void setSourceNo(String sourceNo) {
		this.sourceNo = sourceNo;
	}

	public AuditTypeEnum getAuditType() {
		return auditType;
	}

	public void setAuditType(AuditTypeEnum auditType) {
		this.auditType = auditType;
	}
}
