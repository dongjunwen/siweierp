package com.fangxin.siwei.fangzhi.service.impl.purchase;

import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.enums.PurStatus;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.enums.ReturnStatus;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.DateUtil;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.mapper.SwPurchaseBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwPurchaseDetailMapper;
import com.fangxin.siwei.fangzhi.mapper.SwReturnBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwReturnDetailMapper;
import com.fangxin.siwei.fangzhi.modal.*;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.audit.AuditingParam;
import com.fangxin.siwei.fangzhi.service.audit.IAuditingService;
import com.fangxin.siwei.fangzhi.service.purchase.SwReturnService;
import com.fangxin.siwei.fangzhi.vo.purchase.*;
import com.fangxin.siwei.fangzhi.vo.result.*;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/6 0006 17:48
 * @Author lu.dong
 * @Description：
 **/
@Service
public class ReturnServiceImpl extends AbstractService<SwReturnBase> implements SwReturnService {
    private static  final Logger logger= LoggerFactory.getLogger(ReturnServiceImpl.class);

    @Autowired
    SwReturnBaseMapper swReturnBaseMapper;
    @Autowired
    SwReturnDetailMapper swReturnDetailMapper;
    @Autowired
    IAuditingService auditingService;

    @Override
    public Result<Integer> create(SwReturnVo swReturnVo) {
        SwReturnBaseVo swReturnBaseVo= swReturnVo.getSwReturnBaseVo();
        SwReturnBase swReturnBase=new SwReturnBase();
        convertVoToEntity(swReturnBase,swReturnBaseVo);
        String returnNo= UUIDUtils.genUUID(ConstantKey.PURCHASE_KEY_PRE);
        swReturnBase.setReturnNo(returnNo);
        swReturnBase.setReturnDate(new Date());
        swReturnBase.setReturnStatus(ReturnStatus.WAIT_APPLY.getCode());
        swReturnBase.setCreateNo(ShiroUtils.getCurrentUserNo());
        swReturnBase.setCreateTime(new Date());
        swReturnBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swReturnBase.setModiTime(new Date());
        swReturnBase.setVersion(0);
        List<SwReturnDetailVo> swReturnDetailVos=swReturnVo.getSwReturnDetailVos();
        List swOrderDetails=new ArrayList();
        BigDecimal totalNum=BigDecimal.ZERO;
        BigDecimal totalAmt=BigDecimal.ZERO;
        for(SwReturnDetailVo swReturnDetailVo:swReturnDetailVos){
            SwReturnDetail swReturnDetail=new SwReturnDetail();
            convertVoToEntityDetail(swReturnDetail,swReturnDetailVo);
            swReturnDetail.setReturnNo(returnNo);
            swReturnDetail.setCreateNo(ShiroUtils.getCurrentUserNo());
            swReturnDetail.setCreateTime(new Date());
            swReturnDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            swReturnDetail.setModiTime(new Date());
            swReturnDetail.setVersion(0);
            swOrderDetails.add(swReturnDetail);
            totalNum=totalNum.add(swReturnDetail.getNum());
            totalAmt=totalAmt.add(swReturnDetail.getAmt());
        }
        swReturnBase.setReturnNum(totalNum);
        swReturnBase.setReturnAmt(totalAmt);
        int flag=swReturnBaseMapper.insert(swReturnBase);
        swReturnDetailMapper.insertBatch(swOrderDetails);
        return Result.newSuccess(flag);
    }

