package com.fangxin.siwei.fangzhi.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Date:2017/11/5 0005 16:22
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "业务订单修改Vo SwOrderModiVo")
public class SwOrderModiVo {
    @NotNull(message = "基础数据不能为空!")
    @ApiModelProperty(value = "基础数据",required =false )
    private SwOrderBaseModiVo swOrderBaseModiVo;
    @ApiModelProperty(value = "明细数据",required =false )
    private List<SwOrderDetailVo> swOrderDetailVos;


    public SwOrderBaseModiVo getSwOrderBaseModiVo() {
        return swOrderBaseModiVo;
    }

    public void setSwOrderBaseModiVo(SwOrderBaseModiVo swOrderBaseModiVo) {
        this.swOrderBaseModiVo = swOrderBaseModiVo;
    }

    public List<SwOrderDetailVo> getSwOrderDetailVos() {
        return swOrderDetailVos;
    }

    public void setSwOrderDetailVos(List<SwOrderDetailVo> swOrderDetailVos) {
        this.swOrderDetailVos = swOrderDetailVos;
    }
}
