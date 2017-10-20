package com.fangxin.siwei.fangzhi.controller.base;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.modal.SwCompanyInfo;
import com.fangxin.siwei.fangzhi.modal.SwFormularInfo;
import com.fangxin.siwei.fangzhi.service.base.SwCompanyInfoService;
import com.fangxin.siwei.fangzhi.service.base.SwFormularInfoService;
import com.fangxin.siwei.fangzhi.vo.SwCompInfoVo;
import com.fangxin.siwei.fangzhi.vo.SwFormularInfoVo;
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
@RequestMapping("/api/formular")
@Api(tags = "基础资料",description = "公式相关api")
public class SwFormularInfoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwFormularInfoService swFormularInfoService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建公式", notes="根据公式对象创建公式")
    //@ApiImplicitParam(name = "swFormularInfoVo", value = "公式信息实体 swFormularInfoVo",dataTypeClass = SwFormularInfoVo.class)
    public Result<String> create(@ApiParam(name = "swFormularInfoVo", value = "公式信息实体 swFormularInfoVo", required = true) @RequestBody SwFormularInfoVo swFormularInfoVo){
        ValidatorUtil.validateEntity(swFormularInfoVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= swFormularInfoService.create(swFormularInfoVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加公式成功");
        }catch (Exception e){
            logger.error("添加公式异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新公式详细信息", notes="根据url的公式编号来指定更新对象，并根据传过来的公式信息来更新公式详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SwFormularInfoVo swFormularInfoVo){
        try {
            Result<Integer> _result =  swFormularInfoService.update(swFormularInfoVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改公式成功");
        } catch (Exception e) {
            logger.error("修改公式异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{formularNo}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除公式", notes="根据url的formularNo来指定删除对象")
    @ApiImplicitParam(name = "formularNo", value = "公式编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delUser(@PathVariable("formularNo")String formularNo){
        try {
            Result<Integer> _result =     swFormularInfoService.delete(formularNo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("删除公式成功");
        }catch (Exception e){
            logger.error("删除公式异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{formularNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取公式详细信息", notes="根据url的compNo来获取公式详细信息")
    @ApiImplicitParam(name = "formularNo", value = "公式编号", required = true, dataType = "string",paramType = "path")
    public Result<SwFormularInfo> getUserById(@PathVariable("formularNo") String formularNo){
        SwFormularInfo swFormularInfo = swFormularInfoService.getEntityByNo(formularNo);
        return Result.newSuccess(swFormularInfo);
    }

    @ApiOperation(value = "公式列表")
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
    public Result<PageUitls<SwFormularInfo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwFormularInfo> page =  swFormularInfoService.findList(params);
        return Result.newSuccess(new PageUitls<SwFormularInfo>(page));
    }
}
