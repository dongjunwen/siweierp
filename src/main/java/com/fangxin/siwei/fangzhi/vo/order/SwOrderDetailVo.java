package com.fangxin.siwei.fangzhi.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

/**
 * @Date:2017/10/24 0024 14:50
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "业务订单详细Vo SwOrderDetailVo")
public class SwOrderDetailVo {

    @Length(max = 32,message = "订单序号不能超过32")
    @ApiModelProperty(value = "订单序号",required =false )
    private String orderSeqNo;
    @Length(max = 32,message = "产品编码不能超过32")
    @ApiModelProperty(value = "产品编码",required =false )
    private String prodNo;
    @Length(max = 32,message = "产品名称不能超过32")
    @ApiModelProperty(value = "产品名称",required =false )
    private String prodName;
    @Length(max = 32,message = "品种不能超过32")
    @ApiModelProperty(value = "品种",required =false )
    private String prodType;
    @Length(max = 100,message = "型号不能超过100")
    @ApiModelProperty(value = "型号",required =false )
    private String prodPattern;
    @Length(max = 32,message = "形状不能超过32")
    @ApiModelProperty(value = "形状",required =false )
    private String prodForm;
    @Length(max = 4,message = "色号不能超过4")
    @ApiModelProperty(value = "色号",required =false )
    private String prodColorNo;
    @Length(max = 32,message = "长不能超过32")
    @ApiModelProperty(value = "长",required =false )
    private BigDecimal prodLong;
    @Length(max = 32,message = "宽不能超过32")
    @ApiModelProperty(value = "宽",required =false )
    private BigDecimal prodWidth;
    @Length(max = 32,message = "数量不能超过32")
    @ApiModelProperty(value = "数量",required =false )
    private BigDecimal prodNum;
    @Length(max = 32,message = "单位不能超过32")
    @ApiModelProperty(value = "单位",required =false )
    private String prodUnit;
   /* @Length(max = 32,message = "单价公式编码不能超过32")
    @ApiModelProperty(value = "单价公式编码",required =false )
    private String prodPriceNo;
    @Length(max = 32,message = "单价公式不能超过32")
    @ApiModelProperty(value = "单价公式",required =false )
    private String prodPriceExpress;*/
    @ApiModelProperty(value = "单价",required =false )
    private BigDecimal prodPrice;
    @ApiModelProperty(value = "含税单价",required =false )
    private BigDecimal prodTaxPrice;
    @ApiModelProperty(value = "金额",required =false )
    private BigDecimal prodAmt;
    @ApiModelProperty(value = "金额",required =false )
    private BigDecimal prodTaxAmt;
    @Length(max = 64,message = "区域不能超过64")
    @ApiModelProperty(value = "区域",required =false )
    private String area;
    @Length(max = 32,message = "面料品号不能超过32")
    @ApiModelProperty(value = "面料品号",required =false )
    private String materialNo;
    @Length(max = 32,message = "面料品名不能超过32")
    @ApiModelProperty(value = "面料品名",required =false )
    private String materialName;
    @ApiModelProperty(value = "幅宽",required =false )
    private BigDecimal materialWidth;
    @Length(max = 32,message = "面料公式代码不能超过32")
    @ApiModelProperty(value = "面料公式代码",required =false )
    private String materialPriceNo;
    @Length(max = 32,message = "面料公式名称不能超过32")
    @ApiModelProperty(value = "面料公式名称",required =false )
    private String materialPriceName;
    @Length(max = 32,message = "面料公式不能超过32")
    @ApiModelProperty(value = "面料公式",required =false )
    private String materialPriceExpress;
    @Length(max = 100,message = "面料规格不能超过100")
    @ApiModelProperty(value = "面料规格",required =false )
    private String materialSpec;
    @Length(max = 100,message = "面料型号不能超过100")
    @ApiModelProperty(value = "面料型号",required =false )
    private String materialPattern;
    @Length(max = 32,message = "面料单位不能超过32")
    @ApiModelProperty(value = "面料单位",required =false )
    private String materialUnit;
    @ApiModelProperty(value = "面料数量",required =false )
    private BigDecimal materialNum;
    @ApiModelProperty(value = "面料基础价",required =false )
    private BigDecimal materialPrice;
    @Length(max = 32,message = "工艺编码不能超过32")
    @ApiModelProperty(value = "工艺编码",required =false )
    private String techNo;
    @Length(max = 64,message = "工艺名称不能超过64")
    @ApiModelProperty(value = "工艺名称",required =false )
    private String techName;
    @ApiModelProperty(value = "工艺单价",required =false )
    private BigDecimal techPrice;
    @Length(max = 32,message = "工艺公式不能超过32")
    @ApiModelProperty(value = "工艺公式",required =false )
    private String techPriceExpress;
    @Length(max = 32,message = "备注不能超过32")
    @ApiModelProperty(value = "备注",required =false )
    private String memo;
    @ApiModelProperty(value = "成品定价",required =false )
    private BigDecimal prodPrice1;
    @Length(max = 1,message = "面是否定价品不能超过1")
    @ApiModelProperty(value = "是否定价品 Y:是 N:否",required =false )
    private String ifProd;
    @Length(max = 32,message = "分类不能超过32")
    @ApiModelProperty(value = "分类",required =false )
    private String cateType;

    public String getOrderSeqNo() {
        return orderSeqNo;
    }

    public void setOrderSeqNo(String orderSeqNo) {
        this.orderSeqNo = orderSeqNo;
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

    public String getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(String prodUnit) {
        this.prodUnit = prodUnit;
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
        this.area = area;
    }

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
        this.materialPriceNo = materialPriceNo;
    }

    public String getMaterialPriceExpress() {
        return materialPriceExpress;
    }

    public void setMaterialPriceExpress(String materialPriceExpress) {
        this.materialPriceExpress = materialPriceExpress;
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
        this.techNo = techNo;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
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
        this.techPriceExpress = techPriceExpress;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
        this.ifProd = ifProd;
    }

    public String getCateType() {
        return cateType;
    }

    public void setCateType(String cateType) {
        this.cateType = cateType;
    }

    public String getMaterialPriceName() {
        return materialPriceName;
    }

    public void setMaterialPriceName(String materialPriceName) {
        this.materialPriceName = materialPriceName;
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
