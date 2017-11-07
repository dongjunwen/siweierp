package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwStockIn;

import java.util.List;

public interface SwStockInMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwStockIn record);

    int insertSelective(SwStockIn record);

    SwStockIn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwStockIn record);

    int updateByPrimaryKey(SwStockIn record);

    int insertBatch(List<SwStockIn> swStockIns);
}