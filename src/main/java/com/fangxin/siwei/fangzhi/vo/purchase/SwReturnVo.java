package com.fangxin.siwei.fangzhi.vo.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Date:2017/11/6 0006 17:13
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "退货Vo SwReturnVo")
public class SwReturnVo {
    @ApiModelProperty(value = "退货单基础数据",required =false )
    private SwReturnBaseVo swReturnBaseVo;
    @ApiModelProperty(value = "退货单明细数据",required =false )
    private List<SwReturnDetailVo> swReturnDetailVos;

    public SwReturnBaseVo getSwReturnBaseVo() {
        return swReturnBaseVo;
    }

    public void setSwReturnBaseVo(SwReturnBaseVo swReturnBaseVo) {
        this.swReturnBaseVo = swReturnBaseVo;
    }

    public List<SwReturnDetailVo> getSwReturnDetailVos() {
        return swReturnDetailVos;
    }

    public void setSwReturnDetailVos(List<SwReturnDetailVo> swReturnDetailVos) {
        this.swReturnDetailVos = swReturnDetailVos;
    }
}
