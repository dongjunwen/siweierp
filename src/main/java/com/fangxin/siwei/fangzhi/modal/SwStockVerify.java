package com.fangxin.siwei.fangzhi.modal;

import java.math.BigDecimal;
import java.util.Date;

public class SwStockVerify {
    private Integer id;

    private String stkInNo;

    private String orderType;

    private String orderNo;

    private String orderSeqNo;

    private String materialNo;

    private String materialName;

    private String materialType;

    private String spec;

    private String pattern;

    private String unit;

    private String materialStock;

    private BigDecimal num;

    private BigDecimal standNum;

    private String moisRate;

    private String weight;

    private String quality;

    private String status;

    private String reason;

    private Date modiTime;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStkInNo() {
        return stkInNo;
    }

    public void setStkInNo(String stkInNo) {
        this.stkInNo = stkInNo == null ? null : stkInNo.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOrderSeqNo() {
        return orderSeqNo;
    }

    public void setOrderSeqNo(String orderSeqNo) {
        this.orderSeqNo = orderSeqNo == null ? null : orderSeqNo.trim();
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo == null ? null : materialNo.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : pattern.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getMaterialStock() {
        return materialStock;
    }

    public void setMaterialStock(String materialStock) {
        this.materialStock = materialStock == null ? null : materialStock.trim();
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getStandNum() {
        return standNum;
    }

    public void setStandNum(BigDecimal standNum) {
        this.standNum = standNum;
    }

    public String getMoisRate() {
        return moisRate;
    }

    public void setMoisRate(String moisRate) {
        this.moisRate = moisRate == null ? null : moisRate.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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