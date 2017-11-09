package com.fangxin.siwei.fangzhi.service.stock;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.result.StockInResultVo;
import com.fangxin.siwei.fangzhi.vo.stock.StockInVo;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/7 0007 15:31
 * @Author lu.dong
 * @Description：
 **/
public interface StockInService {
    Result<List<StockInResultVo>> create(String reqNo);

    Result<Integer> update(StockInVo stockInVo);

    Page<StockInResultVo> findList(Map<String, String> params);
}
