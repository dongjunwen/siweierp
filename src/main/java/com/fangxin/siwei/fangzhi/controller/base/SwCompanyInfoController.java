package com.fangxin.siwei.fangzhi.controller.base;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.modal.SwCompanyInfo;
import com.fangxin.siwei.fangzhi.service.base.SwCompanyInfoService;
import com.fangxin.siwei.fangzhi.vo.base.SwCompInfoVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Date:2017/10/20 0020 14:06
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/comp")
@Api(tags = "基础资料",description = "公司相关api")
public class SwCompanyInfoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwCompanyInfoService swCompanyInfoService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建公司", notes="根据公司对象创建公司")
    //@ApiImplicitParam(name = "swCompInfoVo", value = "公司信息实体 swCompInfoVo",dataTypeClass = SwCompInfoVo.class)
    public Result<String> create(@ApiParam(name = "swCompInfoVo", value = "公司信息实体 swCompInfoVo", required = true) @RequestBody SwCompInfoVo swCompInfoVo){
        ValidatorUtil.validateEntity(swCompInfoVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= swCompanyInfoService.create(swCompInfoVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加公司成功");
        }catch (Exception e){
            logger.error("添加公司异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新公司详细信息", notes="根据url的公司编号来指定更新对象，并根据传过来的公司信息来更新公司详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SwCompInfoVo swCompInfoVo){
        try {
            Result<Integer> _result =  swCompanyInfoService.update(swCompInfoVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改公司成功");
        } catch (Exception e) {
            logger.error("修改公司异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{compNo}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除公司", notes="根据url的compNo来指定删除对象")
    @ApiImplicitParam(name = "compNo", value = "公司编号", required = true, dataType = "string",paramType = "path")
    public Result<String> delUser(@PathVariable("compNo")String compNo){
        try {
            Result<Integer> _result =     swCompanyInfoService.delete(compNo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("删除公司成功");
        }catch (Exception e){
            logger.error("删除公司异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/{compNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取公司详细信息", notes="根据url的compNo来获取公司详细信息")
    @ApiImplicitParam(name = "compNo", value = "公司编号", required = true, dataType = "string",paramType = "path")
    public Result<SwCompanyInfo> getUserById(@PathVariable("compNo") String compNo){
        SwCompanyInfo swCompanyInfo = swCompanyInfoService.getEntityByNo(compNo);
        return Result.newSuccess(swCompanyInfo);
    }

    @ApiOperation(value = "公司列表")
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
    public Result<PageUitls<SwCompanyInfo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwCompanyInfo> page =  swCompanyInfoService.findList(params);
        return Result.newSuccess(new PageUitls<SwCompanyInfo>(page));
    }
}
