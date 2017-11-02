package com.fangxin.siwei.fangzhi.vo.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * @String:2017/11/1 0001 13:57
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "采购单Vo SwPurOrderBaseVo")
public class SwPurOrderBaseVo {
    @Pattern(regexp="[0-9]{4}-[0-9]{2}-[0-9]{2}", message="预计到货日期格式不正确，正确的格式类似于1998-04-13")
    @ApiModelProperty(value = "预计到货日期",required =false )
    private String expectDate;
    @Length(max = 32,message = "业务负责人长度不能超过32")
    @ApiModelProperty(value = "业务负责人",required =false )
    private String respName;
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
    @Length(max = 32,message = "供货方地址长度不能超过32")
    @ApiModelProperty(value = "供货方地址",required =false )
    private String supplyAddr;
    @Length(max = 256,message = "备注长度最大为256")
    @ApiModelProperty(value = "备注",required =false )
    private String memo;

    public String getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(String expectDate) {
        this.expectDate = expectDate;
    }

    public String getRespName() {
        return respName;
    }

    public void setRespName(String respName) {
        this.respName = respName;
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



    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
