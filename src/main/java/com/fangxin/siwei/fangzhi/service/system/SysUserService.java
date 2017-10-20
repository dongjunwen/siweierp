package com.fangxin.siwei.fangzhi.service.system;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SysUser;
import com.fangxin.siwei.fangzhi.vo.SysUserVo;

/**
 * @Date:2017/10/19 0019 15:07
 * @Author lu.dong
 * @Description：
 **/
public interface SysUserService {
    /**
     * 创建用户信息
     * @param sysUserVo
     * @return
     */
    Result<Integer> createUser(SysUserVo sysUserVo);

    /**
     * 登录
     * @param userNo 登录账号
     * @return
     */
    SysUser login(String userNo);

    /**
     * 修改用户信息
     * @param sysUserVo
     * @return
     */
    Result<Integer> updateUser(SysUserVo sysUserVo);
}
