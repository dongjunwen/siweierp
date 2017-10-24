package com.fangxin.siwei.fangzhi.vo.base;

import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @Date:2017/10/20 0020 14:20
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "公司操作实体 SwCompInfoVo")
public class SwCompInfoVo {
    @NotBlank(message = "公司代码不能为空",groups = {AddGroup.class})
    @Length(min = 1,max = 32,message = "公司代码长度不能超过32")
    @ApiModelProperty(value = "公司代码",required =true )
    private String compNo;
    @Length(min = 1,max = 128,message = "公司名称长度不能超过128")
    @ApiModelProperty(value = "公司名称",required =false )
    private String compName;
    @Length(max = 64,message = "联系人长度不能超过64")
    @ApiModelProperty(value = "联系人",required =false )
    private String contactName;
    @Length(max = 32,message = "手机长度不能超过32")
    @ApiModelProperty(value = "手机",required =false )
    private String mobile;
    @Length(max = 32,message = "电话长度不能超过32")
    @ApiModelProperty(value = "电话",required =false )
    private String telphone;
    @Length(max = 32,message = "传真长度不能超过32")
    @ApiModelProperty(value = "传真",required =false )
    private String tax;
    @Length(max = 32,message = "邮箱长度不能超过32")
    @ApiModelProperty(value = "邮箱",required =false )
    private String email;
    @Length(max = 128,message = "联系地址长度不能超过128")
    @ApiModelProperty(value = "地址",required =false )
    private String addr;
    @Length(max = 1,message = "是否本公司长度不能超过1")
    @ApiModelProperty(value = "是否本公司 Y:是 N:否 默认为N",required =false )
    private String isSelf;

    public String getCompNo() {
        return compNo;
    }

    public void setCompNo(String compNo) {
        this.compNo = compNo;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(String isSelf) {
        this.isSelf = isSelf;
    }

    @Override
    public String toString() {
        return "SwCompInfoVo{" +
                "compNo='" + compNo + '\'' +
                ", compName='" + compName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", telphone='" + telphone + '\'' +
                ", tax='" + tax + '\'' +
                ", email='" + email + '\'' +
                ", addr='" + addr + '\'' +
                ", isSelf='" + isSelf + '\'' +
                '}';
    }
}
