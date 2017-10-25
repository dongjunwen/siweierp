package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SysAuditConfig;
import org.apache.ibatis.annotations.Param;

public interface SysAuditConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuditConfig record);

    int insertSelective(SysAuditConfig record);

    SysAuditConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuditConfig record);

    int updateByPrimaryKey(SysAuditConfig record);

    SysAuditConfig findNextStage(@Param("auditType") String auditType, @Param("currentStage")String currentStage, @Param("auditAction")String auditAction);
}