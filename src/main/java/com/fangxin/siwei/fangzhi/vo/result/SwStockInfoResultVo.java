package com.fangxin.siwei.fangzhi.vo.result;

import java.math.BigDecimal;

/**
 * @Date:2017/11/13 0013 10:52
 * @Author lu.dong
 * @Description：
 **/
public class SwStockInfoResultVo {
    private String materialNo;

    private String materialName;

    private String materialType;

    private String materialTypeName;

    private String spec;

    private String pattern;

    private String unit;

    private String memo;

    private String materialStock;

    private String materialStockName;

    private BigDecimal materialLong;

    private BigDecimal materialWidth;

    private BigDecimal num;


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

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }


    public String getModiTime() {
        return modiTime;
    }

    public void setModiTime(String modiTime) {
        this.modiTime = modiTime;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    public String getMaterialStockName() {
        return materialStockName;
    }

    public void setMaterialStockName(String materialStockName) {
        this.materialStockName = materialStockName;
    }
}
