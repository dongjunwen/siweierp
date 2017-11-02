package com.fangxin.siwei.fangzhi.vo.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Date:2017/11/1 0001 13:43
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "采购单Vo SwPurVo")
public class SwPurOrderVo {
    @ApiModelProperty(value = "基础数据",required =false )
    private SwPurOrderBaseVo swPurOrderBaseVo;
    @ApiModelProperty(value = "明细数据",required =false )
    private List<SwPurOrderDetailVo> swPurOrderDetailVo;

    public SwPurOrderBaseVo getSwPurOrderBaseVo() {
        return swPurOrderBaseVo;
    }

    public void setSwPurOrderBaseVo(SwPurOrderBaseVo swPurOrderBaseVo) {
        this.swPurOrderBaseVo = swPurOrderBaseVo;
    }

    public List<SwPurOrderDetailVo> getSwPurOrderDetailVo() {
        return swPurOrderDetailVo;
    }

    public void setSwPurOrderDetailVo(List<SwPurOrderDetailVo> swPurOrderDetailVo) {
        this.swPurOrderDetailVo = swPurOrderDetailVo;
    }
}
