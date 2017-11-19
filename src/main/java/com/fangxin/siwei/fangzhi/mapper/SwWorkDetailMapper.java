package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwWorkDetail;
import com.fangxin.siwei.fangzhi.modal.TmpWorkDetail;

import java.util.List;

public interface SwWorkDetailMapper extends MyMapper<SwWorkDetail> {
    void insertBatch(List<SwWorkDetail> swWorkDetails);
}