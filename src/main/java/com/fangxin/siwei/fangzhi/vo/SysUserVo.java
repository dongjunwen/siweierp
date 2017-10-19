package com.fangxin.siwei.fangzhi.vo;

import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Date:2017/10/19 0019 15:26
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "用户操作实体")
public class SysUserVo implements Serializable {
    @NotBlank(message = "登录号不能为空",groups = {AddGroup.class})
    @ApiModelProperty(value = "登录号",required =true )
    private String userNo;
    @NotBlank(message = "登录密码不能为空",groups = {AddGroup.class})
    @ApiModelProperty(value = "登录密码",required = true)
    private String password;
    @ApiModelProperty(value = "昵称",required = false)
    private String nickName;
    @ApiModelProperty(value = "手机号",required = false)
    private Integer phoneNum;
    @ApiModelProperty(value = "邮箱地址",required = false)
    private String emailAddr;
    @ApiModelProperty(value = "备注",required = false)
    private String memo;

    public SysUserVo() {
    }

    public SysUserVo(String userNo, String password, String nickName, Integer phoneNum, String emailAddr, String memo) {
        this.userNo = userNo;
        this.password = password;
        this.nickName = nickName;
        this.phoneNum = phoneNum;
        this.emailAddr = emailAddr;
        this.memo = memo;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "SysUserVo{" +
                "userNo='" + userNo + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phoneNum=" + phoneNum +
                ", emailAddr='" + emailAddr + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
