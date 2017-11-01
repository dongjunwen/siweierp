package com.fangxin.siwei.fangzhi.service.impl.purchase;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SwPurchaseBase;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.purchase.PurchaseService;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderAuditVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderResultVo;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Date:2017/11/1 0001 15:11
 * @Author lu.dong
 * @Description：
 **/
@Service
public class PurchaseServiceImpl extends AbstractService<SwPurchaseBase> implements PurchaseService {
    @Override
    public Result<Integer> create(SwPurOrderVo swPurOrderVo) {
        return null;
    }

    @Override
    public Page<SwPurOrderBaseResultVo> findList(Map<String, String> params) {
        return null;
    }

    @Override
    public Result<Integer> audit(SwOrderAuditVo swOrderAuditVo) {
        return null;
    }

    @Override
    public SwPurOrderResultVo getEntityByNo(String orderNo) {
        return null;
    }
}
