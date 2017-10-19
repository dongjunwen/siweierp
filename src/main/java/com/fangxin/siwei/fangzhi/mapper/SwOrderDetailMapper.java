package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwOrderDetail;

public interface SwOrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwOrderDetail record);

    int insertSelective(SwOrderDetail record);

    SwOrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwOrderDetail record);

    int updateByPrimaryKey(SwOrderDetail record);
}