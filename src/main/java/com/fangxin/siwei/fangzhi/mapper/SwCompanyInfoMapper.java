package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SwCompanyInfo;

public interface SwCompanyInfoMapper extends MyMapper<SwCompanyInfo> {
    int deleteByPrimaryKey(Integer id);

    int insert(SwCompanyInfo record);

    int insertSelective(SwCompanyInfo record);

    SwCompanyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwCompanyInfo record);

    int updateByPrimaryKey(SwCompanyInfo record);

    int updateByCompNo(SwCompanyInfo swCompanyInfo);

    SwCompanyInfo selectByCompNo(String compNo);
}