package com.fangxin.siwei.fangzhi.service.impl.base;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Calculator;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.mapper.SwFormularInfoMapper;
import com.fangxin.siwei.fangzhi.modal.SwFormularInfo;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.base.SwFormularInfoService;
import com.fangxin.siwei.fangzhi.vo.base.SwFormularInfoVo;
import com.fangxin.siwei.fangzhi.vo.base.SwLikeVo;
import com.fangxin.siwei.fangzhi.vo.result.SwFormularResultVo;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/20 0020 17:25
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SwFormularInfoServiceImpl extends AbstractService<SwFormularInfo> implements SwFormularInfoService {
    private static  final Logger logger= LoggerFactory.getLogger(SwDepartInfoServiceImpl.class);

    @Autowired
    SwFormularInfoMapper swFormularInfoMapper;

    @Override
    public Result<Integer> create(SwFormularInfoVo swFormularInfoVo) {
        SwFormularInfo _swFormularInfo=swFormularInfoMapper.selectByFormularNo(swFormularInfoVo.getFormularNo());
        if(_swFormularInfo!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"公式代码已存在!");
        }
        SwFormularInfo swFormularInfo=new SwFormularInfo();
        convertVoToEntity(swFormularInfo,swFormularInfoVo);
        swFormularInfo.setCreateNo(ShiroUtils.getCurrentUserNo());
        swFormularInfo.setCreateTime(new Date());
        swFormularInfo.setModiNo(ShiroUtils.getCurrentUserNo());
        swFormularInfo.setModiTime(new Date());
        return Result.newSuccess(swFormularInfoMapper.insertSelective(swFormularInfo));
    }

    @Override
    public Result<Integer> update(SwFormularInfoVo swFormularInfoVo) {
        SwFormularInfo _swFormularInfo=swFormularInfoMapper.selectByFormularNo(swFormularInfoVo.getFormularNo());
        if(_swFormularInfo==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"公式信息不存在!");
        }
        SwFormularInfo swFormularInfo=new SwFormularInfo();
        convertVoToEntity(swFormularInfo,swFormularInfoVo);
        swFormularInfo.setModiNo(ShiroUtils.getCurrentUserNo());
        swFormularInfo.setModiTime(new Date());
        return Result.newSuccess(swFormularInfoMapper.updateByFormularNo(swFormularInfo));
    }

    @Override
    public Result<Integer> delete(String formularNo) {
        SwFormularInfo _swFormularInfo=swFormularInfoMapper.selectByFormularNo(formularNo);
        if(_swFormularInfo==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"公式信息不存在!");
        }
        return Result.newSuccess(swFormularInfoMapper.deleteByPrimaryKey(_swFormularInfo.getId()));
    }

    @Override
    public SwFormularInfo getEntityByNo(String formularNo) {
        return swFormularInfoMapper.selectByFormularNo(formularNo);
    }



    @Override
    public Page<SwFormularInfo> findList(Map<String, String> params) {
        Condition serviceCondition = Common.getServiceCondition(params, SwFormularInfo.class);
        List<SwFormularInfo> swDepartInfos = findByCondition(serviceCondition);
        return (Page<SwFormularInfo>) swDepartInfos;
    }

    @Override
    public List<SwFormularResultVo> findFormularLike( SwLikeVo swLikeVo) {
        String condStr=swLikeVo.getCondStr();
        List<SwFormularInfo> swFormularInfos= swFormularInfoMapper.findFormularLike(condStr);
        List<SwFormularResultVo> swFormularResults=new ArrayList<SwFormularResultVo>();
        for(SwFormularInfo swFormularInfo:swFormularInfos){
            SwFormularResultVo swFormularResultVo=new SwFormularResultVo();
            swFormularResultVo.setFormularNo(swFormularInfo.getFormularNo());
            swFormularResultVo.setFormularName(swFormularInfo.getFormularName());
            swFormularResultVo.setFormularValue(swFormularInfo.getFormularValue());
            swFormularResultVo.setFormularPrice(swFormularInfo.getFormularPrice());
            BigDecimal calValue= Calculator.calNum(swFormularInfo.getFormularValue(),swLikeVo.getLongNum(),swLikeVo.getWidhtNum(),swLikeVo.getReqNum());
            swFormularResultVo.setCalValue(calValue);
            swFormularResults.add(swFormularResultVo);
        }
        return swFormularResults;
    }

    private void convertVoToEntity( SwFormularInfo swFormularInfo, SwFormularInfoVo swFormularInfoVo) {
        try {
            BeanUtils.copyProperties(swFormularInfo,swFormularInfoVo);
        } catch (IllegalAccessException e) {
            logger.error("公式转换法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("公式转换目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}
