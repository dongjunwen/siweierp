package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwOrderBase;

public interface SwOrderBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwOrderBase record);

    int insertSelective(SwOrderBase record);

    SwOrderBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwOrderBase record);

    int updateByPrimaryKey(SwOrderBase record);
}