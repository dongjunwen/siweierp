package com.fangxin.siwei.fangzhi.service.base;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SwDepartInfo;
import com.fangxin.siwei.fangzhi.vo.base.SwDepartInfoVo;
import com.github.pagehelper.Page;

import java.util.Map; /**
 * @Date:2017/10/20 0020 16:58
 * @Author lu.dong
 * @Description：
 **/
public interface SwDepartInfoService {
    Result<Integer> create(SwDepartInfoVo swDepartInfoVo);

    Result<Integer> update(SwDepartInfoVo swDepartInfoVo);

    Result<Integer> delete(String departNo);

    SwDepartInfo getEntityByNo(String departNo);

    Page<SwDepartInfo> findList(Map<String, String> params);
}
