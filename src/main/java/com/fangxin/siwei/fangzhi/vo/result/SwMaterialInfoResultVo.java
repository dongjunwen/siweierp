package com.fangxin.siwei.fangzhi.vo.result;

import java.math.BigDecimal;

/**
 * @Date:2017/11/5 0005 16:05
 * @Author lu.dong
 * @Description：
 **/
public class SwMaterialInfoResultVo {
    private String materialNo;

    private String materialName;

    private String materialType;

    private String materialTypeName;

    private String spec;

    private String pattern;

    private String unit;

    private BigDecimal price;

    private String memo;

    private String materialStock;

    private BigDecimal materialLong;

    private BigDecimal materialWidth;

    private String createNo;

    private String createTime;

    private String modiNo;

    private String modiTime;

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCreateNo() {
        return createNo;
    }

    public void setCreateNo(String createNo) {
        this.createNo = createNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModiNo() {
        return modiNo;
    }

    public void setModiNo(String modiNo) {
        this.modiNo = modiNo;
    }

    public String getModiTime() {
        return modiTime;
    }

    public void setModiTime(String modiTime) {
        this.modiTime = modiTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMaterialStock() {
        return materialStock;
    }

    public void setMaterialStock(String materialStock) {
        this.materialStock = materialStock;
    }

    public BigDecimal getMaterialLong() {
        return materialLong;
    }

    public void setMaterialLong(BigDecimal materialLong) {
        this.materialLong = materialLong;
    }

    public BigDecimal getMaterialWidth() {
        return materialWidth;
    }

    public void setMaterialWidth(BigDecimal materialWidth) {
        this.materialWidth = materialWidth;
    }
}
