package com.fangxin.siwei.fangzhi.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "业务订单查询Vo SwOrderQueryVo")
public class SwOrderQueryVo {
    @ApiModelProperty(value = "客户代码",required =false )
    private String custCompNo;
    @ApiModelProperty(value = "订单号",required =false )
    private String orderNo;

    public String getCustCompNo() {
        return custCompNo;
    }

    public void setCustCompNo(String custCompNo) {
        this.custCompNo = custCompNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "SwOrderQueryVo{" +
                "custCompNo='" + custCompNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
