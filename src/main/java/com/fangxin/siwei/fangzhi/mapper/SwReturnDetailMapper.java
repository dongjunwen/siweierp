package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwReturnDetail;

public interface SwReturnDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwReturnDetail record);

    int insertSelective(SwReturnDetail record);

    SwReturnDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwReturnDetail record);

    int updateByPrimaryKey(SwReturnDetail record);
}