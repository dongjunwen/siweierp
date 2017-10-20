package com.fangxin.siwei.fangzhi.service.base;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SwFormularInfo;
import com.fangxin.siwei.fangzhi.vo.SwFormularInfoVo;
import com.github.pagehelper.Page;

import java.util.Map; /**
 * @Date:2017/10/20 0020 17:24
 * @Author lu.dong
 * @Description：
 **/
public interface SwFormularInfoService {
    Result<Integer> create(SwFormularInfoVo swFormularInfoVo);

    Result<Integer> update(SwFormularInfoVo swFormularInfoVo);

    Result<Integer> delete(String formularNo);

    SwFormularInfo getEntityByNo(String formularNo);

    Page<SwFormularInfo> findList(Map<String, String> params);
}
