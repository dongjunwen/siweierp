package com.fangxin.siwei.fangzhi.service.impl.order;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.mapper.SwOrderBaseMapper;
import com.fangxin.siwei.fangzhi.mapper.SwOrderDetailMapper;
import com.fangxin.siwei.fangzhi.modal.SwOrderBase;
import com.fangxin.siwei.fangzhi.modal.SwOrderDetail;
import com.fangxin.siwei.fangzhi.modal.SysDict;
import com.fangxin.siwei.fangzhi.service.impl.system.SysDictServiceImpl;
import com.fangxin.siwei.fangzhi.service.order.SwOrderService;
import com.fangxin.siwei.fangzhi.vo.SwOrderBaseVo;
import com.fangxin.siwei.fangzhi.vo.SwOrderDetailVo;
import com.fangxin.siwei.fangzhi.vo.SwOrderVo;
import com.fangxin.siwei.fangzhi.vo.SysDictVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/10/24 0024 14:49
 * @Author lu.dong
 * @Description：订单合同服务类
 **/
@Service
public class SwOrderServiceImpl implements SwOrderService {

    private static  final Logger logger= LoggerFactory.getLogger(SwOrderServiceImpl.class);

    @Autowired
    SwOrderBaseMapper swOrderBaseMapper;
    @Autowired
    SwOrderDetailMapper swOrderDetailMapper;

    @Transactional
    @Override
    public Result<Integer> create(SwOrderVo swOrderVo) {

        SwOrderBaseVo swOrderBaseVo= swOrderVo.getSwOrderBaseVo();
        SwOrderBase swOrderBase=new SwOrderBase();
        convertVoToEntity(swOrderBase,swOrderBaseVo);
        String orderNo= UUIDUtils.genUUID("D");
        swOrderBase.setOrderNo(orderNo);
        swOrderBase.setOrderDate(new Date());
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
                    // TODO Auto-generated catch block
                    e.printStackTrace();
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
}
