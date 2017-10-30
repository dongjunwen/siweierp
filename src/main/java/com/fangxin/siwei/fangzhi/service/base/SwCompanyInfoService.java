package com.fangxin.siwei.fangzhi.service.base;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SwCompanyInfo;
import com.fangxin.siwei.fangzhi.vo.base.SwCompInfoVo;
import com.fangxin.siwei.fangzhi.vo.result.SwCompInfoResultVo;
import com.github.pagehelper.Page;

import java.util.Map; /**
 * @Date:2017/10/20 0020 14:15
 * @Author lu.dong
 * @Description：
 **/
public interface SwCompanyInfoService {
    Result<Integer> create(SwCompInfoVo swCompInfoVo);

    Result<Integer> update(SwCompInfoVo swCompInfoVo);

    Result<Integer> delete(String compNo);

    SwCompanyInfo getEntityByNo(String compNo);

    Page<SwCompanyInfo> findList(Map<String, String> params);

    SwCompInfoResultVo findCompLike(String condStr);
}
