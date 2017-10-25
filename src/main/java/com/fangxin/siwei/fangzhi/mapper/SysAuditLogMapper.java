package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SysAuditLog;

import java.util.List;

public interface SysAuditLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuditLog record);

    int insertSelective(SysAuditLog record);

    SysAuditLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuditLog record);

    int updateByPrimaryKey(SysAuditLog record);

    List<SysAuditLog> querySysAuditLogsBySourceNo(String sourceNo);
}