package com.fangxin.siwei.fangzhi.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Date:2017/11/5 0005 16:22
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "业务基础订单修改Vo SwOrderBaseModiVo")
public class SwOrderBaseModiVo extends  SwOrderBaseVo {
    @NotNull
    @Length(min =1,max = 32,message = "订单号长度不能超过32")
    @ApiModelProperty(value = "订单号",required =false )
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
