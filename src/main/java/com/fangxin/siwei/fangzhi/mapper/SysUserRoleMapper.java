package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleMapper extends MyMapper<SysUserRole>{

    List<SysUserRole> selectByUserNo(String userNo);

    SysUserRole selectByUserNoAndRoleCode(@Param("userNo") String userNo, @Param("roleCode")String roleCode);

    void deleteByUserNo(String userNo);
}