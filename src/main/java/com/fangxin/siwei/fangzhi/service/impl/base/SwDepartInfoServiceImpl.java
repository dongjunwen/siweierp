package com.fangxin.siwei.fangzhi.service.impl.base;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.mapper.SwDepartInfoMapper;
import com.fangxin.siwei.fangzhi.modal.SwCompanyInfo;
import com.fangxin.siwei.fangzhi.modal.SwDepartInfo;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.base.SwDepartInfoService;
import com.fangxin.siwei.fangzhi.vo.SwCompInfoVo;
import com.fangxin.siwei.fangzhi.vo.SwDepartInfoVo;
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
 * @Date:2017/10/20 0020 17:01
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SwDepartInfoServiceImpl extends AbstractService<SwDepartInfo> implements SwDepartInfoService {

    private static  final Logger logger= LoggerFactory.getLogger(SwDepartInfoServiceImpl.class);

    @Autowired
    SwDepartInfoMapper swDepartInfoMapper;

    @Override
    public Result<Integer> create(SwDepartInfoVo swDepartInfoVo) {
        SwDepartInfo _swDepartInfo=swDepartInfoMapper.selectByDepartNo(swDepartInfoVo.getDepartNo());
        if(_swDepartInfo!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"部门代码已存在!");
        }
        SwDepartInfo swDepartInfo=new SwDepartInfo();
        convertVoToEntity(swDepartInfo,swDepartInfoVo);
        swDepartInfo.setCreateNo(ShiroUtils.getCurrentUserNo());
        swDepartInfo.setCreateTime(new Date());
        swDepartInfo.setModiNo(ShiroUtils.getCurrentUserNo());
        swDepartInfo.setModiTime(new Date());
        return Result.newSuccess(swDepartInfoMapper.insertSelective(swDepartInfo));
    }

    @Override
    public Result<Integer> update(SwDepartInfoVo swDepartInfoVo) {
        SwDepartInfo _swDepartInfo=swDepartInfoMapper.selectByDepartNo(swDepartInfoVo.getDepartNo());
        if(_swDepartInfo==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"部门信息不存在!");
        }
        SwDepartInfo swDepartInfo=new SwDepartInfo();
        convertVoToEntity(swDepartInfo,swDepartInfoVo);
        swDepartInfo.setModiNo(ShiroUtils.getCurrentUserNo());
        swDepartInfo.setModiTime(new Date());
        return Result.newSuccess(swDepartInfoMapper.updateByCompNo(swDepartInfo));
    }

    @Override
    public Result<Integer> delete(String departNo) {
        SwDepartInfo _swDepartInfo=swDepartInfoMapper.selectByDepartNo(departNo);
        if(_swDepartInfo==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"部门信息不存在!");
        }
        return Result.newSuccess(swDepartInfoMapper.deleteByPrimaryKey(_swDepartInfo.getId()));
    }

    @Override
    public SwDepartInfo getEntityByNo(String departNo) {
        return swDepartInfoMapper.selectByDepartNo(departNo);
    }

    @Override
    public Page<SwDepartInfo> findList(Map<String, String> params) {
        Condition serviceCondition = Common.getServiceCondition(params, SwDepartInfo.class);
        List<SwDepartInfo> swDepartInfos = findByCondition(serviceCondition);
        return (Page<SwDepartInfo>) swDepartInfos;
    }

    private void convertVoToEntity(SwDepartInfo swDepartInfo, SwDepartInfoVo swDepartInfoVo) {
        try {
            BeanUtils.copyProperties(swDepartInfo,swDepartInfoVo);
        } catch (IllegalAccessException e) {
            logger.error("部门转换法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("部门转换目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}
