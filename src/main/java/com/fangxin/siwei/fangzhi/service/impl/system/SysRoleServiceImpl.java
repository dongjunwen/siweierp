package com.fangxin.siwei.fangzhi.service.impl.system;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.BeanUtilsEx;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.mapper.SysRoleMapper;
import com.fangxin.siwei.fangzhi.modal.SwCompanyInfo;
import com.fangxin.siwei.fangzhi.modal.SysResource;
import com.fangxin.siwei.fangzhi.modal.SysRole;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.system.SysRoleService;
import com.fangxin.siwei.fangzhi.vo.system.SysRoleVo;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/23 0023 16:08
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
   @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public Result<Integer> create(SysRoleVo sysRoleVo) {
        SysRole _sysRole=sysRoleMapper.selectByRoleCode(sysRoleVo.getRoleCode());
        if(_sysRole!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"角色代码已存在!");
        }
        SysRole sysRole=new SysRole();
        convertVoToEntity(sysRole,sysRoleVo);
        sysRole.setCreateNo(ShiroUtils.getCurrentUserNo());
        sysRole.setCreateTime(new Date());
        sysRole.setModiNo(ShiroUtils.getCurrentUserNo());
        sysRole.setModiTime(new Date());
        sysRole.setVersion(0);
        return Result.newSuccess(sysRoleMapper.insertSelective(sysRole));
    }

    private void convertVoToEntity(SysRole sysRole, SysRoleVo sysRoleVo) {
        BeanUtilsEx.copyProperties(sysRole,sysRoleVo);
    }

    @Override
    public Result<Integer> update(SysRoleVo sysRoleVo) {
        SysRole _sysRole=sysRoleMapper.selectByRoleCode(sysRoleVo.getRoleCode());
        if(_sysRole==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"角色代码不存在!");
        }
        SysRole sysRole=new SysRole();
        convertVoToEntity(sysRole,sysRoleVo);
        sysRole.setId(_sysRole.getId());
        sysRole.setModiNo(ShiroUtils.getCurrentUserNo());
        sysRole.setModiTime(new Date());
        sysRole.setVersion(_sysRole.getVersion());
        return Result.newSuccess(sysRoleMapper.updateByPrimaryKeySelective(sysRole));
    }

    @Override
    public Result<Integer> delete(String roleCode) {
        SysRole _sysRole=sysRoleMapper.selectByRoleCode(roleCode);
        if(_sysRole==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"角色代码不存在!");
        }
        return Result.newSuccess(sysRoleMapper.deleteByPrimaryKey(_sysRole.getId()));
    }

    @Override
    public SysRole getEntityByNo(String roleCode) {
        return sysRoleMapper.selectByRoleCode(roleCode);
    }

    @Override
    public Page<SysRole> findList(Map<String, String> params) {
        Condition serviceCondition = Common.getServiceCondition(params, SysRole.class);
        List<SysRole> sysRoles = findByCondition(serviceCondition);
        return (Page<SysRole>) sysRoles;
    }

    @Override
    public List<SysRole> findRoleLike(String condStr) {
        return sysRoleMapper.findRoleLike(condStr);
    }
}