    private void convertVoToEntityDetail(SwReturnDetail swReturnDetail, SwReturnDetailVo swReturnDetailVo) {
        try {
            BeanUtils.copyProperties(swReturnDetail,swReturnDetailVo);
        } catch (IllegalAccessException e) {
            logger.error("转换退货单明细语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换退货单明细目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }


    private void convertVoToEntity(SwReturnBase swReturnBase, SwReturnBaseVo swReturnBaseVo) {

        try {
            BeanUtils.copyProperties(swReturnBase,swReturnBaseVo);

        } catch (IllegalAccessException e) {
            logger.error("转换退货单主表语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换退货单主表目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    @Override
    public Page<SwReturnBaseResultVo> findList(Map<String, String> params) {
        //日期查询条件
        params.put("timeCond1","return_date");
        Condition serviceCondition = Common.getServiceCondition(params, SwReturnBase.class);
        List<SwReturnBase> swReturnBases = findByCondition(serviceCondition);
        Page<SwReturnBaseResultVo> swReturnBaseResultVos= new Page<SwReturnBaseResultVo>();
        for(SwReturnBase swReturnBase: swReturnBases){
            SwReturnBaseResultVo swReturnBaseResultVo=new SwReturnBaseResultVo();
            convertEntityTVo(swReturnBaseResultVo,swReturnBase);
            swReturnBaseResultVos.add(swReturnBaseResultVo);
        }
        return swReturnBaseResultVos;
    }

    private void convertEntityTVo(SwReturnBaseResultVo swReturnBaseResultVo, SwReturnBase swReturnBase) {

        try {
            BeanUtils.copyProperties(swReturnBaseResultVo,swReturnBase);
            swReturnBaseResultVo.setReturnDate(DateUtil.formatDate(swReturnBase.getReturnDate()));
            //swReturnBaseResultVo.setExpectDate(DateUtil.formatDate(swPurchaseBase.getExpectDate()));
            swReturnBaseResultVo.setCreateTime(DateUtil.formatDateTime(swReturnBase.getCreateTime()));
            swReturnBaseResultVo.setModiTime(DateUtil.formatDateTime(swReturnBase.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示Vo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示Vo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    @Override
    public Result<Integer> audit(SwReturnAuditVo swReturnAuditVo) {
        Result _orderAudit=Result.newSuccess();
        List<String> orderNos=swReturnAuditVo.getOrderNos();
        try{
            Result<SysAuditConfig> _resultAudit=null;
            for(String orderNo:orderNos){
                _resultAudit=singleAudit(orderNo,swReturnAuditVo);
                if(!_resultAudit.isSuccess()){
                    break;
                }
            }
            _orderAudit.setError(_resultAudit.getCode(),_resultAudit.getMessage());
        }catch (Exception e){
            logger.error("[退货单审核]发生异常!e:{}",e);
            _orderAudit.setErrorCode(ResultCode.FAIL);
        }
        return _orderAudit;
    }

    private Result<SysAuditConfig> singleAudit(String orderNo, SwReturnAuditVo swReturnAuditVo) {
        Result<SysAuditConfig> _result=beginAudit(orderNo,swReturnAuditVo);
        if(_result.isSuccess()){
            SysAuditConfig sysAuditConfig=_result.getData();
            SwReturnBase swReturnBase=new SwReturnBase();
            swReturnBase.setReturnNo(orderNo);
            swReturnBase.setReturnStatus(sysAuditConfig.getNextStage());
            swReturnBase.setModiNo(swReturnAuditVo.getAuditUserNo());
            swReturnBase.setModiTime(new Date());
            swReturnBaseMapper.updateByReturnNo(swReturnBase);
        }
        return _result;
    }

    private Result<SysAuditConfig> beginAudit(String sourceNo, SwReturnAuditVo swReturnAuditVo) {
        AuditingParam auditingParam=new AuditingParam();
        auditingParam.setSourceNo(sourceNo);
        auditingParam.setAuditType(AuditTypeEnum.RETURN);
        auditingParam.setCurrentStage(swReturnAuditVo.getReturnStatus().getCode());
        auditingParam.setAuditAction(swReturnAuditVo.getAuditAction().getCode());
        auditingParam.setAuditUserNo(swReturnAuditVo.getAuditUserNo());
        auditingParam.setAuditUserName(swReturnAuditVo.getAuditUserName());
        auditingParam.setAuditDesc(swReturnAuditVo.getAuditDesc());
        return auditingService.auditing(auditingParam);
    }

    @Override
    public SwReturnResultVo getEntityByNo(String orderNo) {
        SwReturnBase swReturnBase=swReturnBaseMapper.selectByReturnNo(orderNo);
        if(swReturnBase==null){
            throw  new RRException(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),ResultCode.COMMON_DATA_NOT_EXISTS.getMessage());
        }
        SwReturnResultVo swReturnResultVo=new SwReturnResultVo();
        SwReturnBaseResultVo swReturnBaseResultVo=new SwReturnBaseResultVo();
        convertEntityTVo(swReturnBaseResultVo,swReturnBase);
        swReturnResultVo.setSwReturnBaseResultVo(swReturnBaseResultVo);
        List<SwReturnDetail> swReturnDetails=swReturnDetailMapper.selectByReturnNo(orderNo);
        List<SwReturnDetailResultVo> swReturnDetailResultVos=new ArrayList<>();
        for(SwReturnDetail swReturnDetail:swReturnDetails){
            SwReturnDetailResultVo swReturnDetailResultVo=new SwReturnDetailResultVo();
            convertDetailEntityTVo(swReturnDetailResultVo,swReturnDetail);
            swReturnDetailResultVos.add(swReturnDetailResultVo);
        }
        swReturnResultVo.setSwReturnDetailResultVoList(swReturnDetailResultVos);
        return swReturnResultVo;
    }

    private void convertDetailEntityTVo( SwReturnDetailResultVo swReturnDetailResultVo, SwReturnDetail swReturnDetail) {
        try {
            BeanUtils.copyProperties(swReturnDetailResultVo,swReturnDetail);
            swReturnDetailResultVo.setCreateTime(DateUtil.formatDateTime(swReturnDetail.getCreateTime()));
            swReturnDetailResultVo.setModiTime(DateUtil.formatDateTime(swReturnDetail.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示DetailVo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示DetailVo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }


    @Override
    public Result<Integer> update(SwReturnModiVo swReturnModiVo) {
        SwReturnBaseModiVo swReturnBaseModiVo= swReturnModiVo.getSwReturnBaseModiVo();
        SwReturnBase swReturnBase=new SwReturnBase();
        convertVoToEntity(swReturnBase,swReturnBaseModiVo);
        String returnNo=swReturnBaseModiVo.getReturnNo();
        swReturnBase.setReturnNo(returnNo);
        swReturnBase.setReturnStatus(ReturnStatus.WAIT_APPLY.getCode());
        swReturnBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swReturnBase.setModiTime(new Date());
        List<SwReturnDetailVo> swReturnDetailVos=swReturnModiVo.getSwReturnDetailVos();
        List swOrderDetails=new ArrayList();
        BigDecimal totalNum=BigDecimal.ZERO;
        BigDecimal totalAmt=BigDecimal.ZERO;
        for(SwReturnDetailVo swReturnDetailVo:swReturnDetailVos){
            SwReturnDetail swReturnDetail=new SwReturnDetail();
            convertVoToEntityDetail(swReturnDetail,swReturnDetailVo);
            swReturnDetail.setReturnNo(returnNo);
            swReturnDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            swReturnDetail.setModiTime(new Date());
            swOrderDetails.add(swReturnDetail);
            totalNum=totalNum.add(swReturnDetail.getNum());
            totalAmt=totalAmt.add(swReturnDetail.getAmt());
        }
        swReturnBase.setReturnNum(totalNum);
        swReturnBase.setReturnAmt(totalAmt);
        int flag=swReturnBaseMapper.updateByReturnNo(swReturnBase);
        swReturnDetailMapper.updateBatch(swOrderDetails);
        return Result.newSuccess(flag);
    }


}
