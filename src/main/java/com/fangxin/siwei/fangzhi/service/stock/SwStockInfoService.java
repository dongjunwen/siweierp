package com.fangxin.siwei.fangzhi.service.stock;

import com.fangxin.siwei.fangzhi.modal.SwStockInfo;
import com.fangxin.siwei.fangzhi.modal.SwStockVerify;
import com.fangxin.siwei.fangzhi.vo.result.SwStockInfoResultVo;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map; /**
 * @Date:2017/11/7 0007 16:35
 * @Author lu.dong
 * @Description：
 **/
public interface SwStockInfoService {

    int saveSingleStock(SwStockInfo swStockInfo);

    Page<SwStockInfoResultVo> findList(Map<String, String> params);
}
