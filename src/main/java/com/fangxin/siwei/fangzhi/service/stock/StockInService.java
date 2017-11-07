package com.fangxin.siwei.fangzhi.service.stock;

import com.fangxin.siwei.fangzhi.common.result.Result;

/**
 * @Date:2017/11/7 0007 15:31
 * @Author lu.dong
 * @Description：
 **/
public interface StockInService {
    Result<Integer> create(String reqNo);
}
