package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwStockIn;

import java.util.List;

public interface SwStockInMapper extends MyMapper<SwStockIn>{


    int insertBatch(List<SwStockIn> swStockIns);

    SwStockIn selectByStockInNo(String stockInNo);

    int updateByNo(SwStockIn swStockIn);
}