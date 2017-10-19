package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwDepartInfo;

public interface SwDepartInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwDepartInfo record);

    int insertSelective(SwDepartInfo record);

    SwDepartInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwDepartInfo record);

    int updateByPrimaryKey(SwDepartInfo record);
}