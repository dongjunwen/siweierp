package com.fangxin.siwei.fangzhi.vo.system;

import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Date:2017/12/25 0025 14:46
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "角色操作实体 SysResourceVo")
public class SysRoleVo {
    @NotBlank(message = "角色代码不能为空",groups = {AddGroup.class})
    @Length(min = 1,max = 32,message = "角色代码长度不能超过32")
    @ApiModelProperty(value = "角色代码",required =true )
    private String roleCode;
    @NotBlank(message = "角色名称不能为空",groups = {AddGroup.class})
    @Length(min = 1,max = 64,message = "角色名称长度不能超过64")
    @ApiModelProperty(value = "角色名称",required =true )
    private String roleName;
    @Length(max = 1,message = "状态长度不能超过1 默认为Y ")
    @ApiModelProperty(value = "状态",required =false )
    private String status;
    @Length(max = 1,message = "是否超级角色长度不能超过1 默认为N ")
    @ApiModelProperty(value = "是否超级角色",required =false )
    private String ifAdmin;
    @Length(max = 64,message = "备注长度不能超过64")
    @ApiModelProperty(value = "备注",required =false )
    private String memo;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIfAdmin() {
        return ifAdmin;
    }

    public void setIfAdmin(String ifAdmin) {
        this.ifAdmin = ifAdmin;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
