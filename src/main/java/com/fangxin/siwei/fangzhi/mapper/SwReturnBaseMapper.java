package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwReturnBase;

public interface SwReturnBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwReturnBase record);

    int insertSelective(SwReturnBase record);

    SwReturnBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwReturnBase record);

    int updateByPrimaryKey(SwReturnBase record);
}