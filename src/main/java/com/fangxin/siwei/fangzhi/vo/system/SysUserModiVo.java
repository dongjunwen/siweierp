package com.fangxin.siwei.fangzhi.vo.system;

import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Date:2017/11/6 0006 16:31
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "用户操作实体 SysUserModiVo")
public class SysUserModiVo {

    @NotBlank(message = "登录号不能为空",groups = {AddGroup.class})
    @ApiModelProperty(value = "登录号",required =true )
    private String userNo;
    @NotBlank(message = "老密码不能为空",groups = {AddGroup.class})
    @ApiModelProperty(value = "老密码",required = true)
    private String oldPass;

    @NotBlank(message = "新密码1不能为空",groups = {AddGroup.class})
    @ApiModelProperty(value = "新密码1",required = true)
    private String passwordNew1;

    @NotBlank(message = "新密码2不能为空",groups = {AddGroup.class})
    @ApiModelProperty(value = "新密码2",required = true)
    private String passwordNew2;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getPasswordNew1() {
        return passwordNew1;
    }

    public void setPasswordNew1(String passwordNew1) {
        this.passwordNew1 = passwordNew1;
    }

    public String getPasswordNew2() {
        return passwordNew2;
    }

    public void setPasswordNew2(String passwordNew2) {
        this.passwordNew2 = passwordNew2;
    }
}
