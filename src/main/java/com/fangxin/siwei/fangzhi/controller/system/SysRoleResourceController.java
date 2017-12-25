package com.fangxin.siwei.fangzhi.controller.system;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.modal.SysResource;
import com.fangxin.siwei.fangzhi.modal.SysRoleResource;
import com.fangxin.siwei.fangzhi.service.system.SysRoleResourceService;
import com.fangxin.siwei.fangzhi.vo.result.SysRoleResourceResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysRoleResourceVo;
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
 * @Date:2017/10/20 0020 14:03
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/sysRoleResource")
@Api(tags = "角色资源",description = "角色资源相关api")
public class SysRoleResourceController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SysRoleResourceService sysRoleResourceService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建角色资源", notes="根据角色资源对象创建角色资源")
    @ApiParam(name = "sysRoleResourceVo", value = "角色资源信息实体 sysRoleResourceVo", required = true)
    public Result<String> create(@RequestBody SysRoleResourceVo sysRoleResourceVo){
        ValidatorUtil.validateEntity(sysRoleResourceVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= sysRoleResourceService.create(sysRoleResourceVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加角色资源成功");
        }catch (Exception e){
            logger.error("添加角色资源异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除角色资源", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "角色资源编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delete(@PathVariable("id")String id){
        try {
            Result<Integer> _result =     sysRoleResourceService.delete(id);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("删除角色资源成功");
        }catch (Exception e){
            logger.error("删除角色资源异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value="批量删除角色资源", notes="根据url的ids来指定删除对象")
    @ApiImplicitParam(name = "ids", value = "角色资源编号", required = true, dataType = "string",paramType = "path")
    public Result<String> deleteByIds(@PathVariable("ids")String ids){
        try {
            Result<Integer> _result =     sysRoleResourceService.deleteByIds(ids);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("批量删除角色资源成功");
        }catch (Exception e){
            logger.error("批量删除角色资源异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{roleCode}",method = RequestMethod.GET)
    @ApiOperation(value="获取角色资源详细信息", notes="根据url的roleCode来获取角色资源详细信息")
    @ApiImplicitParam(name = "roleCode", value = "角色资源编号", required = true, dataType = "string",paramType = "path")
    public Result<List<SysRoleResourceResultVo>> getEntityByNo(@PathVariable("roleCode") String roleCode){
        List<SysRoleResourceResultVo> sysResources = sysRoleResourceService.getEntityByRoleCode(roleCode);
        return Result.newSuccess(sysResources);
    }


}
