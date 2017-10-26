package com.fangxin.siwei.fangzhi.service.system;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SysResource;
import com.fangxin.siwei.fangzhi.vo.result.SysResourceResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysResourceVo;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map; /**
 * @Date:2017/10/23 0023 14:29
 * @Author lu.dong
 * @Description：
 **/
public interface SysResourceService {
    Result<Integer> create(SysResourceVo sysResourceVo);

    Result<Integer> update(SysResourceVo sysResourceVo);

    Result<Integer> delete(String sourceNo);

    SysResource getEntityByNo(String sourceNo);

    Page<SysResource> findList(Map<String, String> params);

    List<SysResourceResultVo> getListByCurrentUser(String currentUserNo);
}
