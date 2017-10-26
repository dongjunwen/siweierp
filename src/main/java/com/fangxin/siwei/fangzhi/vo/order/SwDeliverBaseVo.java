package com.fangxin.siwei.fangzhi.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Date:2017/10/26 0026 14:29
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "发货单Vo SwDeliverBaseVo")
public class SwDeliverBaseVo {
    @Pattern(regexp="[0-9]{4}-[0-9]{2}-[0-9]{2}", message="发货日期格式不正确，正确的格式类似于1998-04-13")
    @ApiModelProperty(value = "发货日期",required =false )
    private String deilverDate;
    @Length(max = 16,message = "发货方式长度不能超过16")
    @ApiModelProperty(value = "发货方式",required =false )
    private String deilverWay;
    @Length(max = 32,message = "发货人长度不能超过32")
    @ApiModelProperty(value = "发货人",required =false )
    private String sendName;
    @Length(max = 1,message = "发货方式长度不能超过1")
    @ApiModelProperty(value = "是否保价 Y:是 N:否",required =false )
    private String ifGurant;
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



    public String getDeilverDate() {
        return deilverDate;
    }

    public void setDeilverDate(String deilverDate) {
        this.deilverDate = deilverDate;
    }

    public String getDeilverWay() {
        return deilverWay;
    }

    public void setDeilverWay(String deilverWay) {
        this.deilverWay = deilverWay;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getIfGurant() {
        return ifGurant;
    }

    public void setIfGurant(String ifGurant) {
        this.ifGurant = ifGurant;
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

    /*public String getCreateNo() {
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
    }*/
}
