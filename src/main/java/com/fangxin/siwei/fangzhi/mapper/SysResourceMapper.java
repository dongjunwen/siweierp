package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SysResource;

import java.util.List;

public interface SysResourceMapper extends MyMapper<SysResource> {

    SysResource selectByResourceNo(String sourceNo);

    int updateByResourceNo(SysResource sysResource);

    List<SysResource> selectListByUserNo(String userNo);
}