package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwPurchaseDetail;

public interface SwPurchaseDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwPurchaseDetail record);

    int insertSelective(SwPurchaseDetail record);

    SwPurchaseDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwPurchaseDetail record);

    int updateByPrimaryKey(SwPurchaseDetail record);
}