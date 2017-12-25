package com.fangxin.siwei.fangzhi.controller.base;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.modal.SwDepartInfo;
import com.fangxin.siwei.fangzhi.service.base.SwDepartInfoService;
import com.fangxin.siwei.fangzhi.vo.base.SwDepartInfoVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Date:2017/10/20 0020 14:08
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/depart")
@Api(tags = "基础资料",description = "部门相关api")
public class SwDepartInfoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwDepartInfoService swDepartInfoService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建部门", notes="根据部门对象创建部门")
    @ApiParam(name = "swDepartInfoVo", value = "部门信息实体 swDepartInfoVo", required = true)
    public Result<String> create( @RequestBody SwDepartInfoVo swDepartInfoVo){
        ValidatorUtil.validateEntity(swDepartInfoVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= swDepartInfoService.create(swDepartInfoVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加部门成功");
        }catch (Exception e){
            logger.error("添加部门异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新部门详细信息", notes="根据url的部门编号来指定更新对象，并根据传过来的部门信息来更新部门详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SwDepartInfoVo swDepartInfoVo){
        try {
            Result<Integer> _result =  swDepartInfoService.update(swDepartInfoVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改部门成功");
        } catch (Exception e) {
            logger.error("修改部门异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{departNo}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除部门", notes="根据url的compNo来指定删除对象")
    @ApiImplicitParam(name = "departNo", value = "部门编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delUser(@PathVariable("departNo")String departNo){
        try {
            Result<Integer> _result =     swDepartInfoService.delete(departNo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("删除部门成功");
        }catch (Exception e){
            logger.error("删除部门异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{departNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取部门详细信息", notes="根据url的departNo来获取部门详细信息")
    @ApiImplicitParam(name = "departNo", value = "部门编号", required = true, dataType = "string",paramType = "path")
    public Result<SwDepartInfo> getUserById(@PathVariable("departNo") String departNo){
        SwDepartInfo swDepartInfo = swDepartInfoService.getEntityByNo(departNo);
        return Result.newSuccess(swDepartInfo);
    }

    @ApiOperation(value = "部门列表")
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
    public Result<PageUitls<SwDepartInfo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwDepartInfo> page =  swDepartInfoService.findList(params);
        return Result.newSuccess(new PageUitls<SwDepartInfo>(page));
    }
}
