package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwReturnBase;

public interface SwReturnBaseMapper  extends MyMapper<SwReturnBase> {


    SwReturnBase selectByReturnNo(String orderNo);

    int updateByReturnNo(SwReturnBase swReturnBase);
}