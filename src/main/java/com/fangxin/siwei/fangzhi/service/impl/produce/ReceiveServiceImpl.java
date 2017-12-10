package com.fangxin.siwei.fangzhi.service.impl.produce;

import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.enums.ReceiveStatus;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.DateUtil;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.mapper.SwReceiveBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwReceiveDetailMapper;
import com.fangxin.siwei.fangzhi.modal.*;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.audit.AuditingParam;
import com.fangxin.siwei.fangzhi.service.audit.IAuditingService;
import com.fangxin.siwei.fangzhi.service.produce.SwReceiveService;
import com.fangxin.siwei.fangzhi.vo.produce.*;
import com.fangxin.siwei.fangzhi.vo.result.*;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Date:2017/11/7 0007 14:18
 * @Author lu.dong
 * @Description：
 **/
@Service
public class ReceiveServiceImpl extends AbstractService<SwReceiveBase> implements SwReceiveService {
    private static  final Logger logger= LoggerFactory.getLogger(ReceiveServiceImpl.class);

    @Autowired
    SwReceiveBaseMapper swReceiveBaseMapper;
    @Autowired
    SwReceiveDetailMapper swReceiveDetailMapper;
    @Autowired
    IAuditingService auditingService;


    @Override
    public Result<Integer> create(SwReceiveVo swReceiveVo) {
        SwReceiveBaseVo swReceiveBaseVo= swReceiveVo.getSwReceiveBaseVo();
        SwReceiveBase swReceiveBase=new SwReceiveBase();
        convertVoToEntity(swReceiveBase,swReceiveBaseVo);
        String purNo= UUIDUtils.genUUID(ConstantKey.RECEIVE_KEY_PRE);
        swReceiveBase.setRecvNo(purNo);
        swReceiveBase.setRecvDate(new Date());
        swReceiveBase.setRecvStatus(ReceiveStatus.WAIT_APPLY.getCode());
        swReceiveBase.setCreateNo(ShiroUtils.getCurrentUserNo());
        swReceiveBase.setCreateTime(new Date());
        swReceiveBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swReceiveBase.setModiTime(new Date());
        swReceiveBase.setVersion(0);
        List<SwReceiveDetailVo> swReceiveDetailVoList=swReceiveVo.getSwReceiveDetailVoList();
        List swReceiveDetails=new ArrayList();
        BigDecimal totalNum=BigDecimal.ZERO;
        int i=1;
        for(SwReceiveDetailVo swPurOrderDetailVo:swReceiveDetailVoList){
            SwReceiveDetail swReceiveDetail=new SwReceiveDetail();
            convertVoToEntityDetail(swReceiveDetail,swPurOrderDetailVo);
            swReceiveDetail.setRecvNo(purNo);
            swReceiveDetail.setRecvSeqNo(String.valueOf(i));
            swReceiveDetail.setCreateNo(ShiroUtils.getCurrentUserNo());
            swReceiveDetail.setCreateTime(new Date());
            swReceiveDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            swReceiveDetail.setModiTime(new Date());
            swReceiveDetail.setVersion(0);
            swReceiveDetails.add(swReceiveDetail);
            totalNum=totalNum.add(swReceiveDetail.getNum());
            i++;
        }
        swReceiveBase.setNum(totalNum);
        int flag=swReceiveBaseMapper.insert(swReceiveBase);
        swReceiveDetailMapper.insertBatch(swReceiveDetails);
        return Result.newSuccess(flag);
    }

