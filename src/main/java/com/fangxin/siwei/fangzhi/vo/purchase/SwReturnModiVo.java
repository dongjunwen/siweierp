package com.fangxin.siwei.fangzhi.vo.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Date:2017/11/6 0006 17:15
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "退货单修改Vo SwReturnModiVo")
public class SwReturnModiVo {
    @ApiModelProperty(value = "退货单基础数据",required =false )
    private SwReturnBaseModiVo swReturnBaseModiVo;
    @ApiModelProperty(value = "退货单明细数据",required =false )
    private List<SwReturnDetailVo> swReturnDetailVos;

    public SwReturnBaseModiVo getSwReturnBaseModiVo() {
        return swReturnBaseModiVo;
    }

    public void setSwReturnBaseModiVo(SwReturnBaseModiVo swReturnBaseModiVo) {
        this.swReturnBaseModiVo = swReturnBaseModiVo;
    }

    public List<SwReturnDetailVo> getSwReturnDetailVos() {
        return swReturnDetailVos;
    }

    public void setSwReturnDetailVos(List<SwReturnDetailVo> swReturnDetailVos) {
        this.swReturnDetailVos = swReturnDetailVos;
    }
}
