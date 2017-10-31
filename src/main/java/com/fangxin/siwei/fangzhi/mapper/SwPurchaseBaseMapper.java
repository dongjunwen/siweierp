package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwPurchaseBase;

public interface SwPurchaseBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwPurchaseBase record);

    int insertSelective(SwPurchaseBase record);

    SwPurchaseBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwPurchaseBase record);

    int updateByPrimaryKey(SwPurchaseBase record);
}