package com.fangxin.siwei.fangzhi.service.impl.order;

import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.enums.OrderStatus;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.DateUtil;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.mapper.SwOrderBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwOrderDetailMapper;
import com.fangxin.siwei.fangzhi.modal.SwOrderBase;
import com.fangxin.siwei.fangzhi.modal.SwOrderDetail;
import com.fangxin.siwei.fangzhi.modal.SysAuditConfig;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.audit.AuditingParam;
import com.fangxin.siwei.fangzhi.service.audit.IAuditingService;
import com.fangxin.siwei.fangzhi.service.order.SwOrderService;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderAuditVo;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderBaseVo;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderDetailVo;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderVo;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderResultVo;
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
 * @Date:2017/10/24 0024 14:49
 * @Author lu.dong
 * @Description：订单合同服务类
 **/
@Service
public class SwOrderServiceImpl extends AbstractService<SwOrderBase> implements SwOrderService {

    private static  final Logger logger= LoggerFactory.getLogger(SwOrderServiceImpl.class);

    @Autowired
    SwOrderBaseMapper swOrderBaseMapper;
    @Autowired
    SwOrderDetailMapper swOrderDetailMapper;
    @Autowired
    IAuditingService auditingService;

    @Transactional
    @Override
    public Result<Integer> create(SwOrderVo swOrderVo) {

        SwOrderBaseVo swOrderBaseVo= swOrderVo.getSwOrderBaseVo();
        SwOrderBase swOrderBase=new SwOrderBase();
        convertVoToEntity(swOrderBase,swOrderBaseVo);
        String orderNo= UUIDUtils.genUUID("D");
        swOrderBase.setOrderNo(orderNo);
        swOrderBase.setOrderDate(new Date());
        swOrderBase.setOrderStatus(OrderStatus.WAIT_AUDIT.getCode());
        swOrderBase.setCreateNo(ShiroUtils.getCurrentUserNo());
        swOrderBase.setCreateTime(new Date());
        swOrderBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swOrderBase.setModiTime(new Date());
        List<SwOrderDetailVo> swOrderDetailVoList=swOrderVo.getSwOrderDetailVos();
        List swOrderDetails=new ArrayList();
        for(SwOrderDetailVo swOrderDetailVo:swOrderDetailVoList){
            SwOrderDetail swOrderDetail=new SwOrderDetail();
            convertVoToEntityDetail(swOrderDetail,swOrderDetailVo);
            swOrderDetail.setOrderNo(orderNo);
            swOrderDetail.setCreateNo(ShiroUtils.getCurrentUserNo());
            swOrderDetail.setCreateTime(new Date());
            swOrderDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            swOrderDetail.setModiTime(new Date());
            swOrderDetails.add(swOrderDetail);
        }
        int flag=swOrderBaseMapper.insert(swOrderBase);
        swOrderDetailMapper.insertBatch(swOrderDetails);
        return Result.newSuccess(flag);
    }



    private void convertVoToEntityDetail(SwOrderDetail swOrderDetail, SwOrderDetailVo swOrderDetailVo) {
        try {
            BeanUtils.copyProperties(swOrderDetail,swOrderDetailVo);
        } catch (IllegalAccessException e) {
            logger.error("转换订单明细语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换订单明细目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }


    private void convertVoToEntity(SwOrderBase swOrderBase, SwOrderBaseVo swOrderBaseVo) {
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
            BeanUtils.copyProperties(swOrderBase,swOrderBaseVo);
        } catch (IllegalAccessException e) {
            logger.error("转换订单主表语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换订单主表目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }


    @Override
    public Page<SwOrderResultVo> findList(Map<String, String> params) {
        //日期查询条件
        params.put("timeCond1","good_date");
        Condition serviceCondition = Common.getServiceCondition(params, SwOrderBase.class);
        List<SwOrderBase> swOrderBases = findByCondition(serviceCondition);
        Page<SwOrderResultVo> swOrderResultVos= new Page<SwOrderResultVo>();
        for(SwOrderBase swOrderBase: swOrderBases){
            SwOrderResultVo swOrderResultVo=new SwOrderResultVo();
            convertEntityTVo(swOrderResultVo,swOrderBase);
            swOrderResultVos.add(swOrderResultVo);
        }
        return swOrderResultVos;
    }

    @Override
    public Result<Integer> audit(SwOrderAuditVo swOrderAuditVo) {
        Result _orderAudit=Result.newSuccess();
        List<String> orderNos=swOrderAuditVo.getOrderNos();
        try{
            Result<SysAuditConfig> _resultAudit=null;
            for(String orderNo:orderNos){
                _resultAudit=singleAudit(orderNo,swOrderAuditVo);
                if(!_resultAudit.isSuccess()){
                    break;
                }
            }
            _orderAudit.setError(_resultAudit.getCode(),_resultAudit.getMessage());
        }catch (Exception e){
            logger.error("[业务订单审核]发生异常!e:{}",e);
            _orderAudit.setErrorCode(ResultCode.FAIL);
        }
        return _orderAudit;
    }

    private   Result<SysAuditConfig> singleAudit(String orderNo,SwOrderAuditVo swOrderAuditVo) {
        Result<SysAuditConfig> _result=beginAudit(orderNo,swOrderAuditVo);
        if(_result.isSuccess()){
            SysAuditConfig sysAuditConfig=_result.getData();
            SwOrderBase swOrderBase=new SwOrderBase();
            swOrderBase.setOrderNo(orderNo);
            swOrderBase.setOrderStatus(sysAuditConfig.getNextStage());
            swOrderBase.setModiNo(swOrderAuditVo.getAuditUserNo());
            swOrderBase.setModiTime(new Date());
            swOrderBaseMapper.updateByOrderNo(swOrderBase);
        }
        return _result;

    }

    private Result<SysAuditConfig> beginAudit(String sourceNo, SwOrderAuditVo swOrderAuditVo) {
        AuditingParam auditingParam=new AuditingParam();
        auditingParam.setSourceNo(sourceNo);
        auditingParam.setAuditType(AuditTypeEnum.ORDER.getCode());
        auditingParam.setCurrentStage(swOrderAuditVo.getOrderStatus().getCode());
        auditingParam.setAuditAction(swOrderAuditVo.getAuditAction().getCode());
        auditingParam.setAuditUserNo(swOrderAuditVo.getAuditUserNo());
        auditingParam.setAuditUserName(swOrderAuditVo.getAuditUserName());
        auditingParam.setAuditDesc(swOrderAuditVo.getAuditDesc());
        return auditingService.auditing(auditingParam);
    }

    private void convertEntityTVo(SwOrderResultVo swOrderResultVo, SwOrderBase swOrderBase) {

        try {
            BeanUtils.copyProperties(swOrderResultVo,swOrderBase);
            swOrderResultVo.setFinishDate(DateUtil.formatDate(swOrderBase.getFinishDate()));
            swOrderResultVo.setOrderDate(DateUtil.formatDate(swOrderBase.getOrderDate()));
            swOrderResultVo.setGoodDate(DateUtil.formatDate(swOrderBase.getGoodDate()));
            swOrderResultVo.setCreateTime(DateUtil.formatDateTime(swOrderBase.getCreateTime()));
            swOrderResultVo.setModiTime(DateUtil.formatDateTime(swOrderBase.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示Vo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示Vo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}