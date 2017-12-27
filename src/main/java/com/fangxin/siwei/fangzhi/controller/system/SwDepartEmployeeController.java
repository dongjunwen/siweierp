package com.fangxin.siwei.fangzhi.controller.system;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.service.base.SwDepartEmployeeService;
import com.fangxin.siwei.fangzhi.vo.base.SwDepartEmployeeVo;
import com.fangxin.siwei.fangzhi.vo.result.SysDepartEmployeeResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SysUserRoleResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date:2017/10/20 0020 14:08
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/departEmployee")
@Api(tags = "部门员工",description = "部门员工相关api")
public class SwDepartEmployeeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwDepartEmployeeService swDepartEmployeeService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建部门员工", notes="根据部门员工对象创建部门员工")
    @ApiParam(name = "swDepartEmployeeVo", value = "部门员工信息实体 swDepartEmployeeVo", required = true)
    public Result<String> create(@RequestBody SwDepartEmployeeVo swDepartEmployeeVo){
        ValidatorUtil.validateEntity(swDepartEmployeeVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= swDepartEmployeeService.create(swDepartEmployeeVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加部门员工成功");
        }catch (Exception e){
            logger.error("添加部门员工异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除部门员工", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "部门员工编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delete(@PathVariable("id")String id){
        try {
            Result<Integer> _result =     swDepartEmployeeService.delete(id);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("删除部门员工成功");
        }catch (Exception e){
            logger.error("删除部门员工异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }



    @RequestMapping(value = "/{userNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取部门员工详细信息", notes="根据url的userNo来获取部门员工详细信息")
    @ApiImplicitParam(name = "userNo", value = "部门员工编号", required = true, dataType = "string",paramType = "path")
    public Result<List<SysDepartEmployeeResultVo>> getEntityByNo(@PathVariable("userNo") String userNo){
        List<SysDepartEmployeeResultVo> sysDepartEmployeeResultVos = swDepartEmployeeService.getEntityByUserNo(userNo);
        return Result.newSuccess(sysDepartEmployeeResultVos);
    }
}
