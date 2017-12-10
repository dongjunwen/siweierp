package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwPurchaseDetail;

import java.util.List;
import java.util.Map;

public interface SwPurchaseDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwPurchaseDetail record);

    int insertSelective(SwPurchaseDetail record);

    SwPurchaseDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwPurchaseDetail record);

    int updateByPrimaryKey(SwPurchaseDetail record);

    void insertBatch(List swOrderDetails);

    List<SwPurchaseDetail> selectByPurNo(String purNo);

    void updateBatch(List swOrderDetails);

    int countNum(Map<String, String> params);

    List<SwPurchaseDetail> findList(Map<String, String> params);

    void deleteByPurNo(String purNo);
}