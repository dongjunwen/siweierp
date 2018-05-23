package com.fangxin.siwei.fangzhi.service.system;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SysRole;
import com.fangxin.siwei.fangzhi.modal.SysUserRole;
import com.fangxin.siwei.fangzhi.vo.result.SysUserRoleResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysUserRoleVo;

import java.util.List;

/**
 * @Date:2017/10/23 0023 16:12
 * @Author lu.dong
 * @Description：
 **/
public interface SysUserRoleService  {
    List<SysUserRole> selectByUserNo(String userNo);

    List<SysUserRoleResultVo> getEntityByUserNo(String userNo);

    Result<Integer> deleteByIds(String ids);

    Result<Integer> delete(String id);

    Result<Integer> create(SysUserRoleVo sysUserRoleVo);

    void deleteByUserNo(String userNo);
}
