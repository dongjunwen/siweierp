package com.fangxin.siwei.fangzhi.modal;

import javax.persistence.Id;
import java.util.Date;

public class SwDeliverBase {
    @Id
    private Integer id;

    private String deliverNo;

    private Date deliverDate;

    private String deliverWay;

    private String sendName;

    private String ifGurant;

    private String deliverStatus;

    private String memo;

    private String custCompNo;

    private String custCompName;

    private String custContactName;

    private String custMobile;

    private String custPhone;

    private String custTax;

    private String custAddr;

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

    public String getDeliverNo() {
        return deliverNo;
    }

    public void setDeliverNo(String deliverNo) {
        this.deliverNo = deliverNo;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getDeliverWay() {
        return deliverWay;
    }

    public void setDeliverWay(String deliverWay) {
        this.deliverWay = deliverWay;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName == null ? null : sendName.trim();
    }

    public String getIfGurant() {
        return ifGurant;
    }

    public void setIfGurant(String ifGurant) {
        this.ifGurant = ifGurant == null ? null : ifGurant.trim();
    }

    public String getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(String deliverStatus) {
        this.deliverStatus = deliverStatus == null ? null : deliverStatus.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getCustCompNo() {
        return custCompNo;
    }

    public void setCustCompNo(String custCompNo) {
        this.custCompNo = custCompNo == null ? null : custCompNo.trim();
    }

    public String getCustCompName() {
        return custCompName;
    }

    public void setCustCompName(String custCompName) {
        this.custCompName = custCompName == null ? null : custCompName.trim();
    }

    public String getCustContactName() {
        return custContactName;
    }

    public void setCustContactName(String custContactName) {
        this.custContactName = custContactName == null ? null : custContactName.trim();
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile == null ? null : custMobile.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getCustTax() {
        return custTax;
    }

    public void setCustTax(String custTax) {
        this.custTax = custTax == null ? null : custTax.trim();
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr == null ? null : custAddr.trim();
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