    private void convertVoToEntityDetail(SwReceiveDetail swReceiveDetail, SwReceiveDetailVo swReceiveDetailVo) {
        try {
            BeanUtils.copyProperties(swReceiveDetail,swReceiveDetailVo);
        } catch (IllegalAccessException e) {
            logger.error("转换领料单明细语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换领料单明细目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }


    private void convertVoToEntity(SwReceiveBase swReceiveBase, SwReceiveBaseVo swReceiveBaseVo) {
        ConvertUtils.register(new Converter() {
            public Object convert(Class type, Object value) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return simpleDateFormat.parse(value.toString());
                } catch (ParseException e) {
                    logger.error("日期格式化异常:{}",e);
                }
                return null;
            }
        }, Date.class);
        try {
            BeanUtils.copyProperties(swReceiveBase,swReceiveBaseVo);
        } catch (IllegalAccessException e) {
            logger.error("转换领料单主表语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换领料单主表目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    @Override
    public Page<SwReceiveBaseResultVo> findList(Map<String, String> params) {
        //日期查询条件
        params.put("timeCond1","receive_date");
        Condition serviceCondition = Common.getServiceCondition(params, SwReceiveBase.class);
        Page<SwReceiveBase> swReceiveBases = (Page)findByCondition(serviceCondition);
        Page<SwReceiveBaseResultVo> swOrderBaseResultVos= new Page<SwReceiveBaseResultVo>();
        swOrderBaseResultVos.setPageSize(swReceiveBases.getPageSize());
        swOrderBaseResultVos.setPageNum(swReceiveBases.getPageNum());
        swOrderBaseResultVos.setPages(swReceiveBases.getPages());
        swOrderBaseResultVos.setTotal(swReceiveBases.getTotal());
        for(SwReceiveBase swReceiveBase: swReceiveBases){
            SwReceiveBaseResultVo swReceiveBaseResultVo=new SwReceiveBaseResultVo();
            convertEntityTVo(swReceiveBaseResultVo,swReceiveBase);
            swOrderBaseResultVos.add(swReceiveBaseResultVo);
        }
        return swOrderBaseResultVos;
    }



    private void convertEntityTVo(SwReceiveBaseResultVo swReceiveBaseResultVo, SwReceiveBase swReceiveBase) {

        try {
            BeanUtils.copyProperties(swReceiveBaseResultVo,swReceiveBase);
            swReceiveBaseResultVo.setRecvDate(DateUtil.formatDate(swReceiveBase.getRecvDate()));
            swReceiveBaseResultVo.setCreateTime(DateUtil.formatDateTime(swReceiveBase.getCreateTime()));
            swReceiveBaseResultVo.setModiTime(DateUtil.formatDateTime(swReceiveBase.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示Vo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示Vo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    @Override
    public Result<Integer> audit(SwReceiveAuditVo swReceiveAuditVo) {
        Result _orderAudit=Result.newSuccess();
        List<String> orderNos=swReceiveAuditVo.getOrderNos();
        try{
            Result<SysAuditConfig> _resultAudit=null;
            for(String orderNo:orderNos){
                _resultAudit=singleAudit(orderNo,swReceiveAuditVo);
                if(!_resultAudit.isSuccess()){
                    break;
                }
            }
            _orderAudit.setError(_resultAudit.getCode(),_resultAudit.getMessage());
        }catch (Exception e){
            logger.error("[领料单审核]发生异常!e:{}",e);
            _orderAudit.setErrorCode(ResultCode.FAIL);
        }
        return _orderAudit;
    }

    private Result<SysAuditConfig> singleAudit(String orderNo, SwReceiveAuditVo swReceiveAuditVo) {
        Result<SysAuditConfig> _result=beginAudit(orderNo,swReceiveAuditVo);
        if(_result.isSuccess()){
            SysAuditConfig sysAuditConfig=_result.getData();
            SwReceiveBase swReceiveBase=new SwReceiveBase();
            swReceiveBase.setRecvNo(orderNo);
            swReceiveBase.setRecvStatus(sysAuditConfig.getNextStage());
            swReceiveBase.setModiNo(swReceiveAuditVo.getAuditUserNo());
            swReceiveBase.setModiTime(new Date());
            swReceiveBaseMapper.updateByReceiveNo(swReceiveBase);
        }
        return _result;
    }

    private Result<SysAuditConfig> beginAudit(String sourceNo, SwReceiveAuditVo swReceiveAuditVo) {
        AuditingParam auditingParam=new AuditingParam();
        auditingParam.setSourceNo(sourceNo);
        auditingParam.setAuditType(AuditTypeEnum.PURCHASE);
        auditingParam.setCurrentStage(swReceiveAuditVo.getReceiveStatus().getCode());
        auditingParam.setAuditAction(swReceiveAuditVo.getAuditAction().getCode());
        auditingParam.setAuditUserNo(swReceiveAuditVo.getAuditUserNo());
        auditingParam.setAuditUserName(swReceiveAuditVo.getAuditUserName());
        auditingParam.setAuditDesc(swReceiveAuditVo.getAuditDesc());
        return auditingService.auditing(auditingParam);
    }

    @Override
    public SwReceiveResultVo getEntityByNo(String orderNo) {
        SwReceiveBase swReceiveBase=swReceiveBaseMapper.selectByReceiveNo(orderNo);
        if(swReceiveBase==null){
            throw  new RRException(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),ResultCode.COMMON_DATA_NOT_EXISTS.getMessage());
        }
        SwReceiveResultVo swReceiveResultVo=new SwReceiveResultVo();
        SwReceiveBaseResultVo swReceiveBaseResultVo=new SwReceiveBaseResultVo();
        convertEntityTVo(swReceiveBaseResultVo,swReceiveBase);
        swReceiveResultVo.setSwReceiveBaseResultVo(swReceiveBaseResultVo);
        List<SwReceiveDetail> swPurchaseDetails=swReceiveDetailMapper.selectByReceiveNo(orderNo);
        List<SwReceiveDetailResultVo> swReceiveDetailResultVos=new ArrayList<>();
        for(SwReceiveDetail swReceiveDetail:swPurchaseDetails){
            SwReceiveDetailResultVo swReceiveDetailResultVo=new SwReceiveDetailResultVo();
            convertDetailEntityTVo(swReceiveDetailResultVo,swReceiveDetail);
            swReceiveDetailResultVos.add(swReceiveDetailResultVo);
        }
        swReceiveResultVo.setSwReceiveDetailResultVoList(swReceiveDetailResultVos);
        return swReceiveResultVo;
    }

    @Override
    public Result<Integer> update(SwReceiveModiVo swReceiveModiVo) {
        SwReceiveBaseModiVo swReceiveBaseModiVo= swReceiveModiVo.getSwReceiveBaseModiVo();
        SwReceiveBase swReceiveBase=new SwReceiveBase();
        convertVoToEntity(swReceiveBase,swReceiveBaseModiVo);
        String recvNo= swReceiveBaseModiVo.getReceiveNo();
        swReceiveBase.setRecvNo(recvNo);
        swReceiveBase.setRecvDate(new Date());
        swReceiveBase.setRecvStatus(ReceiveStatus.WAIT_APPLY.getCode());
        swReceiveBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swReceiveBase.setModiTime(new Date());
        List<SwReceiveDetailVo> swReceiveDetailVoList=swReceiveModiVo.getSwReceiveDetailVoList();
        List swReceiveDetails=new ArrayList();
        BigDecimal totalNum=BigDecimal.ZERO;
        int i=1;
        for(SwReceiveDetailVo swPurOrderDetailVo:swReceiveDetailVoList){
            SwReceiveDetail swReceiveDetail=new SwReceiveDetail();
            convertVoToEntityDetail(swReceiveDetail,swPurOrderDetailVo);
            swReceiveDetail.setRecvNo(recvNo);
            swReceiveDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            swReceiveDetail.setModiTime(new Date());
            totalNum=totalNum.add(swReceiveDetail.getNum());
            swReceiveDetail.setRecvSeqNo(String.valueOf(i));
            swReceiveDetails.add(swReceiveDetail);
            i++;
        }
        swReceiveBase.setNum(totalNum);
        int flag=swReceiveBaseMapper.updateByReceiveNo(swReceiveBase);
        swReceiveDetailMapper.deleteByRecvNo(recvNo);
        swReceiveDetailMapper.insertBatch(swReceiveDetails);
        return Result.newSuccess(flag);
    }

    private void convertDetailEntityTVo(SwReceiveDetailResultVo swReceiveDetailResultVo, SwReceiveDetail swReceiveDetail) {
        try {
            BeanUtils.copyProperties(swReceiveDetailResultVo,swReceiveDetail);
            swReceiveDetailResultVo.setCreateTime(DateUtil.formatDateTime(swReceiveDetail.getCreateTime()));
            swReceiveDetailResultVo.setModiTime(DateUtil.formatDateTime(swReceiveDetail.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示DetailVo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示DetailVo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}
