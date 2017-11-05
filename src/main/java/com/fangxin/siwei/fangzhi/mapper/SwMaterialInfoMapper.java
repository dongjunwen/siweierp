package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwMaterialInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SwMaterialInfoMapper extends MyMapper<SwMaterialInfo>{
    

    SwMaterialInfo selectByMaterialNo(String departNo);

    int updateByMateialNo(SwMaterialInfo swDepartInfo);

    List<SwMaterialInfo> findMaterialLike(@Param("condStr")String condStr);
}