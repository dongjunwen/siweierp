package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.TmpWorkDetail;
import com.fangxin.siwei.fangzhi.vo.produce.SwWorkDetailVo;

import java.util.List;

public interface TmpWorkDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TmpWorkDetail record);

    int insertSelective(TmpWorkDetail record);

    TmpWorkDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmpWorkDetail record);

    int updateByPrimaryKey(TmpWorkDetail record);

    int insertBatch(List<TmpWorkDetail> tmpWorkDetails);
}