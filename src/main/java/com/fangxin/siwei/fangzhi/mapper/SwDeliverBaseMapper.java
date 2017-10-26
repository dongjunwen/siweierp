package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwDeliverBase;

public interface SwDeliverBaseMapper extends MyMapper<SwDeliverBase> {


    int updateByDeliverNo(SwDeliverBase swDeliverBase);

    SwDeliverBase selectByDeliverNo(String orderNo);
}