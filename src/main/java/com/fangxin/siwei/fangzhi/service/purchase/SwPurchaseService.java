package com.fangxin.siwei.fangzhi.service.purchase;


import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderAuditVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurAuditVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderModiVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderVo;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderResultVo;
import com.github.pagehelper.Page;

import java.util.Map; /**
 * @Date:2017/11/1 0001 13:41
 * @Author lu.dong
 * @Description：
 **/
public interface SwPurchaseService {
    Result<Integer> create(SwPurOrderVo swPurOrderVo);

    Page<SwPurOrderBaseResultVo> findList(Map<String, String> params);

    Result<Integer> audit(SwPurAuditVo swPurAuditVo);

    SwPurOrderResultVo getEntityByNo(String orderNo);

    Result<Integer> update(SwPurOrderModiVo swPurOrderModiVo);
}
