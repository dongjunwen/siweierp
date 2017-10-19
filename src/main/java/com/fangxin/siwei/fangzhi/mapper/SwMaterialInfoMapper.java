package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwMaterialInfo;

public interface SwMaterialInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwMaterialInfo record);

    int insertSelective(SwMaterialInfo record);

    SwMaterialInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwMaterialInfo record);

    int updateByPrimaryKey(SwMaterialInfo record);
}