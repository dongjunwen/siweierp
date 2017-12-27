package com.fangxin.siwei.fangzhi.vo.result;

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
@ApiModel(value = "用户角色显示实体 SysUserRoleResultVo")
public class SysUserRoleResultVo implements Serializable {
    @ApiModelProperty(value = "主键Id",required =true )
    private Integer id;
    @ApiModelProperty(value = "登录号",required =true )
    private String userNo;
    @ApiModelProperty(value = "角色代码",required = true)
    private String roleCode;
    @ApiModelProperty(value = "角色名称",required = true)
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
