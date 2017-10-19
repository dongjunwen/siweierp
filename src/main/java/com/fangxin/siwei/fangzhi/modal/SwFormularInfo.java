package com.fangxin.siwei.fangzhi.modal;

import java.util.Date;

public class SwFormularInfo {
    private Integer id;

    private String formularNo;

    private String formularName;

    private String formularValue;

    private String formularType;

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

    public String getFormularNo() {
        return formularNo;
    }

    public void setFormularNo(String formularNo) {
        this.formularNo = formularNo == null ? null : formularNo.trim();
    }

    public String getFormularName() {
        return formularName;
    }

    public void setFormularName(String formularName) {
        this.formularName = formularName == null ? null : formularName.trim();
    }

    public String getFormularValue() {
        return formularValue;
    }

    public void setFormularValue(String formularValue) {
        this.formularValue = formularValue == null ? null : formularValue.trim();
    }

    public String getFormularType() {
        return formularType;
    }

    public void setFormularType(String formularType) {
        this.formularType = formularType == null ? null : formularType.trim();
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