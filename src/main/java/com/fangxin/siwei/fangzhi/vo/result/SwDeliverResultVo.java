package com.fangxin.siwei.fangzhi.vo.result;

import java.util.List;

/**
 * @Date:2017/10/26 0026 14:21
 * @Author lu.dong
 * @Description：
 **/
public class SwDeliverResultVo {
    private SwDeliverBaseResutVo swDeliverBaseResutVo;
    private List<SwDeliverDetailResutVo> swDeliverDetailResutVos;

    public SwDeliverBaseResutVo getSwDeliverBaseResutVo() {
        return swDeliverBaseResutVo;
    }

    public void setSwDeliverBaseResutVo(SwDeliverBaseResutVo swDeliverBaseResutVo) {
        this.swDeliverBaseResutVo = swDeliverBaseResutVo;
    }

    public List<SwDeliverDetailResutVo> getSwDeliverDetailResutVos() {
        return swDeliverDetailResutVos;
    }

    public void setSwDeliverDetailResutVos(List<SwDeliverDetailResutVo> swDeliverDetailResutVos) {
        this.swDeliverDetailResutVos = swDeliverDetailResutVos;
    }
}
