package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwDepartInfo;
import com.fangxin.siwei.fangzhi.modal.SwFormularInfo;

public interface SwFormularInfoMapper extends MyMapper<SwFormularInfo>{

    SwFormularInfo selectByFormularNo(String formularNo);

    int updateByFormularNo(SwFormularInfo swFormularInfo);
}