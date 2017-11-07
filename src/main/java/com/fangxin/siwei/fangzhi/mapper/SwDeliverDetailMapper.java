package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwDeliverDetail;

import java.util.List;

public interface SwDeliverDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwDeliverDetail record);

    int insertSelective(SwDeliverDetail record);

    SwDeliverDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwDeliverDetail record);

    int updateByPrimaryKey(SwDeliverDetail record);

    void insertBatch(List swDeliverDetails);

    List<SwDeliverDetail> selectByDeliverNo(String orderNo);

    void updateBatch(List swDeliverDetails);
}