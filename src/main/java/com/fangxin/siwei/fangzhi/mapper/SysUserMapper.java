package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SysUser;

public interface SysUserMapper extends MyMapper<SysUser> {


    SysUser selectByUserNo(String userNo);

    int deleteByUserNo(String userNo);

    int updateByUserNo(SysUser sysUser);
}