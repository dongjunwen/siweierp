package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwWorkDetail;
import com.fangxin.siwei.fangzhi.modal.TmpWorkDetail;

import java.util.List;
import java.util.Map;

public interface SwWorkDetailMapper extends MyMapper<SwWorkDetail> {
    void insertBatch(List<SwWorkDetail> swWorkDetails);

    List<SwWorkDetail> selectByCond(Map<String, String> params);
}