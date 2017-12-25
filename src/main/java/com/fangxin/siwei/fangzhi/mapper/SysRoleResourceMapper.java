package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SysRoleResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleResourceMapper extends MyMapper<SysRoleResource>{


    List<SysRoleResource> selectByUserNo(String userNo);

    SysRoleResource selectByRoleCodeAndSourceNo(@Param("roleCode") String roleCode, @Param("sourceNo")String sourceNo);
}