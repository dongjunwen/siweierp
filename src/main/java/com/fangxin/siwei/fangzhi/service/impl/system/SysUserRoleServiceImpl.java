package com.fangxin.siwei.fangzhi.service.impl.system;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.mapper.SysRoleMapper;
import com.fangxin.siwei.fangzhi.mapper.SysUserRoleMapper;
import com.fangxin.siwei.fangzhi.modal.SysRole;
import com.fangxin.siwei.fangzhi.modal.SysUserRole;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.system.SysUserRoleService;
import com.fangxin.siwei.fangzhi.vo.result.SysUserRoleResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysUserRoleVo;
import org.apache.catalina.startup.RealmRuleSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/10/23 0023 16:13
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public List<SysUserRole> selectByUserNo(String userNo) {
        return sysUserRoleMapper.selectByUserNo(userNo);
    }

    @Override
    public Result<Integer> create(SysUserRoleVo sysUserRoleVo) {
        SysUserRole _sysUserRole=sysUserRoleMapper.selectByUserNoAndRoleCode(sysUserRoleVo.getUserNo(),sysUserRoleVo.getRoleCode());
        if(_sysUserRole!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"用户已经拥有了该角色!");
        }
        SysUserRole sysUserRole=new SysUserRole();
        sysUserRole.setUserNo(sysUserRoleVo.getUserNo());
        sysUserRole.setRoleCode(sysUserRoleVo.getRoleCode());
        sysUserRole.setCreateNo(ShiroUtils.getCurrentUserNo());
        sysUserRole.setCreateTime(new Date());
        sysUserRole.setModiNo(ShiroUtils.getCurrentUserNo());
        sysUserRole.setModiTime(new Date());
        sysUserRole.setVersion(0);
        return  Result.newSuccess(sysUserRoleMapper.insertSelective(sysUserRole));
    }

    @Override
    public List<SysUserRoleResultVo> getEntityByUserNo(String userNo) {
        List<SysUserRole> sysUserRoles=selectByUserNo(userNo);
        List<SysUserRoleResultVo> sysUserRoleResultVos=new ArrayList<>();
        for(SysUserRole sysUserRole:sysUserRoles){
            SysUserRoleResultVo sysUserRoleResultVo=new SysUserRoleResultVo();
            sysUserRoleResultVo.setId(sysUserRole.getId());
            sysUserRoleResultVo.setUserNo(sysUserRole.getUserNo());
            sysUserRoleResultVo.setRoleCode(sysUserRole.getRoleCode());
            SysRole sysRole=sysRoleMapper.selectByRoleCode(sysUserRole.getRoleCode());
            sysUserRoleResultVo.setRoleName(sysRole.getRoleName());
            sysUserRoleResultVos.add(sysUserRoleResultVo);
        }
        return sysUserRoleResultVos;
    }

    @Override
    public Result<Integer> deleteByIds(String ids) {
        return Result.newSuccess(sysUserRoleMapper.deleteByIds(ids));
    }

    @Override
    public Result<Integer> delete(String id) {
        return Result.newSuccess(sysUserRoleMapper.deleteByPrimaryKey(id));
    }


}
