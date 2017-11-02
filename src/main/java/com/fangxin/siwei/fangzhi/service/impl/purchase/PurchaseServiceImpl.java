package com.fangxin.siwei.fangzhi.service.impl.purchase;

import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
import com.fangxin.siwei.fangzhi.common.enums.AuditTypeEnum;
import com.fangxin.siwei.fangzhi.common.enums.PurStatus;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.DateUtil;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.mapper.SwPurchaseBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwPurchaseDetailMapper;
import com.fangxin.siwei.fangzhi.modal.SwOrderBase;
import com.fangxin.siwei.fangzhi.modal.SwPurchaseBase;
import com.fangxin.siwei.fangzhi.modal.SwPurchaseDetail;
import com.fangxin.siwei.fangzhi.modal.SysAuditConfig;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.audit.AuditingParam;
import com.fangxin.siwei.fangzhi.service.audit.IAuditingService;
import com.fangxin.siwei.fangzhi.service.purchase.PurchaseService;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurAuditVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderBaseVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderDetailVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderDetailResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderResultVo;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/1 0001 15:11
 * @Author lu.dong
 * @Description：采购单
 **/
@Service
public class PurchaseServiceImpl extends AbstractService<SwPurchaseBase> implements PurchaseService {

    private static  final Logger logger= LoggerFactory.getLogger(PurchaseServiceImpl.class);

    @Autowired
    SwPurchaseBaseMapper swPurchaseBaseMapper;
    @Autowired
    SwPurchaseDetailMapper swPurchaseDetailMapper;
    @Autowired
    IAuditingService auditingService;


    @Override
    public Result<Integer> create(SwPurOrderVo swPurOrderVo) {
        SwPurOrderBaseVo swPurOrderBaseVo= swPurOrderVo.getSwPurOrderBaseVo();
        SwPurchaseBase swPurchaseBase=new SwPurchaseBase();
        convertVoToEntity(swPurchaseBase,swPurOrderBaseVo);
        String orderNo= UUIDUtils.genUUID(ConstantKey.PURCHASE_KEY_PRE);
        swPurchaseBase.setPurNo(orderNo);
        swPurchaseBase.setPurDate(new Date());
        swPurchaseBase.setPurStatus(PurStatus.WAIT_AUDIT.getCode());
        swPurchaseBase.setCreateNo(ShiroUtils.getCurrentUserNo());
        swPurchaseBase.setCreateTime(new Date());
        swPurchaseBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swPurchaseBase.setModiTime(new Date());
        List<SwPurOrderDetailVo> swPurOrderDetailVos=swPurOrderVo.getSwPurOrderDetailVo();
        List swOrderDetails=new ArrayList();
        for(SwPurOrderDetailVo swPurOrderDetailVo:swPurOrderDetailVos){
            SwPurchaseDetail swPurchaseDetail=new SwPurchaseDetail();
            convertVoToEntityDetail(swPurchaseDetail,swPurOrderDetailVo);
            swPurchaseDetail.setOrderNo(orderNo);
            swPurchaseDetail.setCreateNo(ShiroUtils.getCurrentUserNo());
            swPurchaseDetail.setCreateTime(new Date());
            swPurchaseDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            swPurchaseDetail.setModiTime(new Date());
            swOrderDetails.add(swPurchaseDetail);
        }
        int flag=swPurchaseBaseMapper.insert(swPurchaseBase);
        swPurchaseDetailMapper.insertBatch(swOrderDetails);
        return Result.newSuccess(flag);
    }

