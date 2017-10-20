package com.fangxin.siwei.fangzhi.vo;

import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Date:2017/10/20 0020 16:52
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "部门操作实体 swDepartInfoVo")
public class SwDepartInfoVo {

    @NotBlank(message = "部门代码不能为空",groups = {AddGroup.class})
    @Length(min = 1,max = 32,message = "部门代码长度不能超过32")
    @ApiModelProperty(value = "部门代码",required =true )
    private String departNo;
    @Length(min = 1,max = 64,message = "部门名称长度不能超过32")
    @ApiModelProperty(value = "部门名称",required =false )
    private String departName;
    @Length(max = 32,message = "上级部门代码长度不能超过32")
    @ApiModelProperty(value = "上级部门代码",required =false )
    private String fhDepartNo;
    @Length(max = 32,message = "公司代码长度不能超过32")
    @ApiModelProperty(value = "公司代码",required =false )
    private String compNo;
    @Length(max = 128,message = "备注长度不能超过128")
    @ApiModelProperty(value = "备注",required =false )
    private String memo;

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

    public String getFhDepartNo() {
        return fhDepartNo;
    }

    public void setFhDepartNo(String fhDepartNo) {
        this.fhDepartNo = fhDepartNo;
    }

    public String getCompNo() {
        return compNo;
    }

    public void setCompNo(String compNo) {
        this.compNo = compNo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
