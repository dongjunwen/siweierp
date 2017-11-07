package com.fangxin.siwei.fangzhi.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Date:2017/10/26 0026 14:20
 * @Author lu.dong
 * @Description：发货单
 **/
@ApiModel(value = "发货单Vo SwDeliverVo")
public class SwDeliverModiVo {
    @ApiModelProperty(value = "基础数据",required =false )
    private SwDeliverBaseModiVo swDeliverBaseModiVo;
    @ApiModelProperty(value = "明细数据",required =false )
    private List<SwDeliverDetailVo> swDeliverDetailVoList;

    public SwDeliverBaseModiVo getSwDeliverBaseModiVo() {
        return swDeliverBaseModiVo;
    }

    public void setSwDeliverBaseModiVo(SwDeliverBaseModiVo swDeliverBaseModiVo) {
        this.swDeliverBaseModiVo = swDeliverBaseModiVo;
    }

    public List<SwDeliverDetailVo> getSwDeliverDetailVoList() {
        return swDeliverDetailVoList;
    }

    public void setSwDeliverDetailVoList(List<SwDeliverDetailVo> swDeliverDetailVoList) {
        this.swDeliverDetailVoList = swDeliverDetailVoList;
    }
}
