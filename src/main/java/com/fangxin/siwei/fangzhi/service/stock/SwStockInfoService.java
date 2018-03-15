package com.fangxin.siwei.fangzhi.service.stock;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SwStockInfo;
import com.fangxin.siwei.fangzhi.vo.result.SwStockInfoResultVo;
import com.fangxin.siwei.fangzhi.vo.stock.SwStockInfoQueryVo;
import com.fangxin.siwei.fangzhi.vo.stock.SwStockInfoVo;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/7 0007 16:35
 * @Author lu.dong
 * @Description：
 **/
public interface SwStockInfoService {

    int saveSingleStock(SwStockInfo swStockInfo);

    Page<SwStockInfoResultVo> findList(Map<String, String> params);

    Result<List<SwStockInfoVo>> batchImport(MultipartFile mFile);

    Result<Integer> saveStockInfo(SwStockInfoVo swStockInfoVo);

    List<SwStockInfoResultVo> findCond(Map<String, String> params);

    Result<Integer> batchAdd(List<SwStockInfo> swStockInfos);
}
