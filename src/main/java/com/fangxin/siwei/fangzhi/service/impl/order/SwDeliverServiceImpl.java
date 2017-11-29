package com.fangxin.siwei.fangzhi.service.impl.order;

import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
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
import com.fangxin.siwei.fangzhi.service.impl.system.SysDictUtils;
import com.fangxin.siwei.fangzhi.service.order.SwDeliverService;
import com.fangxin.siwei.fangzhi.service.system.SysUserService;
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
    @Autowired
    SysUserService sysUserService;


    @Transactional
    @Override
    public Result<Integer> create(SwDeliverVo swDeliverVo) {
        SwDeliverBaseVo swDeliverBaseVo= swDeliverVo.getSwDeliverBaseVo();
        SwDeliverBase swDeliverBase=new SwDeliverBase();
        convertVoToEntity(swDeliverBase,swDeliverBaseVo);
        String deliverNo= UUIDUtils.genUUID(ConstantKey.DELIVER_KEY_PRE);
        swDeliverBase.setDeliverNo(deliverNo);
        swDeliverBase.setDeliverDate(new Date());
        swDeliverBase.setDeliverStatus(DeliverStatus.WAIT_APPLY.getCode());
        swDeliverBase.setCreateNo(ShiroUtils.getCurrentUserNo());
        swDeliverBase.setCreateTime(new Date());
        swDeliverBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swDeliverBase.setModiTime(new Date());
        swDeliverBase.setVersion(0);
        List<SwDeliverDetailVo> swDeliverDetailVoList=swDeliverVo.getSwDeliverDetailVoList();
        List swDeliverDetails=new ArrayList();
        for(SwDeliverDetailVo swDeliverDetailVo:swDeliverDetailVoList){
            SwDeliverDetail swDeliverDetail=new SwDeliverDetail();
            convertVoToEntityDetail(swDeliverDetail,swDeliverDetailVo);
            swDeliverDetail.setDeliverNo(deliverNo);
            swDeliverDetail.setCreateNo(ShiroUtils.getCurrentUserNo());
            swDeliverDetail.setCreateTime(new Date());
            swDeliverDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            swDeliverDetail.setModiTime(new Date());
            swDeliverDetail.setVersion(0);
            swDeliverDetails.add(swDeliverDetail);
        }
        int flag=swDeliverBaseMapper.insertSelective(swDeliverBase);
        swDeliverDetailMapper.insertBatch(swDeliverDetails);
        return Result.newSuccess(flag);
    }

    @Override
    public Result<Integer> update(SwDeliverModiVo swDeliverModiVo) {
        SwDeliverBaseModiVo swDeliverBaseModiVo= swDeliverModiVo.getSwDeliverBaseModiVo();
        SwDeliverBase swDeliverBase=new SwDeliverBase();
        convertVoToEntity(swDeliverBase,swDeliverBaseModiVo);
        String deliverNo= swDeliverBaseModiVo.getDeliverNo();
        swDeliverBase.setDeliverNo(deliverNo);
        swDeliverBase.setDeliverStatus(DeliverStatus.WAIT_APPLY.getCode());
        swDeliverBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swDeliverBase.setModiTime(new Date());
        List<SwDeliverDetailVo> swDeliverDetailVoList=swDeliverModiVo.getSwDeliverDetailVoList();
        List swDeliverDetails=new ArrayList();
        for(SwDeliverDetailVo swDeliverDetailVo:swDeliverDetailVoList){
            SwDeliverDetail swDeliverDetail=new SwDeliverDetail();
            convertVoToEntityDetail(swDeliverDetail,swDeliverDetailVo);
            swDeliverDetail.setDeliverNo(deliverNo);
            swDeliverDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            swDeliverDetail.setModiTime(new Date());
            swDeliverDetails.add(swDeliverDetail);
        }
        int flag=swDeliverBaseMapper.updateByDeliverNo(swDeliverBase);
        swDeliverDetailMapper.updateBatch(swDeliverDetails);
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
        params.put("timeCond1","deliver_date");
        Condition serviceCondition = Common.getServiceCondition(params, SwDeliverBase.class);
        Page<SwDeliverBase> swDeliverBases = (Page)findByCondition(serviceCondition);
        Page<SwDeliverBaseResutVo> swOrderBaseResultVos= new Page<SwDeliverBaseResutVo>();
        swOrderBaseResultVos.setPageSize(swDeliverBases.getPageSize());
        swOrderBaseResultVos.setPageNum(swDeliverBases.getPageNum());
        swOrderBaseResultVos.setPages(swDeliverBases.getPages());
        swOrderBaseResultVos.setTotal(swDeliverBases.getTotal());
        for(SwDeliverBase swDeliverBase: swDeliverBases){
            SwDeliverBaseResutVo swDeliverBaseResutVo=new SwDeliverBaseResutVo();
            convertEntityTVo(swDeliverBaseResutVo,swDeliverBase);
            swDeliverBaseResutVo.setDeliverWayName(SysDictUtils.getNameByUniq("DELIVER_WAY",swDeliverBaseResutVo.getDeliverWay()));
            swDeliverBaseResutVo.setDeliverStatusName(SysDictUtils.getNameByUniq("DELIVER_STATUS",swDeliverBaseResutVo.getDeliverStatus()));
            SysAuditLog sysAuditLog=auditingService.queryLastOperateSysAuditLogBySourceNo(swDeliverBaseResutVo.getDeliverNo());
            if(sysAuditLog!=null){
                swDeliverBaseResutVo.setAuditName(sysAuditLog.getAuditUserName());
                swDeliverBaseResutVo.setAuditDes(sysAuditLog.getAuditDesc());
            }
            swDeliverBaseResutVo.setCreateName(sysUserService.getUserNameById(swDeliverBaseResutVo.getCreateNo()));
            swDeliverBaseResutVo.setModiName(sysUserService.getUserNameById(swDeliverBaseResutVo.getModiNo()));
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
        swDeliverBaseResutVo.setDeliverWayName(SysDictUtils.getNameByUniq("DELIVER_WAY",swDeliverBaseResutVo.getDeliverWay()));
        swDeliverBaseResutVo.setDeliverStatusName(SysDictUtils.getNameByUniq("DELIVER_STATUS",swDeliverBaseResutVo.getDeliverStatus()));
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
            swDeliverBase.setDeliverNo(deliverNo);
            swDeliverBase.setDeliverStatus(sysAuditConfig.getNextStage());
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
            swDeliverBaseResutVo.setDeliverDate(DateUtil.formatDate(swDeliverBase.getDeliverDate()));
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