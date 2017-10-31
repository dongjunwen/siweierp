package com.fangxin.siwei.fangzhi.modal;

import java.math.BigDecimal;
import java.util.Date;

public class SwReturnBase {
    private Integer id;

    private String returnNo;

    private Date returnDate;

    private String respName;

    private String supplyCompNo;

    private String supplyCompName;

    private String supplyContactName;

    private String supplyMobile;

    private String supplyPhone;

    private String supplyTax;

    private String supplyAddr;

    private BigDecimal returnAmt;

    private BigDecimal returnNum;

    private String returnReason;

    private String returnStatus;

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

    public String getReturnNo() {
        return returnNo;
    }

    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo == null ? null : returnNo.trim();
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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

    public BigDecimal getReturnAmt() {
        return returnAmt;
    }

    public void setReturnAmt(BigDecimal returnAmt) {
        this.returnAmt = returnAmt;
    }

    public BigDecimal getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(BigDecimal returnNum) {
        this.returnNum = returnNum;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason == null ? null : returnReason.trim();
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus == null ? null : returnStatus.trim();
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