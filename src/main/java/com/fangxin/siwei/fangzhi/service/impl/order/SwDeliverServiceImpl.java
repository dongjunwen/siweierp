package com.fangxin.siwei.fangzhi.service.impl.order;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.enums.DeliverStatus;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.DateUtil;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.mapper.SwDeliverBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwDeliverDetailMapper;
import com.fangxin.siwei.fangzhi.modal.*;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.audit.AuditingParam;
import com.fangxin.siwei.fangzhi.service.audit.IAuditingService;
import com.fangxin.siwei.fangzhi.service.order.SwDeliverService;
import com.fangxin.siwei.fangzhi.vo.order.*;
import com.fangxin.siwei.fangzhi.vo.result.*;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/26 0026 14:19
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SwDeliverServiceImpl extends AbstractService<SwDeliverBase> implements SwDeliverService {
    private static  final Logger logger= LoggerFactory.getLogger(SwDeliverServiceImpl.class);

    @Autowired
    private SwDeliverBaseMapper swDeliverBaseMapper;
    @Autowired
    private SwDeliverDetailMapper swDeliverDetailMapper;
    @Autowired
    IAuditingService auditingService;

    @Transactional
    @Override
    public Result<Integer> create(SwDeliverVo swDeliverVo) {
        SwDeliverBaseVo swDeliverBaseVo= swDeliverVo.getSwDeliverBaseVo();
        SwDeliverBase swDeliverBase=new SwDeliverBase();
        convertVoToEntity(swDeliverBase,swDeliverBaseVo);
        String deliverNo= UUIDUtils.genUUID("F");
        swDeliverBase.setDeilverNo(deliverNo);
        swDeliverBase.setDeilverDate(new Date());
        swDeliverBase.setDeilverStatus(DeliverStatus.WAIT_APPLY.getCode());
        swDeliverBase.setCreateNo(ShiroUtils.getCurrentUserNo());
        swDeliverBase.setCreateTime(new Date());
        swDeliverBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swDeliverBase.setModiTime(new Date());
        List<SwDeliverDetailVo> swDeliverDetailVoList=swDeliverVo.getSwDeliverDetailVoList();
        List swDeliverDetails=new ArrayList();
        for(SwDeliverDetailVo swDeliverDetailVo:swDeliverDetailVoList){
            SwDeliverDetail swDeliverDetail=new SwDeliverDetail();
            convertVoToEntityDetail(swDeliverDetail,swDeliverDetailVo);
            swDeliverDetail.setDeilverNo(deliverNo);
            swDeliverDetail.setCreateNo(ShiroUtils.getCurrentUserNo());
            swDeliverDetail.setCreateTime(new Date());
            swDeliverDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            swDeliverDetail.setModiTime(new Date());
            swDeliverDetails.add(swDeliverDetail);
        }
        int flag=swDeliverBaseMapper.insert(swDeliverBase);
        swDeliverDetailMapper.insertBatch(swDeliverDetails);
        return Result.newSuccess(flag);
    }



    private void convertVoToEntityDetail(SwDeliverDetail swDeliverDetail, SwDeliverDetailVo swDeliverDetailVo) {
        try {
            BeanUtils.copyProperties(swDeliverDetail,swDeliverDetailVo);
        } catch (IllegalAccessException e) {
            logger.error("转换发货单明细语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换发货单明细目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }


    private void convertVoToEntity( SwDeliverBase swDeliverBase, SwDeliverBaseVo swDeliverBaseVo) {
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
            BeanUtils.copyProperties(swDeliverBase,swDeliverBaseVo);
        } catch (IllegalAccessException e) {
            logger.error("转换发货单主表语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换发货单主表目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }


    @Override
    public Page<SwDeliverBaseResutVo> findList(Map<String, String> params) {
        //日期查询条件
        params.put("timeCond1","deilver_date");
        Condition serviceCondition = Common.getServiceCondition(params, SwOrderBase.class);
        List<SwDeliverBase> swDeliverBases = findByCondition(serviceCondition);
        Page<SwDeliverBaseResutVo> swOrderBaseResultVos= new Page<SwDeliverBaseResutVo>();
        for(SwDeliverBase swDeliverBase: swDeliverBases){
            SwDeliverBaseResutVo swDeliverBaseResutVo=new SwDeliverBaseResutVo();
            convertEntityTVo(swDeliverBaseResutVo,swDeliverBase);
            swOrderBaseResultVos.add(swDeliverBaseResutVo);
        }
        return swOrderBaseResultVos;
    }

    @Override
    public Result<Integer> audit(SwDeliverAuditVo swDeliverAuditVo) {
        Result _orderAudit=Result.newSuccess();
        List<String> deliverNos=swDeliverAuditVo.getDeliverNos();
        try{
            Result<SysAuditConfig> _resultAudit=null;
            for(String deliverNo:deliverNos){
                _resultAudit=singleAudit(deliverNo,swDeliverAuditVo);
                if(!_resultAudit.isSuccess()){
                    break;
                }
            }
            _orderAudit.setError(_resultAudit.getCode(),_resultAudit.getMessage());
        }catch (Exception e){
            logger.error("[发货单审核]发生异常!e:{}",e);
            _orderAudit.setErrorCode(ResultCode.FAIL);
        }
        return _orderAudit;
    }

    @Override
    public SwDeliverResultVo getEntityByNo(String orderNo) {
        SwDeliverBase swDeliverBase=swDeliverBaseMapper.selectByDeliverNo(orderNo);
        if(swDeliverBase==null){
            throw  new RRException(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),ResultCode.COMMON_DATA_NOT_EXISTS.getMessage());
        }
        SwDeliverResultVo swDeliverResultVo=new SwDeliverResultVo();
        SwDeliverBaseResutVo swDeliverBaseResutVo=new SwDeliverBaseResutVo();
        convertEntityTVo(swDeliverBaseResutVo,swDeliverBase);
        swDeliverResultVo.setSwDeliverBaseResutVo(swDeliverBaseResutVo);
        List<SwDeliverDetail> swDeliverDetails=swDeliverDetailMapper.selectByDeliverNo(orderNo);
        List<SwDeliverDetailResutVo> swDeliverDetailResutVos=new ArrayList<>();
        for(SwDeliverDetail swDeliverDetail:swDeliverDetails){
            SwDeliverDetailResutVo swDeliverDetailResutVo=new SwDeliverDetailResutVo();
            convertDetailEntityTVo(swDeliverDetailResutVo,swDeliverDetail);
            swDeliverDetailResutVos.add(swDeliverDetailResutVo);
        }
        swDeliverResultVo.setSwDeliverDetailResutVos(swDeliverDetailResutVos);
        return swDeliverResultVo;
    }

    private void convertDetailEntityTVo(SwDeliverDetailResutVo swDeliverDetailResutVo, SwDeliverDetail swDeliverDetail) {
        try {
            BeanUtils.copyProperties(swDeliverDetailResutVo,swDeliverDetail);
            swDeliverDetailResutVo.setCreateTime(DateUtil.formatDateTime(swDeliverDetail.getCreateTime()));
            swDeliverDetailResutVo.setModiTime(DateUtil.formatDateTime(swDeliverDetail.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示发货DetailVo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示发货DetailVo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }

    }

    private   Result<SysAuditConfig> singleAudit(String deliverNo,SwDeliverAuditVo swDeliverAuditVo) {
        Result<SysAuditConfig> _result=beginAudit(deliverNo,swDeliverAuditVo);
        if(_result.isSuccess()){
            SysAuditConfig sysAuditConfig=_result.getData();
            SwDeliverBase swDeliverBase=new SwDeliverBase();
            swDeliverBase.setDeilverNo(deliverNo);
            swDeliverBase.setDeilverStatus(sysAuditConfig.getNextStage());
            swDeliverBase.setModiNo(swDeliverAuditVo.getAuditUserNo());
            swDeliverBase.setModiTime(new Date());
            SwDeliverBase _swDeliverBase= swDeliverBaseMapper.selectByDeliverNo(deliverNo);
            //使用乐观锁
            swDeliverBase.setVersion(_swDeliverBase.getVersion());
            swDeliverBaseMapper.updateByDeliverNo(swDeliverBase);
        }
        return _result;

    }

    private Result<SysAuditConfig> beginAudit(String sourceNo, SwDeliverAuditVo swDeliverAuditVo) {
        AuditingParam auditingParam=new AuditingParam();
        auditingParam.setSourceNo(sourceNo);
        auditingParam.setAuditType(AuditTypeEnum.DELIVER);
        auditingParam.setCurrentStage(swDeliverAuditVo.getDeliverStatus().getCode());
        auditingParam.setAuditAction(swDeliverAuditVo.getAuditAction().getCode());
        auditingParam.setAuditUserNo(swDeliverAuditVo.getAuditUserNo());
        auditingParam.setAuditUserName(swDeliverAuditVo.getAuditUserName());
        auditingParam.setAuditDesc(swDeliverAuditVo.getAuditDesc());
        return auditingService.auditing(auditingParam);
    }

    private void convertEntityTVo(SwDeliverBaseResutVo swDeliverBaseResutVo, SwDeliverBase swDeliverBase) {

        try {
            BeanUtils.copyProperties(swDeliverBaseResutVo,swDeliverBase);
            swDeliverBaseResutVo.setDeilverDate(DateUtil.formatDate(swDeliverBase.getDeilverDate()));
            swDeliverBaseResutVo.setCreateTime(DateUtil.formatDateTime(swDeliverBase.getCreateTime()));
            swDeliverBaseResutVo.setModiTime(DateUtil.formatDateTime(swDeliverBase.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示Vo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示Vo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}
