package com.fangxin.siwei.fangzhi.service.purchase;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.purchase.SwReturnAuditVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwReturnModiVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwReturnVo;
import com.fangxin.siwei.fangzhi.vo.result.SwReturnBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwReturnResultVo;
import com.github.pagehelper.Page;

import java.util.Map; /**
 * @Date:2017/11/6 0006 17:12
 * @Author lu.dong
 * @Description：
 **/
public interface SwReturnService {
    Result<Integer> create(SwReturnVo swReturnVo);

    Result<Integer> update(SwReturnModiVo swReturnModiVo);

    Page<SwReturnBaseResultVo> findList(Map<String, String> params);

    Result<Integer> audit(SwReturnAuditVo swReturnAuditVo);

    SwReturnResultVo getEntityByNo(String returnNo);
}
