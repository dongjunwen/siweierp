package com.fangxin.siwei.fangzhi.vo.result;

import java.util.List;

/**
 * @Date:2017/11/7 0007 14:26
 * @Author lu.dong
 * @Description：
 **/
public class SwReceiveResultVo {
    private SwReceiveBaseResultVo swReceiveBaseResultVo;
    private List<SwReceiveDetailResultVo> swReceiveDetailResultVoList;

    public SwReceiveBaseResultVo getSwReceiveBaseResultVo() {
        return swReceiveBaseResultVo;
    }

    public void setSwReceiveBaseResultVo(SwReceiveBaseResultVo swReceiveBaseResultVo) {
        this.swReceiveBaseResultVo = swReceiveBaseResultVo;
    }

    public List<SwReceiveDetailResultVo> getSwReceiveDetailResultVoList() {
        return swReceiveDetailResultVoList;
    }

    public void setSwReceiveDetailResultVoList(List<SwReceiveDetailResultVo> swReceiveDetailResultVoList) {
        this.swReceiveDetailResultVoList = swReceiveDetailResultVoList;
    }
}
