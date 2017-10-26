package com.fangxin.siwei.fangzhi.vo.order;

import java.math.BigDecimal;

/**
 * @Date:2017/10/26 0026 14:29
 * @Author lu.dong
 * @Description：
 **/
public class SwDeliverDetailVo {

    private String deilverNo;

    private String deilverSeqNo;

    private String orderNo;

    private String orderSeqNo;

    private String boxNo;

    private String prodNo;

    private String prodName;

    private String prodType;

    private String prodForm;

    private BigDecimal prodLong;

    private BigDecimal prodWidth;

    private BigDecimal prodNum;

    private BigDecimal prodPrice;

    private String memo;

    public String getDeilverNo() {
        return deilverNo;
    }

    public void setDeilverNo(String deilverNo) {
        this.deilverNo = deilverNo;
    }

    public String getDeilverSeqNo() {
        return deilverSeqNo;
    }

    public void setDeilverSeqNo(String deilverSeqNo) {
        this.deilverSeqNo = deilverSeqNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderSeqNo() {
        return orderSeqNo;
    }

    public void setOrderSeqNo(String orderSeqNo) {
        this.orderSeqNo = orderSeqNo;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdForm() {
        return prodForm;
    }

    public void setProdForm(String prodForm) {
        this.prodForm = prodForm;
    }

    public BigDecimal getProdLong() {
        return prodLong;
    }

    public void setProdLong(BigDecimal prodLong) {
        this.prodLong = prodLong;
    }

    public BigDecimal getProdWidth() {
        return prodWidth;
    }

    public void setProdWidth(BigDecimal prodWidth) {
        this.prodWidth = prodWidth;
    }

    public BigDecimal getProdNum() {
        return prodNum;
    }

    public void setProdNum(BigDecimal prodNum) {
        this.prodNum = prodNum;
    }

    public BigDecimal getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(BigDecimal prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
