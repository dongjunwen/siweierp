package com.fangxin.siwei.fangzhi.service.impl.order;

import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
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
import com.fangxin.siwei.fangzhi.modal.*;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.audit.AuditingParam;
import com.fangxin.siwei.fangzhi.service.audit.IAuditingService;
import com.fangxin.siwei.fangzhi.service.impl.system.SysDictUtils;
import com.fangxin.siwei.fangzhi.service.order.SwOrderService;
import com.fangxin.siwei.fangzhi.service.system.SysUserService;
import com.fangxin.siwei.fangzhi.vo.order.*;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderDetailResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderResultVo;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
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
    @Autowired
    SysUserService sysUserService;

    @Transactional
    @Override
    public Result<Integer> create(SwOrderVo swOrderVo) {

        SwOrderBaseVo swOrderBaseVo= swOrderVo.getSwOrderBaseVo();
        SwOrderBase swOrderBase=new SwOrderBase();
        convertVoToEntity(swOrderBase,swOrderBaseVo);
        String orderNo= UUIDUtils.genUUID(ConstantKey.ORDER_KEY_PRE);
        swOrderBase.setOrderNo(orderNo);
        swOrderBase.setOrderDate(new Date());
        swOrderBase.setOrderStatus(OrderStatus.WAIT_APPLY.getCode());
        swOrderBase.setCreateNo(ShiroUtils.getCurrentUserNo());
        swOrderBase.setCreateTime(new Date());
        swOrderBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swOrderBase.setModiTime(new Date());
        List<SwOrderDetailVo> swOrderDetailVoList=swOrderVo.getSwOrderDetailVos();
        List swOrderDetails=new ArrayList();
        int i=1;
        for(SwOrderDetailVo swOrderDetailVo:swOrderDetailVoList){
            SwOrderDetail swOrderDetail=new SwOrderDetail();
            convertVoToEntityDetail(swOrderDetail,swOrderDetailVo);
            swOrderDetail.setOrderNo(orderNo);
            swOrderDetail.setOrderSeqNo(String.valueOf(i));
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

    @Override
    public Result<Integer> update(SwOrderModiVo swOrderModiVo) {
        SwOrderBaseModiVo swOrderBaseModiVo= swOrderModiVo.getSwOrderBaseModiVo();
        SwOrderBase swOrderBase=new SwOrderBase();
        convertVoToEntity(swOrderBase,swOrderBaseModiVo);
        String orderNo=swOrderBaseModiVo.getOrderNo();
        swOrderBase.setOrderNo(swOrderBaseModiVo.getOrderNo());
        swOrderBase.setOrderStatus(OrderStatus.WAIT_APPLY.getCode());
        swOrderBase.setModiNo(ShiroUtils.getCurrentUserNo());
        swOrderBase.setModiTime(new Date());
        List<SwOrderDetailVo> swOrderDetailVoList=swOrderModiVo.getSwOrderDetailVos();
        List swOrderDetails=new ArrayList();
        int i=1;
        for(SwOrderDetailVo swOrderDetailVo:swOrderDetailVoList){
            SwOrderDetail swOrderDetail=new SwOrderDetail();
            convertVoToEntityDetail(swOrderDetail,swOrderDetailVo);
            swOrderDetail.setOrderNo(orderNo);
            swOrderDetail.setCreateNo(ShiroUtils.getCurrentUserNo());
            swOrderDetail.setCreateTime(new Date());
            swOrderDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            swOrderDetail.setModiTime(new Date());
            swOrderDetail.setOrderSeqNo(String.valueOf(i));
            swOrderDetails.add(swOrderDetail);
            i++;
        }
        int flag=swOrderBaseMapper.updateByOrderNo(swOrderBase);
        swOrderDetailMapper.deleteByOrderNo(orderNo);
        swOrderDetailMapper.insertBatch(swOrderDetails);
        return Result.newSuccess(flag);
    }

    @Override
    public SwOrderResultVo getEntityByCond(SwOrderQueryVo swOrderQueryVo) {
        String orderNo=swOrderQueryVo.getOrderNo();
        String compNo=swOrderQueryVo.getCustCompNo();
        SwOrderBase swOrderBaseCond=new SwOrderBase();
        swOrderBaseCond.setOrderNo(orderNo);
        swOrderBaseCond.setCustCompNo(compNo);
        SwOrderBase swOrderBase=(SwOrderBase) swOrderBaseMapper.selectByCond(swOrderBaseCond);
        if(swOrderBase==null){
            throw  new RRException(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),ResultCode.COMMON_DATA_NOT_EXISTS.getMessage());
        }
        SwOrderResultVo swOrderResultVo=new SwOrderResultVo();
        SwOrderBaseResultVo swOrderBaseResultVo=new SwOrderBaseResultVo();
        convertEntityTVo(swOrderBaseResultVo,swOrderBase);
        swOrderBaseResultVo.setPayWayName(SysDictUtils.getNameByUniq("PAY_WAY",swOrderBaseResultVo.getPayWay()));
        swOrderBaseResultVo.setSaleTypeName(SysDictUtils.getNameByUniq("SALE_TYPE",swOrderBaseResultVo.getSaleType()));
        swOrderBaseResultVo.setOrderTypeName(SysDictUtils.getNameByUniq("ORDER_TYPE",swOrderBaseResultVo.getOrderType()));
        swOrderBaseResultVo.setOrderStatusName(SysDictUtils.getNameByUniq("ORDER_STATUS",swOrderBaseResultVo.getOrderStatus()));
        swOrderResultVo.setSwOrderBaseResultVo(swOrderBaseResultVo);
        List<SwOrderDetail> swOrderDetails=swOrderDetailMapper.selectByOrderNo(orderNo);
        List<SwOrderDetailResultVo> swORderDetailResultVos=new ArrayList<>();
        for(SwOrderDetail swOrderDetail:swOrderDetails){
            SwOrderDetailResultVo swOrderDetailResultVo=new SwOrderDetailResultVo();
            convertDetailEntityTVo(swOrderDetailResultVo,swOrderDetail);
            swORderDetailResultVos.add(swOrderDetailResultVo);
        }
        swOrderResultVo.setSwORderDetailResultVos(swORderDetailResultVos);
        return swOrderResultVo;
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
    public Page<SwOrderBaseResultVo> findList(Map<String, String> params) {
        //日期查询条件
        params.put("timeCond1","good_date");
        Condition serviceCondition = Common.getServiceCondition(params, SwOrderBase.class);
       Page<SwOrderBase>  swOrderBases=(Page<SwOrderBase>) findByCondition(serviceCondition);
        Page<SwOrderBaseResultVo> swOrderBaseResultVos=new Page<SwOrderBaseResultVo>();
        swOrderBaseResultVos.setPageSize(swOrderBases.getPageSize());
        swOrderBaseResultVos.setPageNum(swOrderBases.getPageNum());
        swOrderBaseResultVos.setPages(swOrderBases.getPages());
        swOrderBaseResultVos.setTotal(swOrderBases.getTotal());
        for(SwOrderBase swOrderBase: swOrderBases){
            SwOrderBaseResultVo swOrderBaseResultVo=new SwOrderBaseResultVo();
            convertEntityTVo(swOrderBaseResultVo,swOrderBase);
            swOrderBaseResultVo.setPayWayName(SysDictUtils.getNameByUniq("PAY_WAY",swOrderBaseResultVo.getPayWay()));
            swOrderBaseResultVo.setSaleTypeName(SysDictUtils.getNameByUniq("SALE_TYPE",swOrderBaseResultVo.getSaleType()));
            swOrderBaseResultVo.setOrderTypeName(SysDictUtils.getNameByUniq("ORDER_TYPE",swOrderBaseResultVo.getOrderType()));
            swOrderBaseResultVo.setOrderStatusName(SysDictUtils.getNameByUniq("ORDER_STATUS",swOrderBaseResultVo.getOrderStatus()));
            SysAuditLog sysAuditLog=auditingService.queryLastOperateSysAuditLogBySourceNo(swOrderBaseResultVo.getOrderNo());
            if(sysAuditLog!=null){
                swOrderBaseResultVo.setAuditName(sysAuditLog.getAuditUserName());
                swOrderBaseResultVo.setAuditDesc(sysAuditLog.getAuditDesc());
            }
            swOrderBaseResultVo.setCreateName(sysUserService.getUserNameById(swOrderBaseResultVo.getCreateNo()));
            swOrderBaseResultVo.setModiName(sysUserService.getUserNameById(swOrderBaseResultVo.getModiNo()));
            swOrderBaseResultVos.add(swOrderBaseResultVo);
        }
        return swOrderBaseResultVos;
    }

    @Override
    public Page<SwOrderDetailResultVo> findDetailList(Map<String, String> params) {
        String pageIndexStr= StringUtils.isEmpty(params.get("currPage"))?"1":params.get("currPage");
        Integer pageIndex=Integer.valueOf(pageIndexStr)-1;
        params.put("pageIndex",pageIndex.toString());
        Integer pageSize=Integer.valueOf( StringUtils.isEmpty(params.get("pageSize"))?"10":params.get("pageSize"));
        params.put("pageSize",pageSize.toString());
        int num=swOrderDetailMapper.countNum(params);
        int pages=num%pageSize==0?num/pageSize:num/pageSize+1;
        List<SwOrderDetail> swOrderDetails=swOrderDetailMapper.findList(params);
        Page<SwOrderDetailResultVo> swOrderDetailResultVos=new Page<SwOrderDetailResultVo>();
        swOrderDetailResultVos.setPageSize(pageSize);
        swOrderDetailResultVos.setPageNum(pageIndex+1);
        swOrderDetailResultVos.setPages(pages);
        swOrderDetailResultVos.setTotal(num);
        for(SwOrderDetail swOrderDetail:swOrderDetails){
            SwOrderDetailResultVo swOrderDetailResultVo=new SwOrderDetailResultVo();
            convertDetailEntityTVo(swOrderDetailResultVo,swOrderDetail);
            swOrderDetailResultVos.add(swOrderDetailResultVo);
        }
        return swOrderDetailResultVos;
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

    @Override
    public SwOrderResultVo getEntityByNo(String orderNo) {
        SwOrderBase swOrderBase=swOrderBaseMapper.selectByOrderNo(orderNo);
        if(swOrderBase==null){
            throw  new RRException(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),ResultCode.COMMON_DATA_NOT_EXISTS.getMessage());
        }
        SwOrderResultVo swOrderResultVo=new SwOrderResultVo();
        SwOrderBaseResultVo swOrderBaseResultVo=new SwOrderBaseResultVo();
        convertEntityTVo(swOrderBaseResultVo,swOrderBase);
        swOrderBaseResultVo.setPayWayName(SysDictUtils.getNameByUniq("PAY_WAY",swOrderBaseResultVo.getPayWay()));
        swOrderBaseResultVo.setSaleTypeName(SysDictUtils.getNameByUniq("SALE_TYPE",swOrderBaseResultVo.getSaleType()));
        swOrderBaseResultVo.setOrderTypeName(SysDictUtils.getNameByUniq("ORDER_TYPE",swOrderBaseResultVo.getOrderType()));
        swOrderBaseResultVo.setOrderStatusName(SysDictUtils.getNameByUniq("ORDER_STATUS",swOrderBaseResultVo.getOrderStatus()));
        swOrderResultVo.setSwOrderBaseResultVo(swOrderBaseResultVo);
        List<SwOrderDetail> swOrderDetails=swOrderDetailMapper.selectByOrderNo(orderNo);
        List<SwOrderDetailResultVo> swORderDetailResultVos=new ArrayList<>();
        for(SwOrderDetail swOrderDetail:swOrderDetails){
            SwOrderDetailResultVo swOrderDetailResultVo=new SwOrderDetailResultVo();
            convertDetailEntityTVo(swOrderDetailResultVo,swOrderDetail);
            swORderDetailResultVos.add(swOrderDetailResultVo);
        }
        swOrderResultVo.setSwORderDetailResultVos(swORderDetailResultVos);
        return swOrderResultVo;
    }



    private void convertDetailEntityTVo(SwOrderDetailResultVo swORderDetailResultVo, SwOrderDetail swOrderDetail) {
        try {
            BeanUtils.copyProperties(swORderDetailResultVo,swOrderDetail);
            swORderDetailResultVo.setCreateTime(DateUtil.formatDateTime(swOrderDetail.getCreateTime()));
            swORderDetailResultVo.setModiTime(DateUtil.formatDateTime(swOrderDetail.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示DetailVo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示DetailVo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }

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
        auditingParam.setAuditType(AuditTypeEnum.ORDER);
        auditingParam.setCurrentStage(swOrderAuditVo.getOrderStatus().getCode());
        auditingParam.setAuditAction(swOrderAuditVo.getAuditAction().getCode());
        auditingParam.setAuditUserNo(swOrderAuditVo.getAuditUserNo());
        auditingParam.setAuditUserName(swOrderAuditVo.getAuditUserName());
        auditingParam.setAuditDesc(swOrderAuditVo.getAuditDesc());
        return auditingService.auditing(auditingParam);
    }

    private void convertEntityTVo(SwOrderBaseResultVo swOrderBaseResultVo, SwOrderBase swOrderBase) {

        try {
            BeanUtils.copyProperties(swOrderBaseResultVo,swOrderBase);
            swOrderBaseResultVo.setFinishDate(DateUtil.formatDate(swOrderBase.getFinishDate()));
            swOrderBaseResultVo.setOrderDate(DateUtil.formatDate(swOrderBase.getOrderDate()));
            swOrderBaseResultVo.setGoodDate(DateUtil.formatDate(swOrderBase.getGoodDate()));
            swOrderBaseResultVo.setCreateTime(DateUtil.formatDateTime(swOrderBase.getCreateTime()));
            swOrderBaseResultVo.setModiTime(DateUtil.formatDateTime(swOrderBase.getModiTime()));
        } catch (IllegalAccessException e) {
            logger.error("转换展示Vo语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换展示Vo目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}
