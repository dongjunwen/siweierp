package com.fangxin.siwei.fangzhi.service.base;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SwFormularInfo;
import com.fangxin.siwei.fangzhi.vo.base.SwFormularInfoVo;
import com.fangxin.siwei.fangzhi.vo.base.SwLikeVo;
import com.fangxin.siwei.fangzhi.vo.result.SwFormularResultVo;
import com.github.pagehelper.Page;

import java.util.List;
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

    List<SwFormularResultVo> findFormularLike( SwLikeVo swLikeVo);
}
