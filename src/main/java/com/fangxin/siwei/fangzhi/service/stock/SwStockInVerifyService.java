package com.fangxin.siwei.fangzhi.service.stock;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.result.StockVerifyResultVo;
import com.fangxin.siwei.fangzhi.vo.stock.StockVerifyVo;
import com.fangxin.siwei.fangzhi.vo.stock.StockVerifyActionVo;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/7 0007 15:31
 * @Author lu.dong
 * @Description：
 **/
public interface SwStockInVerifyService {
    Result<List<StockVerifyResultVo>> create(String reqNo);

    Result<Integer> update(StockVerifyVo stockInVo);

    Page<StockVerifyResultVo> findList(Map<String, String> params);

    Result<Integer> check(StockVerifyActionVo stockVerifyActionVo);
}
