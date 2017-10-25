package com.fangxin.siwei.fangzhi.modal;

import java.util.Date;

public class SysAuditConfig {
    private Integer id;

    private String auditNo;

    private String auditType;

    private String auditTypeName;

    private String auditAction;

    private String auditActionName;

    private String currentStage;

    private String nextStage;

    private String auditUserNo;

    private String auditUserName;

    private Date createTime;

    private Date modiTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModiTime() {
        return modiTime;
    }

    public void setModiTime(Date modiTime) {
        this.modiTime = modiTime;
    }
}