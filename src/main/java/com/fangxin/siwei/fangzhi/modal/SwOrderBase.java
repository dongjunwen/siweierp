package com.fangxin.siwei.fangzhi.modal;

import javax.persistence.Id;
import java.util.Date;

public class SwOrderBase {
    @Id
    private Integer id;

    private String orderNo;

    private Date orderDate;

    private String payWay;

    private Date goodDate;

    private Date finishDate;

    private String orderType;

    private String saleType;

    private String orderStatus;

    private String memo;

    private String custCompNo;

    private String custCompName;

    private String custContactName;

    private String custMobile;

    private String custPhone;

    private String custTax;

    private String custAddr;

    private String supplyCompNo;

    private String supplyCompName;

    private String supplyContactName;

    private String supplyMobile;

    private String supplyPhone;

    private String supplyTax;

    private String supplyAddr;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public Date getGoodDate() {
        return goodDate;
    }

    public void setGoodDate(Date goodDate) {
        this.goodDate = goodDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType == null ? null : saleType.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
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
        this.custPhone = custPhone;
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