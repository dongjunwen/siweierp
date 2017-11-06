package com.fangxin.siwei.fangzhi.vo.result;

import java.util.List;

/**
 * @Date:2017/11/6 0006 17:26
 * @Author lu.dong
 * @Description：
 **/
public class SwReturnResultVo{

    private SwReturnBaseResultVo swReturnBaseResultVo;

    private List<SwReturnDetailResultVo> swReturnDetailResultVoList;

    public SwReturnBaseResultVo getSwReturnBaseResultVo() {
        return swReturnBaseResultVo;
    }

    public void setSwReturnBaseResultVo(SwReturnBaseResultVo swReturnBaseResultVo) {
        this.swReturnBaseResultVo = swReturnBaseResultVo;
    }

    public List<SwReturnDetailResultVo> getSwReturnDetailResultVoList() {
        return swReturnDetailResultVoList;
    }

    public void setSwReturnDetailResultVoList(List<SwReturnDetailResultVo> swReturnDetailResultVoList) {
        this.swReturnDetailResultVoList = swReturnDetailResultVoList;
    }
}
