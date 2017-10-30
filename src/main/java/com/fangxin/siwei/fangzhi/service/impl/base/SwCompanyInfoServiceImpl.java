package com.fangxin.siwei.fangzhi.service.impl.base;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.mapper.SwCompanyInfoMapper;
import com.fangxin.siwei.fangzhi.modal.SwCompanyInfo;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.base.SwCompanyInfoService;
import com.fangxin.siwei.fangzhi.vo.base.SwCompInfoVo;
import com.fangxin.siwei.fangzhi.vo.result.SwCompInfoResultVo;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/20 0020 14:15
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SwCompanyInfoServiceImpl extends AbstractService<SwCompanyInfo> implements SwCompanyInfoService {

    private static  final Logger logger= LoggerFactory.getLogger(SwCompanyInfoServiceImpl.class);

    @Autowired
    SwCompanyInfoMapper swCompanyInfoMapper;

    @Override
    public Result<Integer> create(SwCompInfoVo swCompInfoVo) {
        SwCompanyInfo _swCompanyInfo=swCompanyInfoMapper.selectByCompNo(swCompInfoVo.getCompNo());
        if(_swCompanyInfo!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"公司代码已存在!");
        }
        SwCompanyInfo swCompanyInfo=new SwCompanyInfo();
        convertVoToEntity(swCompanyInfo,swCompInfoVo);
        swCompanyInfo.setCreateNo(ShiroUtils.getCurrentUserNo());
        swCompanyInfo.setCreateTime(new Date());
        swCompanyInfo.setModiNo(ShiroUtils.getCurrentUserNo());
        swCompanyInfo.setModiTime(new Date());
        return Result.newSuccess(swCompanyInfoMapper.insertSelective(swCompanyInfo));
    }

    @Override
    public Result<Integer> update(SwCompInfoVo swCompInfoVo) {
        SwCompanyInfo _swCompanyInfo=swCompanyInfoMapper.selectByCompNo(swCompInfoVo.getCompNo());
        if(_swCompanyInfo==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"公司信息不存在!");
        }
        SwCompanyInfo swCompanyInfo=new SwCompanyInfo();
        convertVoToEntity(swCompanyInfo,swCompInfoVo);
        swCompanyInfo.setModiNo(ShiroUtils.getCurrentUserNo());
        swCompanyInfo.setModiTime(new Date());
        return Result.newSuccess(swCompanyInfoMapper.updateByCompNo(swCompanyInfo));
    }

    @Override
    public Result<Integer> delete(String compNo) {
        SwCompanyInfo _swCompanyInfo=swCompanyInfoMapper.selectByCompNo(compNo);
        if(_swCompanyInfo==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"公司信息不存在!");
        }
        return Result.newSuccess(swCompanyInfoMapper.deleteByPrimaryKey(_swCompanyInfo.getId()));
    }

    @Override
    public SwCompanyInfo getEntityByNo(String compNo) {
        return swCompanyInfoMapper.selectByCompNo(compNo);
    }

    @Override
    public Page<SwCompanyInfo> findList(Map<String, String> params) {
        Condition serviceCondition = Common.getServiceCondition(params, SwCompanyInfo.class);
        List<SwCompanyInfo> companyInfos = findByCondition(serviceCondition);
        return (Page<SwCompanyInfo>) companyInfos;
    }

    @Override
    public SwCompInfoResultVo findCompLike(String condStr) {
        SwCompanyInfo swCompanyInfo=swCompanyInfoMapper.findCompLike(condStr);
        SwCompInfoResultVo swCompInfoResultVo=new SwCompInfoResultVo();
        convertToResultEntity(swCompInfoResultVo,swCompanyInfo);
        return swCompInfoResultVo;
    }


    private void convertVoToEntity(SwCompanyInfo swCompanyInfo, SwCompInfoVo swCompInfoVo) {
        if(swCompInfoVo==null){
            return;
        }
        try {
            BeanUtils.copyProperties(swCompanyInfo,swCompInfoVo);
        } catch (IllegalAccessException e) {
            logger.error("转换法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    private void convertToResultEntity(SwCompInfoResultVo swCompInfoResultVo, SwCompanyInfo swCompanyInfo) {
        if(swCompanyInfo==null){
            return;
        }
        try {
            BeanUtils.copyProperties(swCompInfoResultVo,swCompanyInfo);
        } catch (IllegalAccessException e) {
            logger.error("转换公司结果实体语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换司结果实体目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}
