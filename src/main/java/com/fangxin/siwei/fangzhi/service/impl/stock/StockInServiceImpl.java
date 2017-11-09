package com.fangxin.siwei.fangzhi.service.impl.stock;

import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.enums.StockStatus;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.DateUtil;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.mapper.SwPurchaseDetailMapper;
import com.fangxin.siwei.fangzhi.mapper.SwStockInMapper;
import com.fangxin.siwei.fangzhi.modal.*;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.base.SwMaterialInfoService;
import com.fangxin.siwei.fangzhi.service.stock.StockInService;
import com.fangxin.siwei.fangzhi.service.stock.StockInfoService;
import com.fangxin.siwei.fangzhi.vo.result.StockInResultVo;
import com.fangxin.siwei.fangzhi.vo.stock.StockInVo;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/7 0007 15:56
 * @Author lu.dong
 * @Description：
 **/
@Service
public class StockInServiceImpl extends AbstractService<SwStockIn> implements StockInService {
    private static  final Logger logger= LoggerFactory.getLogger(StockInServiceImpl.class);
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
    public Result< List<StockInResultVo>> create(String reqNo) {
        List<SwStockIn>  swStockIns=findSourceEntityByNo(reqNo);
        if(swStockIns==null || swStockIns.size()==0){
            return Result.newError(ResultCode.SOURCE_NO_NOT_EXITS);
        }
        swStockInMapper.insertBatch(swStockIns);
        //stockInfoService.saveStock(swStockIns);
        List<StockInResultVo> swStockInResultVos=new ArrayList();
        for(SwStockIn swStockIn:swStockIns){
            StockInResultVo stockInResultVo=new StockInResultVo();
            convertToResult(stockInResultVo,swStockIn);
            swStockInResultVos.add(stockInResultVo);
        }
        return Result.newSuccess(swStockInResultVos);
    }

    @Override
    @Transactional
    public Result<Integer> update(StockInVo stockInVo) {
        String stockInNo=stockInVo.getStkInNo();
        SwStockIn oldSwStockIn=swStockInMapper.selectByStockInNo(stockInNo);
        if(oldSwStockIn==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"入库单"+stockInNo+"不存在!");
        }
        SwStockIn swStockIn =new SwStockIn();
        convertToEntity(swStockIn,stockInVo);
        swStockIn.setModiTime(new Date());
        swStockIn.setVersion(oldSwStockIn.getVersion());
        swStockIn.setMaterialNo(oldSwStockIn.getMaterialNo());
        int modiNum=swStockInMapper.updateByNo(swStockIn);
       // swStockIn.setNum(swStockIn.getNum().subtract(oldSwStockIn.getNum()));
        //stockInfoService.updateByNo(swStockIn);
        return   Result.newSuccess(modiNum);
    }

    @Override
    public Page<StockInResultVo> findList(Map<String, String> params) {
        //日期查询条件
        params.put("timeCond1","create_time");
        Condition serviceCondition = Common.getServiceCondition(params, SwOrderBase.class);
        List<SwStockIn> swStockIns = findByCondition(serviceCondition);
        Page<StockInResultVo> stockInResultVos= new Page<StockInResultVo>();
        for(SwStockIn swStockIn: swStockIns){
            StockInResultVo swStockInResultVo=new StockInResultVo();
            convertToResult(swStockInResultVo,swStockIn);
            swStockInResultVo.setCreateTime(DateUtil.formatDateTime(swStockIn.getCreateTime()));
            swStockInResultVo.setModiTime(DateUtil.formatDateTime(swStockIn.getModiTime()));
            stockInResultVos.add(swStockInResultVo);
        }
        return stockInResultVos;
    }

    private void convertToEntity(SwStockIn swStockIn, StockInVo stockInVo) {
        try{
            BeanUtils.copyProperties(swStockIn,stockInVo);
        }catch (IllegalAccessException e) {
            logger.error("转换修改入库记录语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换修改入库记录语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    private void convertToResult(StockInResultVo stockInResultVo, SwStockIn swStockIn) {
        try{
            BeanUtils.copyProperties(stockInResultVo,swStockIn);
        }catch (IllegalAccessException e) {
            logger.error("转换入库记录语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换入库记录语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
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
        swStockIn.setVersion(0);
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
        swStockIn.setVersion(0);
    }
}
