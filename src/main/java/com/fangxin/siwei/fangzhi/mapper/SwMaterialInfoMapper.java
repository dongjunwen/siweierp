package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwMaterialInfo;

public interface SwMaterialInfoMapper extends MyMapper<SwMaterialInfo>{
    

    SwMaterialInfo selectByMaterialNo(String departNo);

    int updateByMateialNo(SwMaterialInfo swDepartInfo);
}