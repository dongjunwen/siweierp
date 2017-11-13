package com.fangxin.siwei.fangzhi.service.impl.system;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.mapper.SysDictMapper;
import com.fangxin.siwei.fangzhi.modal.SysDict;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.system.SysDictService;
import com.fangxin.siwei.fangzhi.vo.system.SysDictVo;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/24 0024 13:49
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysDictServiceImpl extends AbstractService<SysDict> implements SysDictService {
    private static  final Logger logger= LoggerFactory.getLogger(SysDictServiceImpl.class);
    @Autowired
    SysDictMapper sysDictMapper;

    @Override
    public Result<Integer> create(SysDictVo sysDictVo) {
        SysDict _sysDict=sysDictMapper.selectByUniqNo(sysDictVo.getDictType(),sysDictVo.getDictCode());
        if(_sysDict!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"数据字典已存在!");
        }
        SysDict sysDict=new SysDict();
        convertVoToEntity(sysDict,sysDictVo);
        return Result.newSuccess(sysDictMapper.insertSelective(sysDict));
    }

    @Override
    public Result<Integer> update(SysDictVo sysDictVo) {
        SysDict _sysDict=sysDictMapper.selectByUniqNo(sysDictVo.getDictType(),sysDictVo.getDictCode());
        if(_sysDict==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"数据字典不存在!");
        }
        SysDict sysDict=new SysDict();
        convertVoToEntity(sysDict,sysDictVo);
        sysDict.setId(_sysDict.getId());
        return Result.newSuccess(sysDictMapper.updateByPrimaryKeySelective(sysDict));
    }

    @Override
    public Result<Integer> delete(String dictType,String dictCode) {
        SysDict _sysDict=sysDictMapper.selectByUniqNo(dictType,dictCode);
        if(_sysDict==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"数据字典不存在!");
        }
        String ids=_sysDict.getId().toString();
        return Result.newSuccess(sysDictMapper.deleteByIds(ids));
    }

    @Override
    public SysDict getEntityByNo(String dictType,String dictCode) {
        return sysDictMapper.selectByUniqNo(dictType,dictCode);
    }

    @Override
    public Page<SysDict> findList(Map<String, String> params) {
        Condition serviceCondition = Common.getServiceCondition(params, SysDict.class);
        List<SysDict> sysDicts = findByCondition(serviceCondition);
        return (Page<SysDict>) sysDicts;
    }

    public List<SysDict> findAll(){
        return sysDictMapper.findAll();
    }

    @Override
    public List<SysDict> getEntityByDictType(String dictType) {
        return sysDictMapper.selectByDictType(dictType);
    }

    private void convertVoToEntity(SysDict sysDict, SysDictVo sysDictVo) {
        try {
            BeanUtils.copyProperties(sysDict,sysDictVo);
        } catch (IllegalAccessException e) {
            logger.error("转换数据字典语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换数据字典目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}
