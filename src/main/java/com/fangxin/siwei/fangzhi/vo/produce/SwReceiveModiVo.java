package com.fangxin.siwei.fangzhi.vo.produce;

import java.util.List;

/**
 * @Date:2017/11/7 0007 14:20
 * @Author lu.dong
 * @Description：
 **/
public class SwReceiveModiVo {
    private SwReceiveBaseModiVo swReceiveBaseModiVo;

    private List<SwReceiveDetailVo> swReceiveDetailVoList;

    public SwReceiveBaseModiVo getSwReceiveBaseModiVo() {
        return swReceiveBaseModiVo;
    }

    public void setSwReceiveBaseModiVo(SwReceiveBaseModiVo swReceiveBaseModiVo) {
        this.swReceiveBaseModiVo = swReceiveBaseModiVo;
    }

    public List<SwReceiveDetailVo> getSwReceiveDetailVoList() {
        return swReceiveDetailVoList;
    }

    public void setSwReceiveDetailVoList(List<SwReceiveDetailVo> swReceiveDetailVoList) {
        this.swReceiveDetailVoList = swReceiveDetailVoList;
    }
}
