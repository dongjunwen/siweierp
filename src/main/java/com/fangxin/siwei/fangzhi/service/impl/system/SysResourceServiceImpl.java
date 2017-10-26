package com.fangxin.siwei.fangzhi.service.impl.system;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.mapper.SysResourceMapper;
import com.fangxin.siwei.fangzhi.modal.SwCompanyInfo;
import com.fangxin.siwei.fangzhi.modal.SysResource;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.system.SysResourceService;
import com.fangxin.siwei.fangzhi.vo.result.SysResourceResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysResourceVo;
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
 * @Date:2017/10/23 0023 14:29
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysResourceServiceImpl extends AbstractService<SysResource> implements SysResourceService {

    private static  final Logger logger= LoggerFactory.getLogger(SysResourceServiceImpl.class);

    @Autowired
    SysResourceMapper sysResourceMapper;


    @Override
    public Result<Integer> create(SysResourceVo sysResourceVo) {
        SysResource _sysResource=sysResourceMapper.selectByResourceNo(sysResourceVo.getSourceNo());
        if(_sysResource!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"资源代码已存在!");
        }
        SysResource sysResource=new SysResource();
        convertVoToEntity(sysResource,sysResourceVo);
        sysResource.setCreateNo(ShiroUtils.getCurrentUserNo());
        sysResource.setCreateTime(new Date());
        sysResource.setModiNo(ShiroUtils.getCurrentUserNo());
        sysResource.setModiTime(new Date());
        return Result.newSuccess(sysResourceMapper.insertSelective(sysResource));
    }

    @Override
    public Result<Integer> update(SysResourceVo sysResourceVo) {
        SysResource _sysResource=sysResourceMapper.selectByResourceNo(sysResourceVo.getSourceNo());
        if(_sysResource==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"菜单资源信息不存在!");
        }
        SysResource sysResource=new SysResource();
        convertVoToEntity(sysResource,sysResourceVo);
        sysResource.setModiNo(ShiroUtils.getCurrentUserNo());
        sysResource.setModiTime(new Date());
        return Result.newSuccess(sysResourceMapper.updateByResourceNo(sysResource));
    }

    @Override
    public Result<Integer> delete(String sourceNo) {
        SysResource _sysResource=sysResourceMapper.selectByResourceNo(sourceNo);
        if(_sysResource==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"资源信息不存在!");
        }
        return Result.newSuccess(sysResourceMapper.deleteByPrimaryKey(_sysResource.getId()));
    }

    @Override
    public SysResource getEntityByNo(String sourceNo) {
        return sysResourceMapper.selectByResourceNo(sourceNo);
    }

    @Override
    public Page<SysResource> findList(Map<String, String> params) {
        Condition serviceCondition = Common.getServiceCondition(params, SwCompanyInfo.class);
        List<SysResource> sysResources = findByCondition(serviceCondition);
        return (Page<SysResource>) sysResources;
    }

    @Override
    public List<SysResourceResultVo> getListByCurrentUser(String currentUserNo) {
        List<SysResource> sysResources =sysResourceMapper.selectListByUserNo(currentUserNo);
        List<SysResourceResultVo> sysResourceResultVos=new ArrayList<>();
        for(SysResource sysResource:sysResources){
            SysResourceResultVo sysResourceResultVo=new SysResourceResultVo();
            sysResourceResultVo.setId(String.valueOf(sysResource.getSourceNo()));
            sysResourceResultVo.setName(sysResource.getSourceName());
            sysResourceResultVo.setRoute(sysResource.getReqUrl());
            if(sysResource.getLevel()==1){
                sysResourceResultVo.setBpid("1");
            }else{
                sysResourceResultVo.setBpid(sysResource.getFhSourceNo());
                sysResourceResultVo.setMpid(sysResource.getFhSourceNo());
            }
            sysResourceResultVo.setIcon(sysResource.getRsourceIcon());
            sysResourceResultVos.add(sysResourceResultVo);
        }
        return sysResourceResultVos;
    }



    private void convertVoToEntity(SysResource sysResource, SysResourceVo sysResourceVo) {
        try {
            BeanUtils.copyProperties(sysResource,sysResourceVo);
        } catch (IllegalAccessException e) {
            logger.error("转换资源语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("转换资源目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }
}
