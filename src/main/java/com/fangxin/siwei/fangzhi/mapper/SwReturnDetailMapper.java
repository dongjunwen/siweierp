package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwReturnDetail;

import java.util.List;

public interface SwReturnDetailMapper extends MyMapper<SwReturnDetail> {


    void insertBatch(List swOrderDetails);

    List<SwReturnDetail> selectByReturnNo(String orderNo);

    void updateBatch(List swOrderDetails);
}