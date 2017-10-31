package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwStockVerify;

public interface SwStockVerifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwStockVerify record);

    int insertSelective(SwStockVerify record);

    SwStockVerify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwStockVerify record);

    int updateByPrimaryKey(SwStockVerify record);
}