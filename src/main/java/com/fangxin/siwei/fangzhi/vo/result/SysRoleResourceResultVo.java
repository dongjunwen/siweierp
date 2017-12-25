package com.fangxin.siwei.fangzhi.vo.result;

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
@ApiModel(value = "角色资源显示实体 SysRoleResourceResultVo")
public class SysRoleResourceResultVo {
    @ApiModelProperty(value = "主键Id" )
    private Integer id;
    @ApiModelProperty(value = "资源代码" )
    private String roleCode;
    @ApiModelProperty(value = "资源代码" )
    private String sourceNo;
    @ApiModelProperty(value = "资源名称" )
    private String sourceName;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
