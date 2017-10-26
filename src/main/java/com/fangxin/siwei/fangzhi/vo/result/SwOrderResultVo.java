package com.fangxin.siwei.fangzhi.vo.result;


import java.util.List;

/**
 * @String:2017/10/25 0025 11:33
 * @Author lu.dong
 * @Description：订单结果视图
 **/
public class SwOrderResultVo {
    //基础订单视图
    private SwOrderBaseResultVo swOrderBaseResultVo;
    //详细订单视图
    private List<SwOrderDetailResultVo> swORderDetailResultVos;

    public SwOrderBaseResultVo getSwOrderBaseResultVo() {
        return swOrderBaseResultVo;
    }

    public void setSwOrderBaseResultVo(SwOrderBaseResultVo swOrderBaseResultVo) {
        this.swOrderBaseResultVo = swOrderBaseResultVo;
    }

    public List<SwOrderDetailResultVo> getSwORderDetailResultVos() {
        return swORderDetailResultVos;
    }

    public void setSwORderDetailResultVos(List<SwOrderDetailResultVo> swORderDetailResultVos) {
        this.swORderDetailResultVos = swORderDetailResultVos;
    }
}
