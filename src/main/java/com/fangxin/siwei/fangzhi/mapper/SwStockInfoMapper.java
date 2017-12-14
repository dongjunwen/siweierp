package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwStockInfo;

public interface SwStockInfoMapper  extends MyMapper<SwStockInfo>{

    int addNum(SwStockInfo swStockInfo);

    SwStockInfo selectByMaterialNo(String materialNo);

    int updateByNo(SwStockInfo swStockInfo);
}