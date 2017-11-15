package com.fangxin.siwei.fangzhi.controller.produce;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.service.produce.SwReceiveService;
import com.fangxin.siwei.fangzhi.vo.produce.SwReceiveAuditVo;
import com.fangxin.siwei.fangzhi.vo.produce.SwReceiveModiVo;
import com.fangxin.siwei.fangzhi.vo.produce.SwReceiveVo;
import com.fangxin.siwei.fangzhi.vo.result.SwReceiveBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwReceiveResultVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Date:2017/11/6 0006 20:45
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/receive")
@Api(tags = "领料单",description = "领料单相关API")
public class ReceiveController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwReceiveService receiveService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建领料单", notes="根据领料单对象创建领料单")
    //@ApiImplicitParam(name = "swPurOrderVo", value = "领料单信息实体 swPurOrderVo",dataTypeClass = SysDictVo.class)
    public Result<String> create(@ApiParam(name = "swReceiveVo", value = "领料单信息实体 swReceiveVo", required = true) @RequestBody SwReceiveVo swReceiveVo){
        ValidatorUtil.validateEntity(swReceiveVo, AddGroup.class);//校验
        ValidatorUtil.validateEntity(swReceiveVo.getSwReceiveBaseVo(), AddGroup.class);//校验
        try{
            Result<Integer> _result= receiveService.create(swReceiveVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加领料单成功");
        }catch (Exception e){
            logger.error("添加领料单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @ApiOperation(value="更新领料单详细信息", notes="根据url的领料单编号来指定更新对象，并根据传过来的领料单信息来更新领料单详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SwReceiveModiVo swReceiveModiVo){
        try {
            Result<Integer> _result =  receiveService.update(swReceiveModiVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改领料单成功");
        } catch (Exception e) {
            logger.error("修改领料单异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @ApiOperation(value = "领料单列表")
    @RequestMapping(method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currPage",value = "当前页",paramType = "query"),
            @ApiImplicitParam(name = "sort",value = "排序 ASC 或 DESC",required = false,example = "asc/desc",paramType = "query"),
            @ApiImplicitParam(name = "orderBy",value = "排序字段",required = false,example = "createdTime",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示条数",required = false,example = "createdTime",paramType = "query"),
            @ApiImplicitParam(name = "startTime",value = "开始时间 YYYY-MM-DD格式",required = false,dataType = "string",paramType = "query"),//如果时间类型则可以打开
            @ApiImplicitParam(name = "endTime",value = "结束时间 YYYY-MM-DD格式",required = false,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "filter",value = "通用表过滤器。发送JSON键/值对，如<code>{“key”:“value”}</code>。", paramType = "query",dataTypeClass = JSON.class)

    })
    public Result<PageUitls<SwReceiveBaseResultVo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwReceiveBaseResultVo> page =  receiveService.findList(params);
        return Result.newSuccess(new PageUitls<SwReceiveBaseResultVo>(page));
    }


    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @ApiOperation(value="审核领料单", notes="初审、终审接口")
    public Result<String> audit(@ApiParam(name = "swReceiveAuditVo", value = "审核领料单 swReceiveAuditVo", required = true) @RequestBody SwReceiveAuditVo swReceiveAuditVo){
        ValidatorUtil.validateEntity(swReceiveAuditVo, AddGroup.class);//校验
        try{
            swReceiveAuditVo.setAuditUserNo(ShiroUtils.getCurrentUserNo());
            swReceiveAuditVo.setAuditUserName(ShiroUtils.getCurrentUserName());
            Result<Integer> _result= receiveService.audit(swReceiveAuditVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("审核领料单成功");
        }catch (Exception e){
            logger.error("审核领料单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @RequestMapping(value = "/{receiveNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取领料单详细信息", notes="根据url的用户编号来获取领料单详细信息")
    @ApiImplicitParam(name = "receiveNo", value = "领料单编号", required = true, dataType = "string",paramType = "path")
    public Result<SwReceiveResultVo> getUserById(@PathVariable("receiveNo")String purNo){
        SwReceiveResultVo swReceiveResultVo = receiveService.getEntityByNo(purNo);
        return Result.newSuccess(swReceiveResultVo);
    }
}
