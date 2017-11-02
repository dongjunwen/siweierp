package com.fangxin.siwei.fangzhi.vo.result;

import java.util.List;

/**
 * @Date:2017/11/1 0001 15:07
 * @Author lu.dong
 * @Description：
 **/
public class SwPurOrderResultVo {
    private SwPurOrderBaseResultVo swPurOrderBaseResultVo;
    private List<SwPurOrderDetailResultVo> swPurOrderDetailResultVoList;

    public SwPurOrderBaseResultVo getSwPurOrderBaseResultVo() {
        return swPurOrderBaseResultVo;
    }

    public void setSwPurOrderBaseResultVo(SwPurOrderBaseResultVo swPurOrderBaseResultVo) {
        this.swPurOrderBaseResultVo = swPurOrderBaseResultVo;
    }

    public List<SwPurOrderDetailResultVo> getSwPurOrderDetailResultVoList() {
        return swPurOrderDetailResultVoList;
    }

    public void setSwPurOrderDetailResultVoList(List<SwPurOrderDetailResultVo> swPurOrderDetailResultVoList) {
        this.swPurOrderDetailResultVoList = swPurOrderDetailResultVoList;
    }
}
