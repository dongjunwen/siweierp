package com.fangxin.siwei.fangzhi.vo.purchase;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

/**
 * @Date:2017/11/6 0006 17:15
 * @Author lu.dong
 * @Description：
 **/
public class SwReturnDetailVo {

    @ApiModelProperty(value = "退货单序号",required =false )
    @Length(max = 32,message = "退货单序号长度不能超过32")
    private String returnSeqNo;
    @ApiModelProperty(value = "采购单号",required =false )
    @Length(max = 32,message = "采购单号长度不能超过32")
    private String purNo;
    @ApiModelProperty(value = "采购单单序号",required =false )
    @Length(max = 32,message = "采购单序号长度不能超过32")
    private String purSeqNo;
    @ApiModelProperty(value = "订单序号",required =false )
    @Length(max = 32,message = "订单长度不能超过32")
    private String orderNo;
    @ApiModelProperty(value = "订单序号",required =false )
    @Length(max = 32,message = "订单长度不能超过32")
    private String orderSeqNo;
    @ApiModelProperty(value = "物料编号",required =false )
    @Length(max = 32,message = "物料编号长度不能超过32")
    private String materialNo;
    @ApiModelProperty(value = "物料名称",required =false )
    @Length(max = 32,message = "物料名称长度不能超过32")
    private String materialName;
    @ApiModelProperty(value = "物料类型",required =false )
    @Length(max = 32,message = "物料类型不能超过32")
    private String materialType;
    @ApiModelProperty(value = "规格",required =false )
    @Length(max = 32,message = "规格不能超过32")
    private String spec;
    @ApiModelProperty(value = "型号",required =false )
    @Length(max = 32,message = "型号不能超过32")
    private String pattern;
    @ApiModelProperty(value = "单位",required =false )
    @Length(max = 32,message = "单位不能超过32")
    private String unit;

    private BigDecimal num;

    private BigDecimal price;

    private BigDecimal amt;

    private String returnReason;

    private String memo;

    public String getReturnSeqNo() {
        return returnSeqNo;
    }

    public void setReturnSeqNo(String returnSeqNo) {
        this.returnSeqNo = returnSeqNo;
    }

    public String getPurNo() {
        return purNo;
    }

    public void setPurNo(String purNo) {
        this.purNo = purNo;
    }

    public String getPurSeqNo() {
        return purSeqNo;
    }

    public void setPurSeqNo(String purSeqNo) {
        this.purSeqNo = purSeqNo;
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

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
