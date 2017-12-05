package com.fangxin.siwei.fangzhi.service.impl.stock;

import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
import com.fangxin.siwei.fangzhi.common.enums.*;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.DateUtil;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.mapper.SwPurchaseBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwPurchaseDetailMapper;
import com.fangxin.siwei.fangzhi.mapper.SwStockVerifyMapper;
import com.fangxin.siwei.fangzhi.modal.*;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.audit.AuditingParam;
import com.fangxin.siwei.fangzhi.service.audit.IAuditingService;
import com.fangxin.siwei.fangzhi.service.base.SwCompanyInfoService;
import com.fangxin.siwei.fangzhi.service.base.SwMaterialInfoService;
import com.fangxin.siwei.fangzhi.service.purchase.SwReturnService;
import com.fangxin.siwei.fangzhi.service.stock.SwStockInVerifyService;
import com.fangxin.siwei.fangzhi.service.stock.SwStockInfoService;
import com.fangxin.siwei.fangzhi.vo.purchase.SwReturnBaseVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwReturnDetailVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwReturnVo;
import com.fangxin.siwei.fangzhi.vo.result.StockVerifyResultVo;
import com.fangxin.siwei.fangzhi.vo.stock.StockVerifyVo;
import com.fangxin.siwei.fangzhi.vo.stock.StockVerifyActionVo;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Date:2017/11/7 0007 15:56
 * @Author lu.dong
 * @Description：
 **/
@Service
public class StockInVerifyServiceImpl extends AbstractService<SwStockVerify> implements SwStockInVerifyService {
    private static  final Logger logger= LoggerFactory.getLogger(StockInVerifyServiceImpl.class);
    @Resource
    SwStockVerifyMapper swStockVerifyMapper;
    @Resource
    SwStockInfoService stockInfoService;
    @Resource
    SwMaterialInfoService swMaterialInfoService;
    @Resource
    SwPurchaseBaseMapper swPurchaseBaseMapper;
    @Resource
    SwPurchaseDetailMapper swPurchaseDetailMapper;
    @Autowired
    IAuditingService auditingService;
    @Resource
    SwReturnService swReturnService;
    @Resource
    SwCompanyInfoService    swCompanyInfoService;

    /**
     * 创建入库单、新增或更新库存表
     * @param reqNo
     * @return
     */
    @Override
    @Transactional
    public Result<List<StockVerifyResultVo>> create(String reqNo) {
        List<SwStockVerify>  swStockIns=findSourceEntityByNo(reqNo);
        if(swStockIns==null || swStockIns.size()==0){
            return Result.newError(ResultCode.SOURCE_NO_NOT_EXITS);
        }
        swStockVerifyMapper.insertBatch(swStockIns);
       // stockInfoService.saveStock(swStockIns);
        List<StockVerifyResultVo> swStockInResultVos=new ArrayList();
        for(SwStockVerify swStockIn:swStockIns){
            StockVerifyResultVo stockInResultVo=new StockVerifyResultVo();
            convertToResult(stockInResultVo,swStockIn);
            swStockInResultVos.add(stockInResultVo);
        }
        return Result.newSuccess(swStockInResultVos);
    }

