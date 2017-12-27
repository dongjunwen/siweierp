package com.fangxin.siwei.fangzhi.service.impl.system;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.mapper.SysResourceMapper;
import com.fangxin.siwei.fangzhi.mapper.SysRoleResourceMapper;
import com.fangxin.siwei.fangzhi.modal.SysResource;
import com.fangxin.siwei.fangzhi.modal.SysRoleResource;
import com.fangxin.siwei.fangzhi.service.system.SysRoleResourceService;
import com.fangxin.siwei.fangzhi.vo.result.SysRoleResourceResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysRoleResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/10/23 0023 16:18
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {
    @Autowired
    SysRoleResourceMapper sysRoleResourceMapper;
    @Autowired
    SysResourceMapper sysResourceMapper;
    @Override
    public List<SysRoleResource> selectByUserNo(String userNo) {
        return sysRoleResourceMapper.selectByUserNo(userNo);
    }

    @Override
    public Result<Integer> create(SysRoleResourceVo sysRoleResourceVo) {
        SysRoleResource oldSysRoleResource=sysRoleResourceMapper.selectByRoleCodeAndSourceNo(sysRoleResourceVo.getRoleCode(),sysRoleResourceVo.getSourceNo());;
        if(oldSysRoleResource!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"角色已经拥有该资源权限!");
        }
        SysRoleResource sysRoleResource=new SysRoleResource();
        sysRoleResource.setRoleCode(sysRoleResourceVo.getRoleCode());
        sysRoleResource.setSourceNo(sysRoleResourceVo.getSourceNo());
        sysRoleResource.setCreateNo(ShiroUtils.getCurrentUserNo());
        sysRoleResource.setCreateTime(new Date());
        sysRoleResource.setModiNo(ShiroUtils.getCurrentUserNo());
        sysRoleResource.setModiTime(new Date());
        sysRoleResource.setVersion(0);
        return  Result.newSuccess(sysRoleResourceMapper.insertSelective(sysRoleResource));
    }

    @Override
    public Result<Integer> delete(String id) {
        return Result.newSuccess(sysRoleResourceMapper.deleteByPrimaryKey(id));
    }

    @Override
    public List<SysRoleResourceResultVo> getEntityByRoleCode(String roleCode) {
        Condition condition = new Condition(SysRoleResource.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andCondition("role_code= '"+roleCode+"'");
        List<SysRoleResource> sysRoleResources = sysRoleResourceMapper.selectByCondition(condition);
        List<SysRoleResourceResultVo> sysResources=new ArrayList<SysRoleResourceResultVo>();
        for(SysRoleResource sysRoleResource:sysRoleResources){
            SysRoleResourceResultVo sysRoleResourceResultVo=new SysRoleResourceResultVo();
            SysResource sysResource=sysResourceMapper.selectByResourceNo(sysRoleResource.getSourceNo());
            sysRoleResourceResultVo.setId(sysRoleResource.getId());
            sysRoleResourceResultVo.setRoleCode(sysRoleResource.getRoleCode());
            sysRoleResourceResultVo.setSourceNo(sysRoleResource.getSourceNo());
            sysRoleResourceResultVo.setSourceName(sysResource.getSourceName());
            sysResources.add(sysRoleResourceResultVo);
        }
        return sysResources;
    }

    @Override
    public Result<Integer> deleteByIds(String ids) {
        return Result.newSuccess(sysRoleResourceMapper.deleteByIds(ids));
    }
}
