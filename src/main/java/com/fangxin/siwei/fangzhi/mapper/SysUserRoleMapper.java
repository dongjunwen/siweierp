package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SysUserRole;

import java.util.List;

public interface SysUserRoleMapper extends MyMapper<SysUserRole>{

    List<SysUserRole> selectByUserNo(String userNo);
}