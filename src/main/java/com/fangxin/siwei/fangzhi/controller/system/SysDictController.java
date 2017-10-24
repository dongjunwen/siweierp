package com.fangxin.siwei.fangzhi.controller.system;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.modal.SysDict;
import com.fangxin.siwei.fangzhi.service.system.SysDictService;
import com.fangxin.siwei.fangzhi.vo.system.SysDictVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/10/20 0020 14:04
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/sysDict")
@Api(tags = "数据字典",description = "数据字典相关api")
public class SysDictController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SysDictService sysDictService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建数据字典", notes="根据数据字典对象创建数据字典")
    //@ApiImplicitParam(name = "sysDictVo", value = "数据字典信息实体 sysDictVo",dataTypeClass = SysDictVo.class)
    public Result<String> create(@ApiParam(name = "sysDictVo", value = "数据字典信息实体 sysDictVo", required = true) @RequestBody SysDictVo sysDictVo){
        ValidatorUtil.validateEntity(sysDictVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= sysDictService.create(sysDictVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加数据字典成功");
        }catch (Exception e){
            logger.error("添加数据字典异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新数据字典详细信息", notes="根据url的数据字典编号来指定更新对象，并根据传过来的数据字典信息来更新数据字典详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SysDictVo sysDictVo){
        try {
            Result<Integer> _result =  sysDictService.update(sysDictVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改数据字典成功");
        } catch (Exception e) {
            logger.error("修改数据字典异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/delDictByUniq",method = RequestMethod.POST)
    @ApiOperation(value="删除数据字典", notes="根据url的来指定删除对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictType", value = "数据字典类型", required = true, dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "dictCode", value = "数据字典编号", required = true, dataType = "string",paramType = "query")
    })
    public Result<String> delete(@RequestParam("dictType") String dictType,@RequestParam("dictCode")String dictCode){
        try {
            Result<Integer> _result =     sysDictService.delete(dictType,dictCode);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("删除数据字典成功");
        }catch (Exception e){
            logger.error("删除数据字典异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{dictType}",method = RequestMethod.GET)
    @ApiOperation(value="获取数据字典详细信息", notes="根据url的sourceNo来获取数据字典详细信息")
    @ApiImplicitParam(name = "dictType", value = "数据字典类型", required = true, dataType = "string",paramType = "path")
    public Result< List<SysDict>> getEntityByType(@PathVariable("dictType") String dictType){
        List<SysDict> sysDictList = sysDictService.getEntityByDictType(dictType);
        return Result.newSuccess(sysDictList);
    }

    @RequestMapping(value = "/getDictByUniq",method = RequestMethod.POST)
    @ApiOperation(value="获取数据字典详细信息", notes="根据url的sourceNo来获取数据字典详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictType", value = "数据字典类型", required = true, dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "dictCode", value = "数据字典编号", required = true, dataType = "string",paramType = "query")
    })
    public Result<SysDict> getEntityByNo(@RequestParam("dictType") String dictType,@RequestParam("dictCode")String dictCode){
        SysDict sysResource = sysDictService.getEntityByNo(dictType,dictCode);
        return Result.newSuccess(sysResource);
    }

    @ApiOperation(value = "数据字典列表")
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
    public Result<PageUitls<SysDict>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SysDict> page =  sysDictService.findList(params);
        return Result.newSuccess(new PageUitls<SysDict>(page));
    }
}
