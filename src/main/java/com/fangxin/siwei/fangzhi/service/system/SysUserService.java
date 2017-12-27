package com.fangxin.siwei.fangzhi.service.system;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SysUser;
import com.fangxin.siwei.fangzhi.vo.result.SysUserResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysUserModiVo;
import com.fangxin.siwei.fangzhi.vo.system.SysUserVo;

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

    /**
     * 按照用户号删除用户
     * @param userNo
     */
    Result<Integer> delUser(String userNo);

    /**
     * 按照用户号获取用户
     * @param userNo
     * @return
     */
    SysUser getUserById(String userNo);

    String getUserNameById(String userNo);

    /**
     * 按照用户号获取用户信息
     * @param loginNo
     * @return
     */
    SysUserResultVo getUserInfoByNo(String loginNo);

    Result<Integer> modiPass(SysUserModiVo sysUserModiVo);

    Result<Integer> operUser(String userNo);
}
