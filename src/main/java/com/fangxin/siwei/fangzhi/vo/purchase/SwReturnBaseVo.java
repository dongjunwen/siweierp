package com.fangxin.siwei.fangzhi.vo.purchase;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
 * @Date:2017/11/6 0006 17:15
 * @Author lu.dong
 * @Description：
 **/
public class SwReturnBaseVo {
    @ApiModelProperty(value = "业务负责人",required =false )
    @Length(max = 32,message = "业务负责人长度不能超过32")
    private String respName;
    @ApiModelProperty(value = "供货方编号",required =false )
    @Length(max = 32,message = "供货方编号长度不能超过32")
    private String supplyCompNo;
    @ApiModelProperty(value = "供货方名称",required =false )
    @Length(max = 128,message = "供货方名称长度不能超过128")
    private String supplyCompName;
    @ApiModelProperty(value = "供货方联系人姓名",required =false )
    @Length(max = 64,message = "供货方联系人姓名长度不能超过64")
    private String supplyContactName;
    @ApiModelProperty(value = "供货方手机号",required =false )
    @Length(max = 16,message = "供货方手机号长度不能超过16")
    private String supplyMobile;
    @ApiModelProperty(value = "供货方联系电话",required =false )
    @Length(max = 16,message = "供货方电话长度不能超过16")
    private String supplyPhone;
    @ApiModelProperty(value = "供货方传真",required =false )
    @Length(max = 16,message = "供货方传真长度不能超过16")
    private String supplyTax;
    @ApiModelProperty(value = "供货方地址",required =false )
    @Length(max = 256,message = "供货方地址长度不能超过256")
    private String supplyAddr;
    @ApiModelProperty(value = "退货原因",required =false )
    @Length(max = 256,message = "退货原因长度不能超过256")
    private String returnReason;
    @ApiModelProperty(value = "备注",required =false )
    @Length(max = 256,message = "备注长度不能超过256")
    private String memo;
    private String auditName;
    private String auditDesc;

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

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }
}
