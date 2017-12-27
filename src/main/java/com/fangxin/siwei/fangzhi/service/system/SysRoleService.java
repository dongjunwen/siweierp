package com.fangxin.siwei.fangzhi.service.system;



import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SysResource;
import com.fangxin.siwei.fangzhi.modal.SysRole;
import com.fangxin.siwei.fangzhi.vo.system.SysRoleVo;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map; /**
 * @Date:2017/10/23 0023 16:07
 * @Author lu.dong
 * @Description：
 **/
public interface SysRoleService {
    Result<Integer> create(SysRoleVo sysRoleVo);

    Result<Integer> update(SysRoleVo sysRoleVo);

    Result<Integer> delete(String roleCode);

    SysRole getEntityByNo(String roleCode);

    Page<SysRole> findList(Map<String, String> params);

    List<SysRole> findRoleLike(String condStr);
}