    @Override
    @Transactional
    public Result<Integer> update(StockVerifyVo stockVerifyVo) {
        String stockInNo=stockVerifyVo.getStkInNo();
        SwStockVerify oldSwStockVerify=swStockVerifyMapper.selectByStockInNo(stockInNo);
        if(oldSwStockVerify==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"入库单"+stockInNo+"不存在!");
        }
        BigDecimal oldNum=oldSwStockVerify.getStandNum();
        oldNum=stockVerifyVo.getNum()==null?oldNum:stockVerifyVo.getNum();
        BigDecimal newNum=stockVerifyVo.getStandNum()==null?BigDecimal.ZERO:stockVerifyVo.getStandNum();
        BigDecimal subNum=oldNum.subtract(newNum);
        if(subNum.compareTo(BigDecimal.ZERO)==-1){
            return  Result.newError(ResultCode.INNUM_BIGGER_THAN_OLDNUM);
        }
        SwStockVerify swStockVerify =new SwStockVerify();
        convertToEntity(swStockVerify,stockVerifyVo);
        swStockVerify.setModiTime(new Date());
        swStockVerify.setVersion(oldSwStockVerify.getVersion());
        swStockVerify.setMaterialNo(oldSwStockVerify.getMaterialNo());
        int modiNum=swStockVerifyMapper.updateByNo(swStockVerify);
      //  swStockVerify.setStandNum(swStockVerify.getStandNum().subtract(oldSwStockVerify.getStandNum()));
       // stockInfoService.updateByNo(swStockVerify);
        return   Result.newSuccess(modiNum);
    }

    @Override
    public Page<StockVerifyResultVo> findList(Map<String, String> params) {
        //日期查询条件
        params.put("timeCond1","create_time");
        Condition serviceCondition = Common.getServiceCondition(params, SwStockVerify.class);
        Page<SwStockVerify> swStockIns = (Page)findByCondition(serviceCondition);
        Page<StockVerifyResultVo> stockInResultVos= new Page<StockVerifyResultVo>();
        stockInResultVos.setPageSize(swStockIns.getPageSize());
        stockInResultVos.setPageNum(swStockIns.getPageNum());
        stockInResultVos.setPages(swStockIns.getPages());
        stockInResultVos.setTotal(swStockIns.getTotal());
        for(SwStockVerify swStockVerify: swStockIns){
            StockVerifyResultVo swStockInResultVo=new StockVerifyResultVo();
            convertToResult(swStockInResultVo,swStockVerify);
            swStockInResultVo.setCreateTime(DateUtil.formatDateTime(swStockVerify.getCreateTime()));
            swStockInResultVo.setModiTime(DateUtil.formatDateTime(swStockVerify.getModiTime()));
            stockInResultVos.add(swStockInResultVo);
        }
        return stockInResultVos;
    }

    @Override
    @Transactional
    public Result<Integer> check(StockVerifyActionVo stockVerifyActionVo) {
        Result result=Result.newSuccess();
        try{
            Result _resultAudit=null;
            List<String> stockNos=stockVerifyActionVo.getOrderNos();
            Map<String,List> returnMap=new HashMap<String,List>();
            for(String stockNo:stockNos){
                _resultAudit=singleAudit(stockNo,stockVerifyActionVo,returnMap);
                if(!_resultAudit.isSuccess()){
                    break;
                }
            }
            //创建退货单
            batchReturn(returnMap);
            result.setError(_resultAudit.getCode(),_resultAudit.getMessage());
        }catch (Exception e){
            logger.error("[入库校验]发生异常!e:{}",e);
            throw new RRException(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMessage());
        }
        return result;
    }

    private void batchReturn(Map<String,List> returnMap) {
        if(returnMap==null) return;
        Iterator<Map.Entry<String,List>> iterators=returnMap.entrySet().iterator();
        while(iterators.hasNext()){
            Map.Entry<String,List> mapEntity=iterators.next();
            String compNo=mapEntity.getKey();
            SwReturnVo swReturnVo=new SwReturnVo();
            SwCompanyInfo swCompanyInfo= swCompanyInfoService.getEntityByNo(compNo);
            SwReturnBaseVo swReturnBaseVo=new SwReturnBaseVo();
            swReturnBaseVo.setSupplyCompNo(swCompanyInfo.getCompNo());
            swReturnBaseVo.setSupplyCompName(swCompanyInfo.getCompName());
            swReturnBaseVo.setSupplyContactName(swCompanyInfo.getContactName());
            swReturnBaseVo.setSupplyMobile(swCompanyInfo.getMobile());
            swReturnBaseVo.setSupplyPhone(swCompanyInfo.getTelphone());
            swReturnBaseVo.setSupplyTax(swCompanyInfo.getTax());
            swReturnBaseVo.setReturnReason("校验不合格退货");
            swReturnVo.setSwReturnBaseVo(swReturnBaseVo);
            List mapList=mapEntity.getValue();
            swReturnVo.setSwReturnDetailVos(mapList);
            swReturnService.create(swReturnVo);
        }

    }


    Result singleAudit(String stockNo, StockVerifyActionVo stockVerifyActionVo, Map<String,List> returnMap) {
        Result<SysAuditConfig> _result=beginAudit(stockNo,stockVerifyActionVo);
        if(_result.isSuccess()){
            SysAuditConfig sysAuditConfig=_result.getData();
            SwStockVerify oldStockVerify=swStockVerifyMapper.selectByStockInNo(stockNo);
            SwStockVerify swStockVerify=new SwStockVerify();
            swStockVerify.setStkInNo(stockNo);
            swStockVerify.setStatus(sysAuditConfig.getNextStage());
            swStockVerify.setReason(stockVerifyActionVo.getAuditDesc());
            swStockVerify.setModiNo(stockVerifyActionVo.getAuditUserNo());
            swStockVerify.setModiTime(new Date());
            swStockVerify.setVersion(oldStockVerify.getVersion());
            swStockVerifyMapper.updateByNo(swStockVerify);
            if (AuditActionEnum.AUDIT_PASS.equals(stockVerifyActionVo.getAuditAction())){
                SwStockInfo swStockInfo=new SwStockInfo();
                swStockInfo.setMaterialNo(oldStockVerify.getMaterialNo());
                swStockInfo.setNum(oldStockVerify.getStandNum());
                stockInfoService.saveSingleStock(swStockInfo);//校验通过才修改库存
            }
            BigDecimal subNum=oldStockVerify.getNum().subtract(oldStockVerify.getStandNum());
            if(subNum.compareTo(BigDecimal.ZERO)==1 &&
                    RefuseTypeEnum.RETURN.getCode().equals(oldStockVerify.getRefuseType()
                    )){//存在不合格数量，并且需要退货
                SwReturnDetailVo swReturnDetailVo=new SwReturnDetailVo();
                swReturnDetailVo.setReturnSeqNo("1");
                swReturnDetailVo.setMaterialNo(oldStockVerify.getMaterialNo());
                swReturnDetailVo.setMaterialName(oldStockVerify.getMaterialName());
                swReturnDetailVo.setNum(subNum);
                swReturnDetailVo.setMaterialType(oldStockVerify.getMaterialType());
                swReturnDetailVo.setPattern(oldStockVerify.getPattern());
                swReturnDetailVo.setSpec(oldStockVerify.getSpec());
                swReturnDetailVo.setUnit(oldStockVerify.getUnit());
                swReturnDetailVo.setOrderNo(oldStockVerify.getOrderNo());
                swReturnDetailVo.setOrderSeqNo(oldStockVerify.getOrderSeqNo());
                swReturnDetailVo.setPurNo(oldStockVerify.getSourceNo());
                swReturnDetailVo.setPurSeqNo(oldStockVerify.getSourceSeqNo());
                swReturnDetailVo.setReturnReason(stockVerifyActionVo.getAuditDesc());
                String compNo=oldStockVerify.getSupplyCompNo();
                List<SwReturnDetailVo> returnDetailVos=new ArrayList<SwReturnDetailVo>();
                if(returnMap.containsKey(compNo)){//包含公司
                    returnDetailVos=returnMap.get(compNo);
                    int size=returnDetailVos.size()+1;
                    swReturnDetailVo.setReturnSeqNo(size+"");
                    returnDetailVos.add(swReturnDetailVo);
                    returnMap.put(compNo,returnDetailVos);
                }else{
                    returnDetailVos.add(swReturnDetailVo);
                    returnMap.put(compNo,returnDetailVos);
                }
            }
            return Result.newSuccess();
        }
        return Result.newError(_result.getCode(),_result.getMessage());
    }

    private Result<SysAuditConfig> beginAudit(String stockNo, StockVerifyActionVo stockVerifyActionVo) {
        AuditingParam auditingParam=new AuditingParam();
        auditingParam.setSourceNo(stockNo);
        auditingParam.setAuditType(AuditTypeEnum.STOCKVERIFY);
        auditingParam.setCurrentStage(stockVerifyActionVo.getStockStatus().getCode());
        auditingParam.setAuditAction(stockVerifyActionVo.getAuditAction().getCode());
        auditingParam.setAuditUserNo(stockVerifyActionVo.getAuditUserNo());
        auditingParam.setAuditUserName(stockVerifyActionVo.getAuditUserName());
        auditingParam.setAuditDesc(stockVerifyActionVo.getAuditDesc());
        return auditingService.auditing(auditingParam);
    }

    private void convertToEntity(SwStockVerify swStockVerify, StockVerifyVo stockVerifyVo) {
        try{
            BeanUtils.copyProperties(swStockVerify,stockVerifyVo);
        }catch (IllegalAccessException e) {
            logger.error("转换修改入库记录语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换修改入库记录语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    private void convertToResult(StockVerifyResultVo stockInResultVo, SwStockVerify swStockVerify) {
        try{
            BeanUtils.copyProperties(stockInResultVo,swStockVerify);
        }catch (IllegalAccessException e) {
            logger.error("转换入库记录语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换入库记录语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    private List<SwStockVerify> findSourceEntityByNo(String reqNo) {
        List<SwStockVerify> swStockIns=new ArrayList<SwStockVerify>();
        SwMaterialInfo swMaterialInfo= swMaterialInfoService.getEntityByNo(reqNo);
        if(swMaterialInfo!=null){
            SwStockVerify swStockVerify= new SwStockVerify();
            convertToStockIn(swStockVerify,swMaterialInfo);
            swStockIns.add(swStockVerify);
        }else{
           List<SwPurchaseDetail> swPurchaseDetailList= swPurchaseDetailMapper.selectByPurNo(reqNo);
           if(swPurchaseDetailList!=null){
               SwPurchaseBase swPurchaseBase=swPurchaseBaseMapper.selectByPurNo(reqNo);
               for(SwPurchaseDetail swPurchaseDetail:swPurchaseDetailList){
                   SwStockVerify swStockVerify= new SwStockVerify();
                   convertToStockIn1(swStockVerify,swPurchaseDetail);
                   swStockVerify.setSupplyCompNo(swPurchaseBase.getSupplyCompNo());
                   swStockVerify.setSupplyCompName(swPurchaseBase.getSupplyCompName());
                   swStockIns.add(swStockVerify);
               }
           }
        }
        return  swStockIns;
    }

    private void convertToStockIn1(SwStockVerify swStockVerify,SwPurchaseDetail swPurchaseDetail) {
        String stockInNo= UUIDUtils.genUUID(ConstantKey.STOCK_IN_KEY);
        swStockVerify.setStkInNo(stockInNo);
        swStockVerify.setOrderNo(swPurchaseDetail.getOrderNo());
        swStockVerify.setOrderSeqNo(swPurchaseDetail.getOrderSeqNo());
        swStockVerify.setSourceType(ConstantKey.PURCHASE_KEY_PRE);
        swStockVerify.setSourceNo(swPurchaseDetail.getPurNo());
        swStockVerify.setSourceSeqNo(swPurchaseDetail.getPurSeqNo());
        swStockVerify.setMaterialNo(swPurchaseDetail.getMaterialNo());
        swStockVerify.setMaterialName(swPurchaseDetail.getMaterialName());
        swStockVerify.setMaterialType(swPurchaseDetail.getMaterialType());
        swStockVerify.setPattern(swPurchaseDetail.getPattern());
        swStockVerify.setSpec(swPurchaseDetail.getSpec());
        swStockVerify.setUnit(swPurchaseDetail.getUnit());
        swStockVerify.setNum(swPurchaseDetail.getNum());
        swStockVerify.setStandNum(swPurchaseDetail.getNum());//默认全部合格
        swStockVerify.setStatus(StockStatus.WAIT_VERIFY.getCode());
        swStockVerify.setCreateNo(ShiroUtils.getCurrentUserNo());
        swStockVerify.setCreateTime(new Date());
        swStockVerify.setModiNo(ShiroUtils.getCurrentUserNo());
        swStockVerify.setModiTime(new Date());
        SwMaterialInfo swMaterialInfo= swMaterialInfoService.getEntityByNo(swPurchaseDetail.getMaterialNo());
        swStockVerify.setMaterialStock(swMaterialInfo.getMaterialStock());
        swStockVerify.setVersion(0);
    }

    private void convertToStockIn(SwStockVerify swStockVerify,SwMaterialInfo swMaterialInfo) {
        String stockInNo= UUIDUtils.genUUID(ConstantKey.STOCK_IN_KEY);
        swStockVerify.setStkInNo(stockInNo);
        swStockVerify.setMaterialNo(swMaterialInfo.getMaterialNo());
        swStockVerify.setMaterialName(swMaterialInfo.getMaterialName());
        swStockVerify.setMaterialType(swMaterialInfo.getMaterialType());
        swStockVerify.setPattern(swMaterialInfo.getPattern());
        swStockVerify.setSpec(swMaterialInfo.getSpec());
        swStockVerify.setUnit(swMaterialInfo.getUnit());
        swStockVerify.setMaterialStock(swMaterialInfo.getMaterialStock());
        swStockVerify.setNum(BigDecimal.ZERO);
        swStockVerify.setStandNum(BigDecimal.ZERO);
        swStockVerify.setStatus(StockStatus.WAIT_VERIFY.getCode());
        swStockVerify.setCreateNo(ShiroUtils.getCurrentUserNo());
        swStockVerify.setCreateTime(new Date());
        swStockVerify.setModiNo(ShiroUtils.getCurrentUserNo());
        swStockVerify.setModiTime(new Date());
        swStockVerify.setVersion(0);
    }
}
