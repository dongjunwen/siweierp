package com.fangxin.siwei.fangzhi.controller.system;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.modal.SysResource;
import com.fangxin.siwei.fangzhi.service.system.SysResourceService;
import com.fangxin.siwei.fangzhi.vo.result.SysResourceResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysResourceVo;
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
@RequestMapping("/api/sysResource")
@Api(tags = "菜单资源",description = "菜单资源相关api")
public class SysResourceController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SysResourceService sysResourceService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建菜单资源", notes="根据菜单资源对象创建菜单资源")
    //@ApiImplicitParam(name = "sysResourceVo", value = "菜单资源信息实体 sysResourceVo",dataTypeClass = SysResourceVo.class)
    public Result<String> create(@ApiParam(name = "sysResourceVo", value = "菜单资源信息实体 sysResourceVo", required = true) @RequestBody SysResourceVo sysResourceVo){
        ValidatorUtil.validateEntity(sysResourceVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= sysResourceService.create(sysResourceVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加菜单资源成功");
        }catch (Exception e){
            logger.error("添加菜单资源异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新菜单资源详细信息", notes="根据url的菜单资源编号来指定更新对象，并根据传过来的菜单资源信息来更新菜单资源详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SysResourceVo sysResourceVo){
        try {
            Result<Integer> _result =  sysResourceService.update(sysResourceVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改菜单资源成功");
        } catch (Exception e) {
            logger.error("修改菜单资源异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{sourceNo}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除菜单资源", notes="根据url的compNo来指定删除对象")
    @ApiImplicitParam(name = "sourceNo", value = "菜单资源编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delete(@PathVariable("sourceNo")String sourceNo){
        try {
            Result<Integer> _result =     sysResourceService.delete(sourceNo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("删除菜单资源成功");
        }catch (Exception e){
            logger.error("删除菜单资源异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{sourceNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取菜单资源详细信息", notes="根据url的sourceNo来获取菜单资源详细信息")
    @ApiImplicitParam(name = "sourceNo", value = "菜单资源编号", required = true, dataType = "string",paramType = "path")
    public Result<SysResource> getEntityByNo(@PathVariable("sourceNo") String sourceNo){
        SysResource sysResource = sysResourceService.getEntityByNo(sourceNo);
        return Result.newSuccess(sysResource);
    }

    @RequestMapping(value = "/currentUser",method = RequestMethod.GET)
    @ApiOperation(value="根据当前用户获取菜单列表", notes="根据当前用户获取菜单列表")
   // @ApiImplicitParam(name = "sourceNo", value = "菜单资源编号", required = true, dataType = "string",paramType = "path")
    public Result<List<SysResourceResultVo>> getListByCurrentUser(){
        List<SysResourceResultVo> sysResourceList = sysResourceService.getListByCurrentUser(ShiroUtils.getCurrentUserNo());
        return Result.newSuccess(sysResourceList);
    }


    @ApiOperation(value = "菜单资源列表")
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
    public Result<PageUitls<SysResource>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SysResource> page =  sysResourceService.findList(params);
        return Result.newSuccess(new PageUitls<SysResource>(page));
    }
}