    private void convertVoToEntityDetail(SwPurchaseDetail swPurchaseDetail, SwPurOrderDetailVo swPurOrderDetailVo) {
        try {
            BeanUtils.copyProperties(swPurchaseDetail,swPurOrderDetailVo);
        } catch (IllegalAccessException e) {
            logger.error("转换采购单明细语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换采购单明细目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }


    private void convertVoToEntity(SwPurchaseBase swPurchaseBase, SwPurOrderBaseVo swPurOrderBaseVo) {
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
            BeanUtils.copyProperties(swPurchaseBase,swPurOrderBaseVo);
        } catch (IllegalAccessException e) {
            logger.error("转换采购单主表语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换采购单主表目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    @Override
    public Page<SwPurOrderBaseResultVo> findList(Map<String, String> params) {
        //日期查询条件
        params.put("timeCond1","pur_date");
        Condition serviceCondition = Common.getServiceCondition(params, SwOrderBase.class);
        List<SwPurchaseBase> swPurchaseBases = findByCondition(serviceCondition);
        Page<SwPurOrderBaseResultVo> swOrderBaseResultVos= new Page<SwPurOrderBaseResultVo>();
        for(SwPurchaseBase swPurchaseBase: swPurchaseBases){
            SwPurOrderBaseResultVo swPurOrderBaseResultVo=new SwPurOrderBaseResultVo();
            convertEntityTVo(swPurOrderBaseResultVo,swPurchaseBase);
            swOrderBaseResultVos.add(swPurOrderBaseResultVo);
        }
        return swOrderBaseResultVos;
    }

    private void convertEntityTVo(SwPurOrderBaseResultVo swPurOrderBaseResultVo, SwPurchaseBase swPurchaseBase) {

        try {
            BeanUtils.copyProperties(swPurOrderBaseResultVo,swPurchaseBase);
            swPurOrderBaseResultVo.setPurDate(DateUtil.formatDate(swPurchaseBase.getPurDate()));
            swPurOrderBaseResultVo.setExpectDate(DateUtil.formatDate(swPurchaseBase.getExpectDate()));
            swPurOrderBaseResultVo.setCreateTime(DateUtil.formatDateTime(swPurchaseBase.getCreateTime()));
            swPurOrderBaseResultVo.setModiTime(DateUtil.formatDateTime(swPurchaseBase.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示Vo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示Vo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    @Override
    public Result<Integer> audit(SwPurAuditVo swPurAuditVo) {
        Result _orderAudit=Result.newSuccess();
        List<String> orderNos=swPurAuditVo.getOrderNos();
        try{
            Result<SysAuditConfig> _resultAudit=null;
            for(String orderNo:orderNos){
                _resultAudit=singleAudit(orderNo,swPurAuditVo);
                if(!_resultAudit.isSuccess()){
                    break;
                }
            }
            _orderAudit.setError(_resultAudit.getCode(),_resultAudit.getMessage());
        }catch (Exception e){
            logger.error("[采购单审核]发生异常!e:{}",e);
            _orderAudit.setErrorCode(ResultCode.FAIL);
        }
        return _orderAudit;
    }

    private Result<SysAuditConfig> singleAudit(String orderNo, SwPurAuditVo swPurAuditVo) {
        Result<SysAuditConfig> _result=beginAudit(orderNo,swPurAuditVo);
        if(_result.isSuccess()){
            SysAuditConfig sysAuditConfig=_result.getData();
            SwOrderBase swOrderBase=new SwOrderBase();
            swOrderBase.setOrderNo(orderNo);
            swOrderBase.setOrderStatus(sysAuditConfig.getNextStage());
            swOrderBase.setModiNo(swPurAuditVo.getAuditUserNo());
            swOrderBase.setModiTime(new Date());
            swPurchaseBaseMapper.updateByPurNo(swOrderBase);
        }
        return _result;
    }

    private Result<SysAuditConfig> beginAudit(String sourceNo, SwPurAuditVo swPurAuditVo) {
        AuditingParam auditingParam=new AuditingParam();
        auditingParam.setSourceNo(sourceNo);
        auditingParam.setAuditType(AuditTypeEnum.PURCHASE);
        auditingParam.setCurrentStage(swPurAuditVo.getPurStatus().getCode());
        auditingParam.setAuditAction(swPurAuditVo.getAuditAction().getCode());
        auditingParam.setAuditUserNo(swPurAuditVo.getAuditUserNo());
        auditingParam.setAuditUserName(swPurAuditVo.getAuditUserName());
        auditingParam.setAuditDesc(swPurAuditVo.getAuditDesc());
        return auditingService.auditing(auditingParam);
    }

    @Override
    public SwPurOrderResultVo getEntityByNo(String orderNo) {
        SwPurchaseBase swPurchaseBase=swPurchaseBaseMapper.selectByPurNo(orderNo);
        if(swPurchaseBase==null){
            throw  new RRException(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),ResultCode.COMMON_DATA_NOT_EXISTS.getMessage());
        }
        SwPurOrderResultVo swPurOrderResultVo=new SwPurOrderResultVo();
        SwPurOrderBaseResultVo swOrderBaseResultVo=new SwPurOrderBaseResultVo();
        convertEntityTVo(swOrderBaseResultVo,swPurchaseBase);
        swPurOrderResultVo.setSwPurOrderBaseResultVo(swOrderBaseResultVo);
        List<SwPurchaseDetail> swPurchaseDetails=swPurchaseDetailMapper.selectByPurNo(orderNo);
        List<SwPurOrderDetailResultVo> swORderDetailResultVos=new ArrayList<>();
        for(SwPurchaseDetail swPurchaseDetail:swPurchaseDetails){
            SwPurOrderDetailResultVo swPurOrderDetailResultVo=new SwPurOrderDetailResultVo();
            convertDetailEntityTVo(swPurOrderDetailResultVo,swPurchaseDetail);
            swORderDetailResultVos.add(swPurOrderDetailResultVo);
        }
        swPurOrderResultVo.setSwPurOrderDetailResultVoList(swORderDetailResultVos);
        return swPurOrderResultVo;
    }

    private void convertDetailEntityTVo(SwPurOrderDetailResultVo swPurOrderDetailResultVo, SwPurchaseDetail swPurchaseDetail) {
        try {
            BeanUtils.copyProperties(swPurOrderDetailResultVo,swPurchaseDetail);
            swPurOrderDetailResultVo.setCreateTime(DateUtil.formatDateTime(swPurchaseDetail.getCreateTime()));
            swPurOrderDetailResultVo.setModiTime(DateUtil.formatDateTime(swPurchaseDetail.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示DetailVo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示DetailVo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}
