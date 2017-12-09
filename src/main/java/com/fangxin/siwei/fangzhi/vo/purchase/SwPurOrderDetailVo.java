package com.fangxin.siwei.fangzhi.vo.purchase;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

/**
 * @Date:2017/11/1 0001 13:57
 * @Author lu.dong
 * @Description：
 **/
public class SwPurOrderDetailVo {
    @Length(max = 32,message = "序号长度不能超过32")
    @ApiModelProperty(value = "序号",required =false )
    private String purSeqNo;
    @Length(max = 32,message = "订单号长度不能超过32")
    @ApiModelProperty(value = "订单号",required =false )
    private String orderNo;
    @Length(max = 32,message = "订单序号长度不能超过32")
    @ApiModelProperty(value = "订单序号",required =false )
    private String orderSeqNo;
    @Length(max = 32,message = "物料编号长度不能超过32")
    @ApiModelProperty(value = "物料编号",required =false )
    private String materialNo;
    @Length(max = 32,message = "物料名称长度不能超过32")
    @ApiModelProperty(value = "物料名称",required =false )
    private String materialName;
    @Length(max = 32,message = "物料分类长度不能超过32")
    @ApiModelProperty(value = "物料分类",required =false )
    private String materialType;
    @DecimalMin(value="0.01",message = "面料长度最小为0.01")
    @ApiModelProperty(value = "面料长度",required =false )
    private String materialLong;
    @DecimalMin(value="0.01",message = "面料宽度最小为0.01")
    @ApiModelProperty(value = "面料宽度",required =false )
    private String materialWidth;
    @Length(max = 100,message = "规格长度不能超过100")
    @ApiModelProperty(value = "规格",required =false )
    private String spec;
    @Length(max = 100,message = "型号长度不能超过100")
    @ApiModelProperty(value = "型号",required =false )
    private String pattern;
    @Length(max = 12,message = "单位长度不能超过12")
    @ApiModelProperty(value = "单位",required =false )
    private String unit;
    @DecimalMin(value="0.01",message = "采购数量最小为0.01")
    @ApiModelProperty(value = "采购数量",required =false )
    private BigDecimal num;
    @DecimalMin(value="0.01",message = "采购单价最小为0.01")
    @ApiModelProperty(value = "采购单价",required =false )
    private BigDecimal price;
    @DecimalMin(value="0.01",message = "采购金额最小为0.01")
    @ApiModelProperty(value = "采购金额",required =false )
    private BigDecimal amt;
    @Length(max = 256,message = "备注长度最大为256")
    @ApiModelProperty(value = "备注",required =false )
    private String memo;

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

    public String getMaterialLong() {
        return materialLong;
    }

    public void setMaterialLong(String materialLong) {
        this.materialLong = materialLong;
    }

    public String getMaterialWidth() {
        return materialWidth;
    }

    public void setMaterialWidth(String materialWidth) {
        this.materialWidth = materialWidth;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
