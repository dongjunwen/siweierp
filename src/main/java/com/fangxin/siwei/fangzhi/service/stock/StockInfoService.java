package com.fangxin.siwei.fangzhi.service.stock;

import com.fangxin.siwei.fangzhi.modal.SwStockInfo;
import com.fangxin.siwei.fangzhi.modal.SwStockVerify;

import java.util.List; /**
 * @Date:2017/11/7 0007 16:35
 * @Author lu.dong
 * @Description：
 **/
public interface StockInfoService {

    int saveSingleStock(SwStockInfo swStockInfo);
}
