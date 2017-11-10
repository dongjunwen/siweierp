package com.fangxin.siwei.fangzhi.service.impl.stock;

import com.fangxin.siwei.fangzhi.mapper.SwStockInfoMapper;
import com.fangxin.siwei.fangzhi.modal.SwStockInfo;
import com.fangxin.siwei.fangzhi.service.stock.StockInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Date:2017/11/7 0007 16:36
 * @Author lu.dong
 * @Description：
 **/
@Service
public class StockInfoServiceImpl implements StockInfoService {
    @Resource
    SwStockInfoMapper swStockInfoMapper;

    @Override
    public int saveSingleStock(SwStockInfo swStockInfo) {
        int saveNum=0;
        swStockInfo.setNum(swStockInfo.getNum());
        swStockInfo.setModiTime(new Date());
        SwStockInfo oldSwStockInfo=swStockInfoMapper.selectByMaterialNo(swStockInfo.getMaterialNo());
        if(oldSwStockInfo==null){
            swStockInfo.setVersion(0);
            saveNum=swStockInfoMapper.insertSelective(swStockInfo);
        }else{

            swStockInfo.setVersion(oldSwStockInfo.getVersion());
            saveNum=swStockInfoMapper.addNum(swStockInfo);
        }
        return  saveNum;
    }
}
