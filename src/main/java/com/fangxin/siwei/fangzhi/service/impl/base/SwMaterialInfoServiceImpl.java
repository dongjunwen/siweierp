package com.fangxin.siwei.fangzhi.service.impl.base;

import com.fangxin.siwei.fangzhi.common.enums.MaterialTypeEnum;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.mapper.SwMaterialInfoMapper;
import com.fangxin.siwei.fangzhi.modal.SwMaterialInfo;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.base.SwMaterialInfoService;
import com.fangxin.siwei.fangzhi.vo.base.SwMaterialInfoVo;
import com.fangxin.siwei.fangzhi.vo.result.SwMaterialInfoResultVo;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.InvocationTargetException;
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
public class SwMaterialInfoServiceImpl extends AbstractService<SwMaterialInfo> implements SwMaterialInfoService {
    private static  final Logger logger= LoggerFactory.getLogger(SwMaterialInfoServiceImpl.class);

    @Autowired
    SwMaterialInfoMapper swMaterialInfoMapper;

    @Override
    public Result<Integer> create(SwMaterialInfoVo swMaterialInfoVo) {
        SwMaterialInfo _swMaterialInfo=swMaterialInfoMapper.selectByMaterialNo(swMaterialInfoVo.getMaterialNo());
        if(_swMaterialInfo!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"物料代码已存在!");
        }
        SwMaterialInfo swDepartInfo=new SwMaterialInfo();
        convertVoToEntity(swDepartInfo,swMaterialInfoVo);
        swDepartInfo.setCreateNo(ShiroUtils.getCurrentUserNo());
        swDepartInfo.setCreateTime(new Date());
        swDepartInfo.setModiNo(ShiroUtils.getCurrentUserNo());
        swDepartInfo.setModiTime(new Date());
        return Result.newSuccess(swMaterialInfoMapper.insertSelective(swDepartInfo));
    }

    @Override
    public Result<Integer> update(SwMaterialInfoVo swMaterialInfoVo) {
        SwMaterialInfo _swDepartInfo=swMaterialInfoMapper.selectByMaterialNo(swMaterialInfoVo.getMaterialNo());
        if(_swDepartInfo==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"物料信息不存在!");
        }
        SwMaterialInfo swDepartInfo=new SwMaterialInfo();
        convertVoToEntity(swDepartInfo,swMaterialInfoVo);
        swDepartInfo.setModiNo(ShiroUtils.getCurrentUserNo());
        swDepartInfo.setModiTime(new Date());
        return Result.newSuccess(swMaterialInfoMapper.updateByMateialNo(swDepartInfo));
    }

    @Override
    public Result<Integer> delete(String departNo) {
        SwMaterialInfo _swDepartInfo=swMaterialInfoMapper.selectByMaterialNo(departNo);
        if(_swDepartInfo==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"物料信息不存在!");
        }
        return Result.newSuccess(swMaterialInfoMapper.deleteByPrimaryKey(_swDepartInfo.getId()));
    }

    @Override
    public SwMaterialInfo getEntityByNo(String departNo) {
        return swMaterialInfoMapper.selectByMaterialNo(departNo);
    }

    @Override
    public Page<SwMaterialInfoResultVo> findList(Map<String, String> params) {
        Condition serviceCondition = Common.getServiceCondition(params, SwMaterialInfo.class);
        List<SwMaterialInfo> swMaterialInfos = findByCondition(serviceCondition);
        List<SwMaterialInfoResultVo> swMaterialInfoResultVos=new Page<>();
        for(SwMaterialInfo swMaterialInfo:swMaterialInfos){
            SwMaterialInfoResultVo swMaterialInfoResultVo=new SwMaterialInfoResultVo();
            swMaterialInfoResultVo.setMaterialNo(swMaterialInfo.getMaterialNo());
            swMaterialInfoResultVo.setMaterialName(swMaterialInfo.getMaterialName());
            swMaterialInfoResultVo.setMaterialType(swMaterialInfo.getMaterialType());
            swMaterialInfoResultVo.setPattern(swMaterialInfo.getPattern());
            swMaterialInfoResultVo.setSpec(swMaterialInfo.getSpec());
            swMaterialInfoResultVo.setUnit(swMaterialInfo.getUnit());
            MaterialTypeEnum materialTypeEnum=MaterialTypeEnum.parse(swMaterialInfo.getMaterialType());
            if(materialTypeEnum!=null){
                swMaterialInfoResultVo.setMaterialTypeName(materialTypeEnum.getDesc());
            }else{
                swMaterialInfoResultVo.setMaterialTypeName(swMaterialInfo.getMaterialType());
            }

            swMaterialInfoResultVos.add(swMaterialInfoResultVo);
        }
        return (Page<SwMaterialInfoResultVo>) swMaterialInfoResultVos;
    }

    @Override
    public List<SwMaterialInfo> findMaterialLike(String condStr) {
        return swMaterialInfoMapper.findMaterialLike(condStr);
    }

    private void convertVoToEntity(SwMaterialInfo swDepartInfo, SwMaterialInfoVo swMaterialInfoVo) {
        try {
            BeanUtils.copyProperties(swDepartInfo,swMaterialInfoVo);
        } catch (IllegalAccessException e) {
            logger.error("物料转换法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("物料转换目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}
