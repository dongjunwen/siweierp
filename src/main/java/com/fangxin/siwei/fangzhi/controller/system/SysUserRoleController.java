package com.fangxin.siwei.fangzhi.controller.system;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.modal.SysUserRole;
import com.fangxin.siwei.fangzhi.service.system.SysRoleResourceService;
import com.fangxin.siwei.fangzhi.service.system.SysUserRoleService;
import com.fangxin.siwei.fangzhi.vo.result.SysRoleResourceResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SysUserRoleResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysRoleResourceVo;
import com.fangxin.siwei.fangzhi.vo.system.SysUserRoleVo;
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
 * @Date:2017/10/20 0020 14:04
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/sysUserRole")
@Api(tags = "用户角色",description = "用户角色相关api")
public class SysUserRoleController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SysUserRoleService sysUserRoleService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建用户角色", notes="根据用户角色对象创建用户角色")
    @ApiParam(name = "sysUserRoleVo", value = "用户角色信息实体 sysUserRoleVo", required = true)
    public Result<String> create(@RequestBody SysUserRoleVo sysUserRoleVo){
        ValidatorUtil.validateEntity(sysUserRoleVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= sysUserRoleService.create(sysUserRoleVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加用户角色成功");
        }catch (Exception e){
            logger.error("添加用户角色异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除用户角色", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户角色编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delete(@PathVariable("id")String id){
        try {
            Result<Integer> _result =     sysUserRoleService.delete(id);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("删除用户角色成功");
        }catch (Exception e){
            logger.error("删除用户角色异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value="批量删除用户角色", notes="根据url的ids来指定删除对象")
    @ApiImplicitParam(name = "ids", value = "用户角色编号", required = true, dataType = "string",paramType = "path")
    public Result<String> deleteByIds(@PathVariable("ids")String ids){
        try {
            Result<Integer> _result =     sysUserRoleService.deleteByIds(ids);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("批量删除用户角色成功");
        }catch (Exception e){
            logger.error("批量删除用户角色异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{userNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取用户角色详细信息", notes="根据url的userNo来获取用户角色详细信息")
    @ApiImplicitParam(name = "userNo", value = "用户角色编号", required = true, dataType = "string",paramType = "path")
    public Result<List<SysUserRoleResultVo>> getEntityByNo(@PathVariable("userNo") String userNo){
        List<SysUserRoleResultVo> sysUserRoleResultVos = sysUserRoleService.getEntityByUserNo(userNo);
        return Result.newSuccess(sysUserRoleResultVos);
    }

}
