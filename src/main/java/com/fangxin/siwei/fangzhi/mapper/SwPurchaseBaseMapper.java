package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwOrderBase;
import com.fangxin.siwei.fangzhi.modal.SwPurchaseBase;

public interface SwPurchaseBaseMapper  extends MyMapper<SwPurchaseBase>{

    void updateByPurNo(SwOrderBase swOrderBase);

    SwPurchaseBase selectByPurNo(String orderNo);
}