package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwFormularInfo;

public interface SwFormularInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwFormularInfo record);

    int insertSelective(SwFormularInfo record);

    SwFormularInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwFormularInfo record);

    int updateByPrimaryKey(SwFormularInfo record);
}