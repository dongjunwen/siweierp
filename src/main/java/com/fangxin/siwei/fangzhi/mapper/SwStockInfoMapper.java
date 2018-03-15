package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwStockInfo;
import com.fangxin.siwei.fangzhi.vo.stock.SwStockInfoQueryVo;

import java.util.List;
import java.util.Map;

public interface SwStockInfoMapper  extends MyMapper<SwStockInfo>{

    int addNum(SwStockInfo swStockInfo);

    SwStockInfo selectByMaterialNo(String materialNo);

    int updateByNo(SwStockInfo swStockInfo);

    List<SwStockInfo> selecByCond(Map<String, String> params);

    int countByCondition(Map<String, String> params);

    List<SwStockInfo> findList(Map<String, String> params);

    int batchAdd(List<SwStockInfo> swStockInfos);

    List<SwStockInfo> selectByList(List<SwStockInfo> swStockInfos);
}