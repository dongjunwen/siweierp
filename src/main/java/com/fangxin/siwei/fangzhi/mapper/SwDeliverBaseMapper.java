package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwDeliverBase;

public interface SwDeliverBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwDeliverBase record);

    int insertSelective(SwDeliverBase record);

    SwDeliverBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwDeliverBase record);

    int updateByPrimaryKey(SwDeliverBase record);
}