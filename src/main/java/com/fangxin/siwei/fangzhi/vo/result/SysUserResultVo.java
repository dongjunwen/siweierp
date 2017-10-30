package com.fangxin.siwei.fangzhi.vo.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Date:2017/10/30 0030 10:26
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "用户结果实体 SysUserResultVo")
public class SysUserResultVo {
    @ApiModelProperty(value = "用户号")
    private String userNo;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "手机号")
    private String phoneNum;
    @ApiModelProperty(value = "邮箱地址")
    private String emailAddr;
    @ApiModelProperty(value = "角色编码")
    private String roleCode;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "部门编号")
    private String departNo;
    @ApiModelProperty(value = "部门名称")
    private String departName;
    @ApiModelProperty(value = "所属公司信息")
    private SwCompInfoResultVo swCompInfoResultVo;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDepartNo() {
        return departNo;
    }

    public void setDepartNo(String departNo) {
        this.departNo = departNo;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public SwCompInfoResultVo getSwCompInfoResultVo() {
        return swCompInfoResultVo;
    }

    public void setSwCompInfoResultVo(SwCompInfoResultVo swCompInfoResultVo) {
        this.swCompInfoResultVo = swCompInfoResultVo;
    }
}
