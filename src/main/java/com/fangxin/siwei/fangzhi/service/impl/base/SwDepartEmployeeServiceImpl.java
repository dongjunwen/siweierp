package com.fangxin.siwei.fangzhi.service.impl.base;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.MD5Util;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.mapper.SwDepartEmployeeMapper;
import com.fangxin.siwei.fangzhi.mapper.SwDepartInfoMapper;
import com.fangxin.siwei.fangzhi.modal.SwDepartEmployee;
import com.fangxin.siwei.fangzhi.modal.SwDepartInfo;
import com.fangxin.siwei.fangzhi.modal.SysUser;
import com.fangxin.siwei.fangzhi.service.base.SwDepartEmployeeService;
import com.fangxin.siwei.fangzhi.vo.base.SwDepartEmployeeVo;
import com.fangxin.siwei.fangzhi.vo.result.SysDepartEmployeeResultVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/12/25 0025 17:28
 * @Author lu.dong
 * @Description：
 **/
public class SwDepartEmployeeServiceImpl implements SwDepartEmployeeService {

    @Autowired
    SwDepartEmployeeMapper swDepartEmployeeMapper;
    @Resource
    SwDepartInfoMapper swDepartInfoMapper;

    @Override
    public Result<Integer> create(SwDepartEmployeeVo swDepartEmployeeVo) {
        SwDepartEmployee _swDepartEmployee=swDepartEmployeeMapper.selectByUserNoAndDepartNo(swDepartEmployeeVo.getUserNo(),swDepartEmployeeVo.getDepartNo());
        if(_swDepartEmployee!=null){
            return  Result.newError(ResultCode.COMMON_DATA_EXISTS.getCode(),"这个部门里已经有这个员工了!");
        }
        SwDepartEmployee swDepartEmployee=new SwDepartEmployee();
        swDepartEmployee.setUserNo(swDepartEmployeeVo.getUserNo());
        swDepartEmployee.setDepartNo(swDepartEmployeeVo.getDepartNo());
        swDepartEmployee.setCreateNo(ShiroUtils.getCurrentUserNo());
        swDepartEmployee.setCreateTime(new Date());
        swDepartEmployee.setModiNo(ShiroUtils.getCurrentUserNo());
        swDepartEmployee.setModiTime(new Date());
        swDepartEmployee.setVersion(0);
        return Result.newSuccess(swDepartEmployeeMapper.insertSelective(swDepartEmployee));
    }

    @Override
    public Result<Integer> delete(String id) {
        return Result.newSuccess(swDepartEmployeeMapper.deleteByPrimaryKey(Integer.valueOf(id)));
    }

    @Override
    public List<SysDepartEmployeeResultVo> getEntityByUserNo(String userNo) {
        List<SwDepartEmployee> swDepartEmployees=swDepartEmployeeMapper.selectByUserNo(userNo);
        List<SysDepartEmployeeResultVo> sysDepartEmployeeResultVos=new ArrayList<>();
        for(SwDepartEmployee swDepartEmployee:swDepartEmployees){
            SysDepartEmployeeResultVo sysDepartEmployeeResultVo=new SysDepartEmployeeResultVo();
            sysDepartEmployeeResultVo.setId(swDepartEmployee.getId());
            sysDepartEmployeeResultVo.setDepartNo(swDepartEmployee.getDepartNo());
            sysDepartEmployeeResultVo.setUserNo(swDepartEmployee.getUserNo());
            SwDepartInfo swDepartInfo=swDepartInfoMapper.selectByDepartNo(swDepartEmployee.getDepartNo());
            sysDepartEmployeeResultVo.setDepartName(swDepartInfo.getDepartName());
            sysDepartEmployeeResultVos.add(sysDepartEmployeeResultVo);
        }
        return sysDepartEmployeeResultVos;
    }
}
