package com.fangxin.siwei.fangzhi.controller.system;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.modal.SwMaterialInfo;
import com.fangxin.siwei.fangzhi.modal.SysRole;
import com.fangxin.siwei.fangzhi.service.system.SysRoleService;
import com.fangxin.siwei.fangzhi.vo.system.SysRoleVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/20 0020 14:03
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/sysRole")
@Api(tags = "角色",description = "角色相关api")
public class SysRoleController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SysRoleService sysRoleService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建角色", notes="根据角色对象创建角色")
    @ApiParam(name = "sysRoleVo", value = "角色信息实体 sysRoleVo", required = true)
    public Result<String> create( @RequestBody SysRoleVo sysRoleVo){
        ValidatorUtil.validateEntity(sysRoleVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= sysRoleService.create(sysRoleVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加角色成功");
        }catch (Exception e){
            logger.error("添加角色异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新角色详细信息", notes="根据url的角色编号来指定更新对象，并根据传过来的角色信息来更新角色详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SysRoleVo sysRoleVo){
        try {
            Result<Integer> _result =  sysRoleService.update(sysRoleVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改角色成功");
        } catch (Exception e) {
            logger.error("修改角色异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{roleCode}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除角色", notes="根据url的compNo来指定删除对象")
    @ApiImplicitParam(name = "roleCode", value = "角色编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delete(@PathVariable("roleCode")String roleCode){
        try {
            Result<Integer> _result =     sysRoleService.delete(roleCode);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("删除角色成功");
        }catch (Exception e){
            logger.error("删除角色异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/findRoleLike/{condStr}",method = RequestMethod.GET)
    @ApiOperation(value="根据条件模糊匹配角色v列表", notes="根据查询条件模糊匹配角色列表")
    @ApiImplicitParam(name = "condStr", value = "查询条件", required = true, dataType = "string",paramType = "path")
    public Result<List<SysRole>> findMaterialLike(@PathVariable("condStr") String condStr){
        List<SysRole> sysRoles = sysRoleService.findRoleLike(condStr);
        return Result.newSuccess(sysRoles);
    }

    @RequestMapping(value = "/{roleCode}",method = RequestMethod.GET)
    @ApiOperation(value="获取角色详细信息", notes="根据url的roleCode来获取角色详细信息")
    @ApiImplicitParam(name = "roleCode", value = "角色编号", required = true, dataType = "string",paramType = "path")
    public Result<SysRole> getEntityByNo(@PathVariable("roleCode") String roleCode){
        SysRole sysRole = sysRoleService.getEntityByNo(roleCode);
        return Result.newSuccess(sysRole);
    }

    @ApiOperation(value = "角色列表")
    @RequestMapping(method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currPage",value = "当前页",paramType = "query"),
            @ApiImplicitParam(name = "sort",value = "排序 ASC 或 DESC",required = false,example = "asc/desc",paramType = "query"),
            @ApiImplicitParam(name = "orderBy",value = "排序字段",required = false,example = "createdTime",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示条数",required = false,example = "createdTime",paramType = "query"),
            //@ApiImplicitParam(name = "startTime",value = "开始时间",dataType = "long",paramType = "query"),如果时间类型则可以打开
            //@ApiImplicitParam(name = "endTime",value = "结束时间",dataType = "long",paramType = "query"),
            @ApiImplicitParam(name = "filter",value = "通用表过滤器。发送JSON键/值对，如<code>{“key”:“value”}</code>。", paramType = "query",dataTypeClass = JSON.class)

    })
    public Result<PageUitls<SysRole>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SysRole> page =  sysRoleService.findList(params);
        return Result.newSuccess(new PageUitls<SysRole>(page));
    }
}
