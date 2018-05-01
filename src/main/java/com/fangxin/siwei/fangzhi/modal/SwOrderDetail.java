package com.fangxin.siwei.fangzhi.modal;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class SwOrderDetail {
    @Id
    private Integer id;

    private String orderNo;

    private String orderSeqNo;

    private String prodNo;

    private String prodName;

    private String prodType;

    private String prodForm;
    private String prodPattern;
    private String prodColorNo;

    private BigDecimal prodLong;

    private BigDecimal prodWidth;

    private BigDecimal prodNum;

    private String prodUnit;

    private String prodPriceNo;

    private String prodPriceExpress;

    private BigDecimal prodPrice;

    private BigDecimal prodTaxPrice;

    private BigDecimal prodAmt;

    private BigDecimal prodTaxAmt;

    private String area;

    private String materialNo;

    private String materialName;

    private BigDecimal materialWidth;

    private String materialPriceNo;

    private String materialPriceName;

    private String materialPriceExpress;

    private String materialSpec;

    private String materialPattern;

    private String materialUnit;

    private BigDecimal materialNum;

    private BigDecimal materialPrice;

    private String techNo;

    private String techName;

    private BigDecimal techPrice;

    private String techPriceExpress;

    private String memo;

    private BigDecimal prodPrice1;

    private String ifProd;

    private String cateType;

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

    public String getOrderSeqNo() {
        return orderSeqNo;
    }

    public void setOrderSeqNo(String orderSeqNo) {
        this.orderSeqNo = orderSeqNo == null ? null : orderSeqNo.trim();
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo == null ? null : prodNo.trim();
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName == null ? null : prodName.trim();
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType == null ? null : prodType.trim();
    }

    public String getProdForm() {
        return prodForm;
    }

    public void setProdForm(String prodForm) {
        this.prodForm = prodForm == null ? null : prodForm.trim();
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

    public String getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(String prodUnit) {
        this.prodUnit = prodUnit == null ? null : prodUnit.trim();
    }

    public String getProdPriceNo() {
        return prodPriceNo;
    }

    public void setProdPriceNo(String prodPriceNo) {
        this.prodPriceNo = prodPriceNo == null ? null : prodPriceNo.trim();
    }

    public String getProdPriceExpress() {
        return prodPriceExpress;
    }

    public void setProdPriceExpress(String prodPriceExpress) {
        this.prodPriceExpress = prodPriceExpress == null ? null : prodPriceExpress.trim();
    }

    public BigDecimal getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(BigDecimal prodPrice) {
        this.prodPrice = prodPrice;
    }

    public BigDecimal getProdAmt() {
        return prodAmt;
    }

    public void setProdAmt(BigDecimal prodAmt) {
        this.prodAmt = prodAmt;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
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

    public BigDecimal getMaterialWidth() {
        return materialWidth;
    }

    public void setMaterialWidth(BigDecimal materialWidth) {
        this.materialWidth = materialWidth;
    }

    public String getMaterialPriceNo() {
        return materialPriceNo;
    }

    public void setMaterialPriceNo(String materialPriceNo) {
        this.materialPriceNo = materialPriceNo == null ? null : materialPriceNo.trim();
    }

    public String getMaterialPriceName() {
        return materialPriceName;
    }

    public void setMaterialPriceName(String materialPriceName) {
        this.materialPriceName = materialPriceName;
    }

    public String getMaterialPriceExpress() {
        return materialPriceExpress;
    }

    public void setMaterialPriceExpress(String materialPriceExpress) {
        this.materialPriceExpress = materialPriceExpress == null ? null : materialPriceExpress.trim();
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public BigDecimal getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(BigDecimal materialNum) {
        this.materialNum = materialNum;
    }

    public BigDecimal getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(BigDecimal materialPrice) {
        this.materialPrice = materialPrice;
    }

    public String getTechNo() {
        return techNo;
    }

    public void setTechNo(String techNo) {
        this.techNo = techNo == null ? null : techNo.trim();
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName == null ? null : techName.trim();
    }

    public BigDecimal getTechPrice() {
        return techPrice;
    }

    public void setTechPrice(BigDecimal techPrice) {
        this.techPrice = techPrice;
    }

    public String getTechPriceExpress() {
        return techPriceExpress;
    }

    public void setTechPriceExpress(String techPriceExpress) {
        this.techPriceExpress = techPriceExpress == null ? null : techPriceExpress.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public BigDecimal getProdPrice1() {
        return prodPrice1;
    }

    public void setProdPrice1(BigDecimal prodPrice1) {
        this.prodPrice1 = prodPrice1;
    }

    public String getIfProd() {
        return ifProd;
    }

    public void setIfProd(String ifProd) {
        this.ifProd = ifProd == null ? null : ifProd.trim();
    }

    public String getCateType() {
        return cateType;
    }

    public void setCateType(String cateType) {
        this.cateType = cateType == null ? null : cateType.trim();
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

    public String getMaterialSpec() {
        return materialSpec;
    }

    public void setMaterialSpec(String materialSpec) {
        this.materialSpec = materialSpec;
    }

    public String getMaterialPattern() {
        return materialPattern;
    }

    public void setMaterialPattern(String materialPattern) {
        this.materialPattern = materialPattern;
    }

    public String getProdPattern() {
        return prodPattern;
    }

    public void setProdPattern(String prodPattern) {
        this.prodPattern = prodPattern;
    }

    public String getProdColorNo() {
        return prodColorNo;
    }

    public void setProdColorNo(String prodColorNo) {
        this.prodColorNo = prodColorNo;
    }

    public BigDecimal getProdTaxPrice() {
        return prodTaxPrice;
    }

    public void setProdTaxPrice(BigDecimal prodTaxPrice) {
        this.prodTaxPrice = prodTaxPrice;
    }

    public BigDecimal getProdTaxAmt() {
        return prodTaxAmt;
    }

    public void setProdTaxAmt(BigDecimal prodTaxAmt) {
        this.prodTaxAmt = prodTaxAmt;
    }
}