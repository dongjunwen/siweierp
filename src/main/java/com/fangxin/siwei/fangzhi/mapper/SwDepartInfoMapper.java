package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwDepartInfo;

public interface SwDepartInfoMapper extends MyMapper<SwDepartInfo> {
   

    SwDepartInfo selectByDepartNo(String departNo);

    int updateByCompNo(SwDepartInfo swDepartInfo);

}