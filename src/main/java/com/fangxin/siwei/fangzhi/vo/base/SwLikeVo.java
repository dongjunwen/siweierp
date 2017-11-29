package com.fangxin.siwei.fangzhi.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Date:2017/11/29 0029 14:22
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "模糊查询条件 SwLikeVo")
public class SwLikeVo {

    @ApiModelProperty(value = "查询条件",required =true )
    private String condStr;
    @ApiModelProperty(value = "长度",required =true )
    private BigDecimal longNum;
    @ApiModelProperty(value = "宽度",required =true )
    private BigDecimal widhtNum;
    @ApiModelProperty(value = "数量",required =true )
    private BigDecimal reqNum;

    public String getCondStr() {
        return condStr;
    }

    public void setCondStr(String condStr) {
        this.condStr = condStr;
    }

    public BigDecimal getLongNum() {
        return longNum;
    }

    public void setLongNum(BigDecimal longNum) {
        this.longNum = longNum;
    }

    public BigDecimal getWidhtNum() {
        return widhtNum;
    }

    public void setWidhtNum(BigDecimal widhtNum) {
        this.widhtNum = widhtNum;
    }

    public BigDecimal getReqNum() {
        return reqNum;
    }

    public void setReqNum(BigDecimal reqNum) {
        this.reqNum = reqNum;
    }
}
