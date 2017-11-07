package com.fangxin.siwei.fangzhi.vo.produce;

import java.util.List;

/**
 * @Date:2017/11/7 0007 14:20
 * @Author lu.dong
 * @Description：
 **/
public class SwReceiveVo {
    private SwReceiveBaseVo swReceiveBaseVo;

    private List<SwReceiveDetailVo> swReceiveDetailVoList;

    public SwReceiveBaseVo getSwReceiveBaseVo() {
        return swReceiveBaseVo;
    }

    public void setSwReceiveBaseVo(SwReceiveBaseVo swReceiveBaseVo) {
        this.swReceiveBaseVo = swReceiveBaseVo;
    }

    public List<SwReceiveDetailVo> getSwReceiveDetailVoList() {
        return swReceiveDetailVoList;
    }

    public void setSwReceiveDetailVoList(List<SwReceiveDetailVo> swReceiveDetailVoList) {
        this.swReceiveDetailVoList = swReceiveDetailVoList;
    }
}
