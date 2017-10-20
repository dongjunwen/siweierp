package com.fangxin.siwei.fangzhi.modal;

import javax.persistence.Id;
import java.util.Date;

public class SysResource {
    @Id
    private Integer id;

    private String sourceNo;

    private String sourceName;

    private String fhSourceNo;

    private String sourceType;

    private String reqUrl;

    private String rsourceIcon;

    private Integer sortOrder;

    private String ifVisible;

    private String memo;

    private String createNo;

    private Date createTime;

    private String modiNo;

    private Date modiTime;

    private Integer version;

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

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getFhSourceNo() {
        return fhSourceNo;
    }

    public void setFhSourceNo(String fhSourceNo) {
        this.fhSourceNo = fhSourceNo == null ? null : fhSourceNo.trim();
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl == null ? null : reqUrl.trim();
    }

    public String getRsourceIcon() {
        return rsourceIcon;
    }

    public void setRsourceIcon(String rsourceIcon) {
        this.rsourceIcon = rsourceIcon == null ? null : rsourceIcon.trim();
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getIfVisible() {
        return ifVisible;
    }

    public void setIfVisible(String ifVisible) {
        this.ifVisible = ifVisible == null ? null : ifVisible.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getCreateNo() {
        return createNo;
    }

    public void setCreateNo(String createNo) {
        this.createNo = createNo == null ? null : createNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModiNo() {
        return modiNo;
    }

    public void setModiNo(String modiNo) {
        this.modiNo = modiNo == null ? null : modiNo.trim();
    }

    public Date getModiTime() {
        return modiTime;
    }

    public void setModiTime(Date modiTime) {
        this.modiTime = modiTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}