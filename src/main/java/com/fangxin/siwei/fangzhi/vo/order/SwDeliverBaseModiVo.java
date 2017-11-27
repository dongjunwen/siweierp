package com.fangxin.siwei.fangzhi.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * @Date:2017/10/26 0026 14:29
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "发货单Vo SwDeliverBaseModiVo")
public class SwDeliverBaseModiVo extends SwDeliverBaseVo {

    @Length(max = 32,message = "发货编号长度不能超过32")
    @ApiModelProperty(value = "发货编号",required =false )
    private String deliverNo;

    public String getDeliverNo() {
        return deliverNo;
    }

    public void setDeliverNo(String deliverNo) {
        this.deliverNo = deliverNo;
    }
}
