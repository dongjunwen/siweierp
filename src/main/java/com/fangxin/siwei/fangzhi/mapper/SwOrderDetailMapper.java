package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwOrderDetail;

import java.util.List;

public interface SwOrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwOrderDetail record);

    int insertSelective(SwOrderDetail record);

    SwOrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwOrderDetail record);

    int updateByPrimaryKey(SwOrderDetail record);

    int insertBatch(List swOrderDetails);

    List<SwOrderDetail> selectByOrderNo(String orderNo);
}