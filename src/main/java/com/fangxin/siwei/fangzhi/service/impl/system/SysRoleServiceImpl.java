package com.fangxin.siwei.fangzhi.service.impl.system;

import com.fangxin.siwei.fangzhi.mapper.SysRoleMapper;
import com.fangxin.siwei.fangzhi.modal.SysRole;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.system.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date:2017/10/23 0023 16:08
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
   @Autowired
    SysRoleMapper sysRoleMapper;
}
