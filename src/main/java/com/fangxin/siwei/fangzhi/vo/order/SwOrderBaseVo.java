package com.fangxin.siwei.fangzhi.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Date:2017/10/24 0024 14:50
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "业务基础订单Vo SwOrderBaseVo")
public class SwOrderBaseVo {
    @Length(max = 16,message = "付款方式长度不能超过16")
    @ApiModelProperty(value = "付款方式",required =false )
    private String payWay;
    @Pattern(regexp="[0-9]{4}-[0-9]{2}-[0-9]{2}", message="订货日期格式不正确，正确的格式类似于1998-04-13")
    @ApiModelProperty(value = "订货日期",required =false )
    private String goodDate;
    @Pattern(regexp="[0-9]{4}-[0-9]{2}-[0-9]{2}", message="订货日期格式不正确，正确的格式类似于1998-04-13")
    @ApiModelProperty(value = "交货日期",required =false )
    private String finishDate;
    @Length(max = 16,message = "单据类型长度不能超过16")
    @ApiModelProperty(value = "单据类型",required =false )
    private String orderType;
    @Length(max = 16,message = "销售类型长度不能超过16")
    @ApiModelProperty(value = "销售类型",required =false )
    private String saleType;
    @Length(max = 32,message = "备注长度不能超过32")
    @ApiModelProperty(value = "备注",required =false )
    private String memo;
    @Length(max = 32,message = "客户编号长度不能超过32")
    @ApiModelProperty(value = "客户编号",required =false )
    private String custCompNo;
    @Length(max = 128,message = "客户名称长度不能超过128")
    @ApiModelProperty(value = "客户名称",required =false )
    private String custCompName;
    @Length(max = 64,message = "客户联系人长度不能超过64")
    @ApiModelProperty(value = "客户联系人",required =false )
    private String custContactName;
    @Length(max = 16,message = "客户手机长度不能超过16")
    @ApiModelProperty(value = "客户手机",required =false )
    private String custMobile;
    @Length(max = 16,message = "客户电话长度不能超过16")
    @ApiModelProperty(value = "客户电话",required =false )
    private String custPhone;
    @Length(max = 16,message = "客户传真长度不能超过16")
    @ApiModelProperty(value = "客户传真",required =false )
    private String custTax;
    @Length(max = 256,message = "客户地址长度不能超过256")
    @ApiModelProperty(value = "客户地址",required =false )
    private String custAddr;
    @Length(max = 32,message = "供货方编号长度不能超过32")
    @ApiModelProperty(value = "供货方编号",required =false )
    private String supplyCompNo;
    @Length(max = 128,message = "供货方名称长度不能超过128")
    @ApiModelProperty(value = "供货方名称",required =false )
    private String supplyCompName;
    @Length(max = 64,message = "供货方联系人长度不能超过64")
    @ApiModelProperty(value = "供货方联系人",required =false )
    private String supplyContactName;
    @Length(max = 16,message = "供货方手机长度不能超过16")
    @ApiModelProperty(value = "供货方手机",required =false )
    private String supplyMobile;
    @Length(max = 16,message = "供货方电话长度不能超过16")
    @ApiModelProperty(value = "供货方电话",required =false )
    private String supplyPhone;
    @Length(max = 16,message = "供货方传真长度不能超过16")
    @ApiModelProperty(value = "供货方传真",required =false )
    private String supplyTax;
    @Length(max = 256,message = "供货方地址长度不能超过256")
    @ApiModelProperty(value = "供货方地址",required =false )
    private String supplyAddr;

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getGoodDate() {
        return goodDate;
    }

    public void setGoodDate(String goodDate) {
        this.goodDate = goodDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCustCompNo() {
        return custCompNo;
    }

    public void setCustCompNo(String custCompNo) {
        this.custCompNo = custCompNo;
    }

    public String getCustCompName() {
        return custCompName;
    }

    public void setCustCompName(String custCompName) {
        this.custCompName = custCompName;
    }

    public String getCustContactName() {
        return custContactName;
    }

    public void setCustContactName(String custContactName) {
        this.custContactName = custContactName;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
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
        this.custTax = custTax;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    public String getSupplyCompNo() {
        return supplyCompNo;
    }

    public void setSupplyCompNo(String supplyCompNo) {
        this.supplyCompNo = supplyCompNo;
    }

    public String getSupplyCompName() {
        return supplyCompName;
    }

    public void setSupplyCompName(String supplyCompName) {
        this.supplyCompName = supplyCompName;
    }

    public String getSupplyContactName() {
        return supplyContactName;
    }

    public void setSupplyContactName(String supplyContactName) {
        this.supplyContactName = supplyContactName;
    }

    public String getSupplyMobile() {
        return supplyMobile;
    }

    public void setSupplyMobile(String supplyMobile) {
        this.supplyMobile = supplyMobile;
    }

    public String getSupplyPhone() {
        return supplyPhone;
    }

    public void setSupplyPhone(String supplyPhone) {
        this.supplyPhone = supplyPhone;
    }

    public String getSupplyTax() {
        return supplyTax;
    }

    public void setSupplyTax(String supplyTax) {
        this.supplyTax = supplyTax;
    }

    public String getSupplyAddr() {
        return supplyAddr;
    }

    public void setSupplyAddr(String supplyAddr) {
        this.supplyAddr = supplyAddr;
    }
}
