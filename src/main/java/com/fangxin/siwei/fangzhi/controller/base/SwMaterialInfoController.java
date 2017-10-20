package com.fangxin.siwei.fangzhi.controller.base;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.modal.SwMaterialInfo;
import com.fangxin.siwei.fangzhi.service.base.SwMaterialInfoService;
import com.fangxin.siwei.fangzhi.service.base.SwMaterialInfoService;
import com.fangxin.siwei.fangzhi.vo.SwMaterialInfoVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Date:2017/10/20 0020 14:07
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/material")
@Api(tags = "基础资料",description = "物料相关api")
public class SwMaterialInfoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwMaterialInfoService swMaterialInfoService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建物料", notes="根据物料对象创建物料")
    //@ApiImplicitParam(name = "swMaterialInfoVo", value = "物料信息实体 swMaterialInfoVo",dataTypeClass = SwMaterialInfoVo.class)
    public Result<String> create(@ApiParam(name = "swMaterialInfoVo", value = "物料信息实体 swMaterialInfoVo", required = true) @RequestBody SwMaterialInfoVo swMaterialInfoVo){
        ValidatorUtil.validateEntity(swMaterialInfoVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= swMaterialInfoService.create(swMaterialInfoVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加物料成功");
        }catch (Exception e){
            logger.error("添加物料异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新物料详细信息", notes="根据url的物料编号来指定更新对象，并根据传过来的物料信息来更新物料详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SwMaterialInfoVo swMaterialInfoVo){
        try {
            Result<Integer> _result =  swMaterialInfoService.update(swMaterialInfoVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改物料成功");
        } catch (Exception e) {
            logger.error("修改物料异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{materialNo}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除物料", notes="根据url的materialNo来指定删除对象")
    @ApiImplicitParam(name = "materialNo", value = "物料编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delUser(@PathVariable("materialNo")String materialNo){
        try {
            Result<Integer> _result =     swMaterialInfoService.delete(materialNo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("删除成功");
        }catch (Exception e){
            logger.error("删除异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{materialNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取物料详细信息", notes="根据url的materialNo来获取物料详细信息")
    @ApiImplicitParam(name = "materialNo", value = "物料编号", required = true, dataType = "string",paramType = "path")
    public Result<SwMaterialInfo> getUserById(@PathVariable("materialNo") String materialNo){
        SwMaterialInfo swMaterialInfo = swMaterialInfoService.getEntityByNo(materialNo);
        return Result.newSuccess(swMaterialInfo);
    }

    @ApiOperation(value = "物料列表")
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
    public Result<PageUitls<SwMaterialInfo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwMaterialInfo> page =  swMaterialInfoService.findList(params);
        return Result.newSuccess(new PageUitls<SwMaterialInfo>(page));
    }
}
