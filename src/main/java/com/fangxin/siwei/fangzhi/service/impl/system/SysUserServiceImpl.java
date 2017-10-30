package com.fangxin.siwei.fangzhi.service.impl.system;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.MD5Util;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.mapper.*;
import com.fangxin.siwei.fangzhi.modal.SwCompanyInfo;
import com.fangxin.siwei.fangzhi.modal.SwDepartEmployee;
import com.fangxin.siwei.fangzhi.modal.SysUser;
import com.fangxin.siwei.fangzhi.modal.SysUserRole;
import com.fangxin.siwei.fangzhi.service.system.SysUserService;
import com.fangxin.siwei.fangzhi.vo.base.SwCompInfoVo;
import com.fangxin.siwei.fangzhi.vo.result.SwCompInfoResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SysUserResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysUserVo;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/10/19 0019 15:08
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysUserServiceImpl  implements SysUserService {
    private static  final Logger logger=LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SwDepartEmployeeMapper swDepartEmployeeMapper;
    @Autowired
    SwDepartInfoMapper swDepartInfoMapper;
    @Autowired
    SwCompanyInfoMapper swCompanyInfoMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    @Override
    public Result<Integer> createUser(SysUserVo sysUserVo) {

        SysUser _sysUser=sysUserMapper.selectByUserNo(sysUserVo.getUserNo());
        if(_sysUser!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"账户已存在!");
        }
        SysUser sysUser=new SysUser();
        convertVoToEntity(sysUser,sysUserVo);
        sysUser.setPassword(MD5Util.getMD5(sysUser.getPassword()));
        sysUser.setCreateNo(ShiroUtils.getCurrentUserNo());
        sysUser.setCreateTime(new Date());
        sysUser.setModiNo(ShiroUtils.getCurrentUserNo());
        sysUser.setModiTime(new Date());
        return Result.newSuccess(sysUserMapper.insertSelective(sysUser));
    }

    @Override
    public SysUser login(String userNo) {
        return sysUserMapper.selectByUserNo(userNo);
    }

    @Override
    public Result<Integer> updateUser(SysUserVo sysUserVo) {

        SysUser _sysUser=sysUserMapper.selectByUserNo(sysUserVo.getUserNo());
        if(_sysUser==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"账户不存在!");
        }
        SysUser sysUser=new SysUser();
        convertVoToEntity(sysUser,sysUserVo);
        sysUser.setModiNo(ShiroUtils.getCurrentUserNo());
        sysUser.setModiTime(new Date());
        return Result.newSuccess(sysUserMapper.updateByUserNo(sysUser));
    }

    @Override
    public  Result<Integer> delUser(String userNo) {
        SysUser _sysUser=sysUserMapper.selectByUserNo(userNo);
        if(_sysUser==null){
            return  Result.newError(ResultCode.COMMON_DATA_NOT_EXISTS.getCode(),"账户不存在!");
        }
        return Result.newSuccess(sysUserMapper.deleteByUserNo(userNo));
    }

    @Override
    public SysUser getUserById(String userNo) {
        return sysUserMapper.selectByUserNo(userNo);
    }

    @Override
    public SysUserResultVo getUserInfoByNo(String loginNo) {
        SysUserResultVo sysUserResultVo=new SysUserResultVo();
        SysUser sysUser=getUserById(loginNo);
        sysUserResultVo.setUserNo(loginNo);
        sysUserResultVo.setUserName(sysUser.getUserName());
        sysUserResultVo.setNickName(sysUser.getNickName());
        sysUserResultVo.setEmailAddr(sysUser.getEmailAddr());
        sysUserResultVo.setPhoneNum(sysUser.getPhoneNum());
        List<SysUserRole> sysUserRoles=sysUserRoleMapper.selectByUserNo(loginNo);
        if(sysUserRoles!=null){
            sysUserResultVo.setRoleCode(sysUserRoles.get(0).getRoleCode());
            sysUserResultVo.setRoleName(sysUserRoles.get(0).getRoleName());
        }
        List<SwDepartEmployee> swDepartEmployees=swDepartEmployeeMapper.selectByUserNo(loginNo);
        if(swDepartEmployees!=null){
            sysUserResultVo.setDepartNo(swDepartEmployees.get(0).getDepartNo());
            sysUserResultVo.setDepartName(swDepartEmployees.get(0).getDepartName());
        }
        SwCompanyInfo swCompanyInfo= swCompanyInfoMapper.selectByUserNo(loginNo);
        SwCompInfoResultVo swCompInfoResultVo=new SwCompInfoResultVo();
        if(swCompanyInfo!=null){
            swCompInfoResultVo.setCompNo(swCompanyInfo.getCompNo());
            swCompInfoResultVo.setCompName(swCompanyInfo.getCompName());
            swCompInfoResultVo.setAddr(swCompanyInfo.getAddr());
            swCompInfoResultVo.setMobile(swCompanyInfo.getMobile());
            swCompInfoResultVo.setTelphone(swCompanyInfo.getTelphone());
            swCompInfoResultVo.setTax(swCompanyInfo.getTax());
            swCompInfoResultVo.setContactName(swCompInfoResultVo.getContactName());
        }
        sysUserResultVo.setSwCompInfoResultVo(swCompInfoResultVo);
        return sysUserResultVo;
    }

    private void convertVoToEntity(SysUser sysUser,SysUserVo sysUserVo) {
        try {
           BeanUtils.copyProperties(sysUser,sysUserVo);
        } catch (IllegalAccessException e) {
            logger.error("sysUser转换语法错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        } catch (InvocationTargetException e) {
            logger.error("sysUser转换目标错误:{}",e);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

}
