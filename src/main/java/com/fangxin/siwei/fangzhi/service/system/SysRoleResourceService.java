package com.fangxin.siwei.fangzhi.service.system;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SysResource;
import com.fangxin.siwei.fangzhi.modal.SysRoleResource;
import com.fangxin.siwei.fangzhi.vo.result.SysRoleResourceResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysRoleResourceVo;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/23 0023 16:07
 * @Author lu.dong
 * @Description：
 **/
public interface SysRoleResourceService {

    List<SysRoleResource> selectByUserNo(String userNo);

    Result<Integer> create(SysRoleResourceVo sysRoleResourceVo);

    Result<Integer> delete(String id);

    List<SysRoleResourceResultVo> getEntityByRoleCode(String roleCode);

    Page<SysRoleResourceResultVo> findList(Map<String, String> params);

    Result<Integer> deleteByIdstr(String ids);
}
