package com.fangxin.siwei.fangzhi.service.impl.stock;

import com.fangxin.siwei.fangzhi.mapper.SwStockInfoMapper;
import com.fangxin.siwei.fangzhi.modal.SwStockIn;
import com.fangxin.siwei.fangzhi.modal.SwStockInfo;
import com.fangxin.siwei.fangzhi.service.stock.StockInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/11/7 0007 16:36
 * @Author lu.dong
 * @Description：
 **/
@Service
public class StockInfoServiceImpl implements StockInfoService {
    @Resource
    SwStockInfoMapper swStockInfoMapper;

    /**
     * 新增或修改库存数量
     * @param swStockIns
     * @return
     */
    @Override
    public int saveStock(List<SwStockIn> swStockIns) {
        int saveNum=0;
        for(SwStockIn swStockIn: swStockIns){
            SwStockInfo swStockInfo=new SwStockInfo();
            swStockInfo.setMaterialNo(swStockIn.getMaterialNo());
            swStockInfo.setNum(swStockIn.getNum());
            swStockInfo.setModiTime(new Date());
            swStockInfo.setVersion(0);
            SwStockInfo oldSwStockInfo=swStockInfoMapper.selectByMaterialNo(swStockInfo.getMaterialNo());
            if(oldSwStockInfo==null){
                saveNum=swStockInfoMapper.insertSelective(swStockInfo);
            }else{
                swStockInfo.setVersion(oldSwStockInfo.getVersion());
                saveNum=swStockInfoMapper.addNum(swStockInfo);
            }
            saveNum++;
        }
        return saveNum;
    }

    @Override
    public void updateByNo(SwStockIn swStockIn) {
        SwStockInfo swStockInfo=new SwStockInfo();
        swStockInfo.setMaterialNo(swStockIn.getMaterialNo());
        swStockInfo.setNum(swStockIn.getNum());
        swStockInfo.setModiTime(new Date());
        SwStockInfo oldSwStockInfo=swStockInfoMapper.selectByMaterialNo(swStockInfo.getMaterialNo());
        swStockInfo.setVersion(oldSwStockInfo.getVersion());
        swStockInfoMapper.addNum(swStockInfo);
    }
}
