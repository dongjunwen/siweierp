package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwReceiveBase;

public interface SwReceiveBaseMapper extends MyMapper<SwReceiveBase>{

    int updateByReceiveNo(SwReceiveBase swReceiveBase);

    SwReceiveBase selectByReceiveNo(String orderNo);
}