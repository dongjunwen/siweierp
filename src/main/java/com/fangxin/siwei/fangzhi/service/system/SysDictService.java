package com.fangxin.siwei.fangzhi.service.system;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SysDict;
import com.fangxin.siwei.fangzhi.vo.system.SysDictVo;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map; /**
 * @Date:2017/10/24 0024 13:48
 * @Author lu.dong
 * @Description：
 **/
public interface SysDictService {
    Result<Integer> create(SysDictVo sysDictVo);

    Result<Integer> update(SysDictVo sysDictVo);

    Result<Integer> delete(String dictType,String dictCode);

    SysDict getEntityByNo(String dictType,String dictCode);

    Page<SysDict> findList(Map<String, String> params);

    List<SysDict> getEntityByDictType(String dictType);

    List<SysDict> findAll();
}
