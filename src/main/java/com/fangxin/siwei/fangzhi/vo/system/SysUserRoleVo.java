package com.fangxin.siwei.fangzhi.vo.system;

import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date:2017/10/19 0019 15:26
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "用户角色操作实体 SysUserRoleVo")
public class SysUserRoleVo implements Serializable {

    @NotBlank(message = "登录号不能为空",groups = {AddGroup.class})
    @ApiModelProperty(value = "登录号",required =true )
    private String userNo;
    @NotBlank(message = "角色代码不能为空",groups = {AddGroup.class})
    @ApiModelProperty(value = "角色代码",required = true)
    private String roleCode;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
