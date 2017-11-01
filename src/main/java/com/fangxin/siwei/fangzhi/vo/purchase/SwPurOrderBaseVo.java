package com.fangxin.siwei.fangzhi.vo.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * @String:2017/11/1 0001 13:57
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "采购单Vo SwPurOrderBaseVo")
public class SwPurOrderBaseVo {
    @Length(max = 32,message = "采购单号长度不能超过32")
    @ApiModelProperty(value = "采购单号",required =false )
    private String purNo;
    @Pattern(regexp="[0-9]{4}-[0-9]{2}-[0-9]{2}", message="采购日期格式不正确，正确的格式类似于1998-04-13")
    @ApiModelProperty(value = "采购日期",required =false )
    private String purDate;
    @Pattern(regexp="[0-9]{4}-[0-9]{2}-[0-9]{2}", message="预计到货日期格式不正确，正确的格式类似于1998-04-13")
    @ApiModelProperty(value = "预计到货日期",required =false )
    private String expectDate;

    private String respName;

    private String supplyCompNo;

    private String supplyCompName;

    private String supplyContactName;

    private String supplyMobile;

    private String supplyPhone;

    private String supplyTax;

    private String supplyAddr;

    private BigDecimal purAmt;

    private BigDecimal purNum;

    private String purStatus;

    private String memo;

    public String getPurNo() {
        return purNo;
    }

    public void setPurNo(String purNo) {
        this.purNo = purNo;
    }

    public String getPurDate() {
        return purDate;
    }

    public void setPurDate(String purDate) {
        this.purDate = purDate;
    }

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

    public BigDecimal getPurAmt() {
        return purAmt;
    }

    public void setPurAmt(BigDecimal purAmt) {
        this.purAmt = purAmt;
    }

    public BigDecimal getPurNum() {
        return purNum;
    }

    public void setPurNum(BigDecimal purNum) {
        this.purNum = purNum;
    }

    public String getPurStatus() {
        return purStatus;
    }

    public void setPurStatus(String purStatus) {
        this.purStatus = purStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
