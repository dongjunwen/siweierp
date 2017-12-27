package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SysRole;

import java.util.List;

public interface SysRoleMapper extends MyMapper<SysRole> {

    SysRole selectByRoleCode(String roleCode);

    List<SysRole> findRoleLike(String condStr);
}