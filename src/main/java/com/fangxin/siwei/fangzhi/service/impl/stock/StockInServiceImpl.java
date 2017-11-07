package com.fangxin.siwei.fangzhi.service.impl.stock;

import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.enums.StockStatus;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.mapper.SwPurchaseDetailMapper;
import com.fangxin.siwei.fangzhi.mapper.SwStockInMapper;
import com.fangxin.siwei.fangzhi.modal.SwMaterialInfo;
import com.fangxin.siwei.fangzhi.modal.SwPurchaseDetail;
import com.fangxin.siwei.fangzhi.modal.SwStockIn;
import com.fangxin.siwei.fangzhi.service.base.SwMaterialInfoService;
import com.fangxin.siwei.fangzhi.service.stock.StockInService;
import com.fangxin.siwei.fangzhi.service.stock.StockInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/11/7 0007 15:56
 * @Author lu.dong
 * @Description：
 **/
@Service
public class StockInServiceImpl implements StockInService {
    @Resource
    SwStockInMapper swStockInMapper;
    @Resource
    StockInfoService stockInfoService;
    @Resource
    SwMaterialInfoService swMaterialInfoService;
    @Resource
    SwPurchaseDetailMapper swPurchaseDetailMapper;

    /**
     * 创建入库单、新增或更新库存表
     * @param reqNo
     * @return
     */
    @Override
    @Transactional
    public Result<Integer> create(String reqNo) {
        List<SwStockIn>  swStockIns=findSourceEntityByNo(reqNo);
        if(swStockIns==null || swStockIns.size()==0){
            return Result.newError(ResultCode.SOURCE_NO_NOT_EXITS);
        }
        int countNum=swStockInMapper.insertBatch(swStockIns);
        stockInfoService.saveStock(swStockIns);
        return Result.newSuccess(countNum);
    }

    private List<SwStockIn> findSourceEntityByNo(String reqNo) {
        List<SwStockIn> swStockIns=new ArrayList<SwStockIn>();
        SwMaterialInfo swMaterialInfo= swMaterialInfoService.getEntityByNo(reqNo);
        if(swMaterialInfo!=null){
            SwStockIn swStockIn= new SwStockIn();
            convertToStockIn(swStockIn,swMaterialInfo);
            swStockIns.add(swStockIn);
        }else{
           List<SwPurchaseDetail> swPurchaseDetailList= swPurchaseDetailMapper.selectByPurNo(reqNo);
           if(swPurchaseDetailList!=null){
               for(SwPurchaseDetail swPurchaseDetail:swPurchaseDetailList){
                   SwStockIn swStockIn= new SwStockIn();
                   convertToStockIn1(swStockIn,swPurchaseDetail);
                   swStockIns.add(swStockIn);
               }
           }
        }
        return  swStockIns;
    }

    private void convertToStockIn1(SwStockIn swStockIn,SwPurchaseDetail swPurchaseDetail) {
        String stockInNo= UUIDUtils.genUUID(ConstantKey.STOCK_IN_KEY);
        swStockIn.setStkInNo(stockInNo);
        swStockIn.setOrderNo(swPurchaseDetail.getOrderNo());
        swStockIn.setOrderSeqNo(swPurchaseDetail.getOrderSeqNo());
        swStockIn.setSourceType(ConstantKey.PURCHASE_KEY_PRE);
        swStockIn.setSourceNo(swPurchaseDetail.getPurNo());
        swStockIn.setSourceSeqNo(swPurchaseDetail.getPurSeqNo());
        swStockIn.setMaterialNo(swPurchaseDetail.getMaterialNo());
        swStockIn.setMaterialName(swPurchaseDetail.getMaterialName());
        swStockIn.setMaterialType(swPurchaseDetail.getMaterialType());
        swStockIn.setPattern(swPurchaseDetail.getPattern());
        swStockIn.setSpec(swPurchaseDetail.getSpec());
        swStockIn.setUnit(swPurchaseDetail.getUnit());
        swStockIn.setNum(swPurchaseDetail.getNum());
        swStockIn.setStatus(StockStatus.WAIT_VERIFY.getCode());
        swStockIn.setCreateNo(ShiroUtils.getCurrentUserNo());
        swStockIn.setCreateTime(new Date());
        swStockIn.setModiNo(ShiroUtils.getCurrentUserNo());
        swStockIn.setModiTime(new Date());
        SwMaterialInfo swMaterialInfo= swMaterialInfoService.getEntityByNo(swPurchaseDetail.getMaterialNo());
        swStockIn.setMaterialStock(swMaterialInfo.getMaterialStock());
    }

    private void convertToStockIn(SwStockIn swStockIn,SwMaterialInfo swMaterialInfo) {
        String stockInNo= UUIDUtils.genUUID(ConstantKey.STOCK_IN_KEY);
        swStockIn.setStkInNo(stockInNo);
        swStockIn.setMaterialNo(swMaterialInfo.getMaterialNo());
        swStockIn.setMaterialName(swMaterialInfo.getMaterialName());
        swStockIn.setMaterialType(swMaterialInfo.getMaterialType());
        swStockIn.setPattern(swMaterialInfo.getPattern());
        swStockIn.setSpec(swMaterialInfo.getSpec());
        swStockIn.setUnit(swMaterialInfo.getUnit());
        swStockIn.setMaterialStock(swMaterialInfo.getMaterialStock());
        swStockIn.setNum(BigDecimal.ZERO);
        swStockIn.setStatus(StockStatus.WAIT_VERIFY.getCode());
        swStockIn.setCreateNo(ShiroUtils.getCurrentUserNo());
        swStockIn.setCreateTime(new Date());
        swStockIn.setModiNo(ShiroUtils.getCurrentUserNo());
        swStockIn.setModiTime(new Date());
    }
}
