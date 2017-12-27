package com.fangxin.siwei.fangzhi.vo.base;

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
@ApiModel(value = "部门员工操作实体 SwDepartEmployeeVo")
public class SwDepartEmployeeVo {

    @NotBlank(message = "部门代码不能为空",groups = {AddGroup.class})
    @Length(min = 1,max = 32,message = "部门代码长度不能超过32")
    @ApiModelProperty(value = "部门代码",required =true )
    private String departNo;
    @NotBlank(message = "用户代码不能为空",groups = {AddGroup.class})
    @Length(min = 1,max = 32,message = "用户代码长度不能超过32")
    @ApiModelProperty(value = "用户代码",required =true )
    private String userNo;

    public String getDepartNo() {
        return departNo;
    }

    public void setDepartNo(String departNo) {
        this.departNo = departNo;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
