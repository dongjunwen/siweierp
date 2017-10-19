package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.modal.SwDepartEmployee;

public interface SwDepartEmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SwDepartEmployee record);

    int insertSelective(SwDepartEmployee record);

    SwDepartEmployee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwDepartEmployee record);

    int updateByPrimaryKey(SwDepartEmployee record);
}