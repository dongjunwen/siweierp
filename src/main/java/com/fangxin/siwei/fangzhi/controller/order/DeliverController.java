package com.fangxin.siwei.fangzhi.controller.order;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.service.order.SwDeliverService;
import com.fangxin.siwei.fangzhi.vo.order.SwDeliverAuditVo;
import com.fangxin.siwei.fangzhi.vo.result.SwDeliverBaseResutVo;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderAuditVo;
import com.fangxin.siwei.fangzhi.vo.order.SwDeliverVo;
import com.fangxin.siwei.fangzhi.vo.result.SwDeliverResultVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Date:2017/10/20 0020 9:47
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/deliver")
@Api(tags = "业务发货单",description = "业务发货单相关API")
public class DeliverController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwDeliverService swDeliverService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建发货单", notes="根据发货单对象创建发货单")
    //@ApiImplicitParam(name = "swDeliverVo", value = "发货单信息实体 swDeliverVo",dataTypeClass = SysDictVo.class)
    public Result<String> create(@ApiParam(name = "swDeliverVo", value = "发货单信息实体 swDeliverVo", required = true) @RequestBody SwDeliverVo swDeliverVo){
        ValidatorUtil.validateEntity(swDeliverVo, AddGroup.class);//校验
        ValidatorUtil.validateEntity(swDeliverVo.getSwDeliverBaseVo(), AddGroup.class);//校验
        try{
            Result<Integer> _result= swDeliverService.create(swDeliverVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加发货单成功");
        }catch (Exception e){
            logger.error("添加发货单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @ApiOperation(value = "发货单列表")
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
    public Result<PageUitls<SwDeliverBaseResutVo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwDeliverBaseResutVo> page =  swDeliverService.findList(params);
        return Result.newSuccess(new PageUitls<SwDeliverBaseResutVo>(page));
    }


    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @ApiOperation(value="审核发货单", notes="初审、终审接口")
    //@ApiImplicitParam(name = "swDeliverVo", value = "发货单信息实体 swDeliverVo",dataTypeClass = SysDictVo.class)
    public Result<String> audit(@ApiParam(name = "swOrderAuditVo", value = "发货单审核 swOrderAuditVo", required = true) @RequestBody SwDeliverAuditVo swDeliverAuditVo){
        ValidatorUtil.validateEntity(swDeliverAuditVo, AddGroup.class);//校验
        try{
            swDeliverAuditVo.setAuditUserNo(ShiroUtils.getCurrentUserNo());
            swDeliverAuditVo.setAuditUserName(ShiroUtils.getCurrentUserName());
            Result<Integer> _result= swDeliverService.audit(swDeliverAuditVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("审核发货单成功");
        }catch (Exception e){
            logger.error("审核发货单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @RequestMapping(value = "/{deilverNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取发货单详细信息", notes="根据url的编号来获取业务发货单详细信息")
    @ApiImplicitParam(name = "deilverNo", value = "发货单编号", required = true, dataType = "string",paramType = "path")
    public Result<SwDeliverResultVo> getUserById(@PathVariable("deilverNo")String deilverNo){
        SwDeliverResultVo swDeliverResultVo = swDeliverService.getEntityByNo(deilverNo);
        return Result.newSuccess(swDeliverResultVo);
    }
}
