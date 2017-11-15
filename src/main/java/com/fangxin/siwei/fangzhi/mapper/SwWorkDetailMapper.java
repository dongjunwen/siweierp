package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwWorkDetail;

public interface SwWorkDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwWorkDetail record);

    int insertSelective(SwWorkDetail record);

    SwWorkDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwWorkDetail record);

    int updateByPrimaryKey(SwWorkDetail record);
}