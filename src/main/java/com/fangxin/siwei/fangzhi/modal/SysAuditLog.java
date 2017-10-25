package com.fangxin.siwei.fangzhi.modal;

import java.util.Date;

public class SysAuditLog {
    private Integer id;

    private String sourceNo;

    private String auditNo;

    private String auditType;

    private String auditTypeName;

    private String auditAction;

    private String auditActionName;

    private String currentStage;

    private String nextStage;

    private String auditUserNo;

    private String auditUserName;

    private Date auditTime;

    private String auditDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo == null ? null : sourceNo.trim();
    }

    public String getAuditNo() {
        return auditNo;
    }

    public void setAuditNo(String auditNo) {
        this.auditNo = auditNo == null ? null : auditNo.trim();
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType == null ? null : auditType.trim();
    }

    public String getAuditTypeName() {
        return auditTypeName;
    }

    public void setAuditTypeName(String auditTypeName) {
        this.auditTypeName = auditTypeName == null ? null : auditTypeName.trim();
    }

    public String getAuditAction() {
        return auditAction;
    }

    public void setAuditAction(String auditAction) {
        this.auditAction = auditAction == null ? null : auditAction.trim();
    }

    public String getAuditActionName() {
        return auditActionName;
    }

    public void setAuditActionName(String auditActionName) {
        this.auditActionName = auditActionName == null ? null : auditActionName.trim();
    }

    public String getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage == null ? null : currentStage.trim();
    }

    public String getNextStage() {
        return nextStage;
    }

    public void setNextStage(String nextStage) {
        this.nextStage = nextStage == null ? null : nextStage.trim();
    }

    public String getAuditUserNo() {
        return auditUserNo;
    }

    public void setAuditUserNo(String auditUserNo) {
        this.auditUserNo = auditUserNo == null ? null : auditUserNo.trim();
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName == null ? null : auditUserName.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc == null ? null : auditDesc.trim();
    }
}