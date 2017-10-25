package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwOrderBase;

public interface SwOrderBaseMapper extends MyMapper<SwOrderBase>{

    int updateByOrderNo(SwOrderBase swOrderBase);

    SwOrderBase selectByOrderNo(String sourceNo);
}