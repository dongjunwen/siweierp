package com.fangxin.siwei.fangzhi.vo.result;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Date:2017/12/25 0025 17:26
 * @Author lu.dong
 * @Description：
 **/
public class SysDepartEmployeeResultVo {
    @ApiModelProperty(value = "主键ID",required =true )
    private Integer id;
    @ApiModelProperty(value = "部门代码",required =true )
    private String departNo;
    @ApiModelProperty(value = "部门名称",required =true )
    private String departName;
    @ApiModelProperty(value = "用户代码",required =true )
    private String userNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
