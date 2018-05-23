package com.fangxin.siwei.fangzhi.service.base;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.base.SwDepartEmployeeVo;
import com.fangxin.siwei.fangzhi.vo.result.SysDepartEmployeeResultVo;

import java.util.List;

/**
 * @Date:2017/12/25 0025 17:22
 * @Author lu.dong
 * @Description：
 **/
public interface SwDepartEmployeeService {
    Result<Integer> create(SwDepartEmployeeVo swDepartEmployeeVo);

    Result<Integer> delete(String id);

    List<SysDepartEmployeeResultVo> getEntityByUserNo(String userNo);

    void deleteByUserNo(String userNo);
}
