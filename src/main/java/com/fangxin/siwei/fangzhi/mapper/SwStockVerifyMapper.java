package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwStockVerify;

import java.util.List;

public interface SwStockVerifyMapper extends MyMapper<SwStockVerify>{


    void insertBatch(List<SwStockVerify> swStockVerifies);

    SwStockVerify selectByStockInNo(String stockInNo);

    int updateByNo(SwStockVerify swStockVerify);
}