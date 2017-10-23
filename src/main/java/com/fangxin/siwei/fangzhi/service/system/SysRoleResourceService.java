package com.fangxin.siwei.fangzhi.service.system;

import com.fangxin.siwei.fangzhi.modal.SysRoleResource;

import java.util.List;

/**
 * @Date:2017/10/23 0023 16:07
 * @Author lu.dong
 * @Description：
 **/
public interface SysRoleResourceService {
    List<SysRoleResource> selectByUserNo(String userNo);
}
