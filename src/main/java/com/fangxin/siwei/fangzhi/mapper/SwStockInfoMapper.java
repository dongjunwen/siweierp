package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwStockInfo;

public interface SwStockInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwStockInfo record);

    int insertSelective(SwStockInfo record);

    SwStockInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwStockInfo record);

    int updateByPrimaryKey(SwStockInfo record);
}