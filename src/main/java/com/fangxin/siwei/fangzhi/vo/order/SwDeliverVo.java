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
public class SwDeliverVo {
    @ApiModelProperty(value = "基础数据",required =false )
    private SwDeliverBaseVo swDeliverBaseVo;
    @ApiModelProperty(value = "明细数据",required =false )
    private List<SwDeliverDetailVo> swDeliverDetailVoList;

    public SwDeliverBaseVo getSwDeliverBaseVo() {
        return swDeliverBaseVo;
    }

    public void setSwDeliverBaseVo(SwDeliverBaseVo swDeliverBaseVo) {
        this.swDeliverBaseVo = swDeliverBaseVo;
    }

    public List<SwDeliverDetailVo> getSwDeliverDetailVoList() {
        return swDeliverDetailVoList;
    }

    public void setSwDeliverDetailVoList(List<SwDeliverDetailVo> swDeliverDetailVoList) {
        this.swDeliverDetailVoList = swDeliverDetailVoList;
    }
}
