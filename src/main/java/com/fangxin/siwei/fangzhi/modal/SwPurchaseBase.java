package com.fangxin.siwei.fangzhi.modal;

import java.math.BigDecimal;
import java.util.Date;

public class SwPurchaseBase {
    private Integer id;

    private String purNo;

    private Date purDate;

    private Date expectDate;

    private String respName;

    private String supplyCompNo;

    private String supplyCompName;

    private String supplyContactName;

    private String supplyMobile;

    private String supplyPhone;

    private String supplyTax;

    private String supplyAddr;

    private BigDecimal purAmt;

    private BigDecimal purNum;

    private String purStatus;

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

    public String getPurNo() {
        return purNo;
    }

    public void setPurNo(String purNo) {
        this.purNo = purNo == null ? null : purNo.trim();
    }

    public Date getPurDate() {
        return purDate;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public Date getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Date expectDate) {
        this.expectDate = expectDate;
    }

    public String getRespName() {
        return respName;
    }

    public void setRespName(String respName) {
        this.respName = respName == null ? null : respName.trim();
    }

    public String getSupplyCompNo() {
        return supplyCompNo;
    }

    public void setSupplyCompNo(String supplyCompNo) {
        this.supplyCompNo = supplyCompNo == null ? null : supplyCompNo.trim();
    }

    public String getSupplyCompName() {
        return supplyCompName;
    }

    public void setSupplyCompName(String supplyCompName) {
        this.supplyCompName = supplyCompName == null ? null : supplyCompName.trim();
    }

    public String getSupplyContactName() {
        return supplyContactName;
    }

    public void setSupplyContactName(String supplyContactName) {
        this.supplyContactName = supplyContactName == null ? null : supplyContactName.trim();
    }

    public String getSupplyMobile() {
        return supplyMobile;
    }

    public void setSupplyMobile(String supplyMobile) {
        this.supplyMobile = supplyMobile == null ? null : supplyMobile.trim();
    }

    public String getSupplyPhone() {
        return supplyPhone;
    }

    public void setSupplyPhone(String supplyPhone) {
        this.supplyPhone = supplyPhone == null ? null : supplyPhone.trim();
    }

    public String getSupplyTax() {
        return supplyTax;
    }

    public void setSupplyTax(String supplyTax) {
        this.supplyTax = supplyTax == null ? null : supplyTax.trim();
    }

    public String getSupplyAddr() {
        return supplyAddr;
    }

    public void setSupplyAddr(String supplyAddr) {
        this.supplyAddr = supplyAddr == null ? null : supplyAddr.trim();
    }

    public BigDecimal getPurAmt() {
        return purAmt;
    }

    public void setPurAmt(BigDecimal purAmt) {
        this.purAmt = purAmt;
    }

    public BigDecimal getPurNum() {
        return purNum;
    }

    public void setPurNum(BigDecimal purNum) {
        this.purNum = purNum;
    }

    public String getPurStatus() {
        return purStatus;
    }

    public void setPurStatus(String purStatus) {
        this.purStatus = purStatus == null ? null : purStatus.trim();
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