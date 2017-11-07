package com.fangxin.siwei.fangzhi.vo.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * @String:2017/11/1 0001 13:57
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "采购单Vo SwPurOrderBaseModiVo")
public class SwPurOrderBaseModiVo extends  SwPurOrderBaseVo{
    @Length(max = 32,message = "采购单号长度不能超过32")
    @ApiModelProperty(value = "采购单号",required =false )
    private String purNo;

    public String getPurNo() {
        return purNo;
    }

    public void setPurNo(String purNo) {
        this.purNo = purNo;
    }
}
