package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwReceiveDetail;

import java.util.List;

public interface SwReceiveDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwReceiveDetail record);

    int insertSelective(SwReceiveDetail record);

    SwReceiveDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwReceiveDetail record);

    int updateByPrimaryKey(SwReceiveDetail record);

    void insertBatch(List swReceiveDetails);

    List<SwReceiveDetail> selectByReceiveNo(String orderNo);

    void updateBatch(List swReceiveDetails);
}