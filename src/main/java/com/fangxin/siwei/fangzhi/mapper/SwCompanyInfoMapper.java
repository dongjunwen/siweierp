package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwCompanyInfo;

public interface SwCompanyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwCompanyInfo record);

    int insertSelective(SwCompanyInfo record);

    SwCompanyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwCompanyInfo record);

    int updateByPrimaryKey(SwCompanyInfo record);
}