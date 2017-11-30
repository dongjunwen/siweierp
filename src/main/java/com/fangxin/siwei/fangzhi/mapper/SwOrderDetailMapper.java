package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwOrderDetail;

import java.util.List;
import java.util.Map;

public interface SwOrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwOrderDetail record);

    int insertSelective(SwOrderDetail record);

    SwOrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwOrderDetail record);

    int updateByPrimaryKey(SwOrderDetail record);

    int insertBatch(List swOrderDetails);

    List<SwOrderDetail> selectByOrderNo(String orderNo);

    void updateBatch(List swOrderDetails);

    int countNum(Map<String, String> params);

    List<SwOrderDetail> findList(Map<String, String> params);
}