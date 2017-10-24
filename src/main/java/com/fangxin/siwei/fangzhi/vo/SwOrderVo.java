package com.fangxin.siwei.fangzhi.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Date:2017/10/24 0024 14:50
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "业务订单Vo SwOrderVo")
public class SwOrderVo {
    @ApiModelProperty(value = "基础数据",required =false )
    private SwOrderBaseVo swOrderBaseVo;
    @ApiModelProperty(value = "明细数据",required =false )
    private List<SwOrderDetailVo> swOrderDetailVos;

    public SwOrderBaseVo getSwOrderBaseVo() {
        return swOrderBaseVo;
    }

    public void setSwOrderBaseVo(SwOrderBaseVo swOrderBaseVo) {
        this.swOrderBaseVo = swOrderBaseVo;
    }

    public List<SwOrderDetailVo> getSwOrderDetailVos() {
        return swOrderDetailVos;
    }

    public void setSwOrderDetailVos(List<SwOrderDetailVo> swOrderDetailVos) {
        this.swOrderDetailVos = swOrderDetailVos;
    }
}
