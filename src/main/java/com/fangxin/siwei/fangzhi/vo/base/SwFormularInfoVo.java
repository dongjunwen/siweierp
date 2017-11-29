package com.fangxin.siwei.fangzhi.vo.base;

import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;

/**
 * @Date:2017/10/20 0020 17:27
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "公式操作实体 swFormularInfoVo")
public class SwFormularInfoVo {

    @NotBlank(message = "公式代码不能为空",groups = {AddGroup.class})
    @Length(min = 1,max = 32,message = "公式代码长度不能超过32")
    @ApiModelProperty(value = "公式代码",required =true )
    private String formularNo;
    @Length(min = 1,max = 32,message = "公式名称长度不能超过32")
    @ApiModelProperty(value = "公式名称",required =true )
    private String formularName;
    @Length(min = 1,max = 32,message = "公式值长度不能超过32")
    @ApiModelProperty(value = "公式值",required =true )
    private String formularValue;
    @DecimalMin(value = "0.00")
    @ApiModelProperty(value = "单价",required =true )
    private String formularPrice;
    @Length(min = 1,max = 32,message = "公式类型不能超过32")
    @ApiModelProperty(value = "公式类型",required =true )
    private String formularType;
    @Length(min = 0,max = 128,message = "公式备注不能超过128")
    @ApiModelProperty(value = "公式备注",required =true )
    private String memo;

    public String getFormularNo() {
        return formularNo;
    }

    public void setFormularNo(String formularNo) {
        this.formularNo = formularNo;
    }

    public String getFormularName() {
        return formularName;
    }

    public void setFormularName(String formularName) {
        this.formularName = formularName;
    }

    public String getFormularValue() {
        return formularValue;
    }

    public void setFormularValue(String formularValue) {
        this.formularValue = formularValue;
    }

    public String getFormularType() {
        return formularType;
    }

    public void setFormularType(String formularType) {
        this.formularType = formularType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getFormularPrice() {
        return formularPrice;
    }

    public void setFormularPrice(String formularPrice) {
        this.formularPrice = formularPrice;
    }
}
