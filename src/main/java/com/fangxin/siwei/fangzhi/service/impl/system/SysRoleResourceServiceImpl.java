package com.fangxin.siwei.fangzhi.service.impl.system;

import com.fangxin.siwei.fangzhi.mapper.SysRoleResourceMapper;
import com.fangxin.siwei.fangzhi.modal.SysRoleResource;
import com.fangxin.siwei.fangzhi.service.system.SysRoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date:2017/10/23 0023 16:18
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {
    @Autowired
    SysRoleResourceMapper sysRoleResourceMapper;
    @Override
    public List<SysRoleResource> selectByUserNo(String userNo) {
        return sysRoleResourceMapper.selectByUserNo(userNo);
    }
}
