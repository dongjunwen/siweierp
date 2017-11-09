package com.fangxin.siwei.fangzhi.service.stock;

import com.fangxin.siwei.fangzhi.modal.SwStockIn;

import java.util.List; /**
 * @Date:2017/11/7 0007 16:35
 * @Author lu.dong
 * @Description：
 **/
public interface StockInfoService {
    int saveStock(List<SwStockIn> swStockIns);

    void updateByNo(SwStockIn swStockIn);
}
