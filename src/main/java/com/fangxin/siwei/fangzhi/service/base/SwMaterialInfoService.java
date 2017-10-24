package com.fangxin.siwei.fangzhi.service.base;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SwMaterialInfo;
import com.fangxin.siwei.fangzhi.vo.base.SwMaterialInfoVo;
import com.github.pagehelper.Page;

import java.util.Map; /**
 * @Date:2017/10/20 0020 17:24
 * @Author lu.dong
 * @Description：
 **/
public interface SwMaterialInfoService {
    Result<Integer> create(SwMaterialInfoVo swMaterialInfoVo);

    Result<Integer> update(SwMaterialInfoVo swMaterialInfoVo);

    Result<Integer> delete(String materialNo);

    SwMaterialInfo getEntityByNo(String materialNo);

    Page<SwMaterialInfo> findList(Map<String, String> params);
}
