package com.fangxin.siwei.fangzhi.mapper;

import com.fangxin.siwei.fangzhi.common.utils.MyMapper;
import com.fangxin.siwei.fangzhi.modal.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictMapper extends MyMapper<SysDict> {

    SysDict selectByUniqNo(@Param("dictType") String dictType, @Param("dictCode")String dictCode);

    List<SysDict> selectByDictType(String dictType);

    List<SysDict> findAll();
}