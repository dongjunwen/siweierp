package com.fangxin.siwei.fangzhi.controller.purchase;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.service.purchase.SwReturnService;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderModiVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwReturnAuditVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwReturnModiVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwReturnVo;
import com.fangxin.siwei.fangzhi.vo.result.SwReturnBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwReturnResultVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Date:2017/10/31 0031 18:09
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/return")
@Api(tags = "退货单",description = "退货单相关API")
public class ReturnController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwReturnService swReturnService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建退货单", notes="根据退货单对象创建退货单")
    //@ApiImplicitParam(name = "swOrderVo", value = "退货单信息实体 swOrderVo",dataTypeClass = SysDictVo.class)
    public Result<String> create(@ApiParam(name = "swReturnVo", value = "退货单信息实体 swReturnVo", required = true) @RequestBody SwReturnVo swReturnVo){
        ValidatorUtil.validateEntity(swReturnVo, AddGroup.class);//校验
        ValidatorUtil.validateEntity(swReturnVo.getSwReturnBaseVo(), AddGroup.class);//校验
        try{
            Result<Integer> _result= swReturnService.create(swReturnVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加退货单成功");
        }catch (Exception e){
            logger.error("添加退货单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新退货单详细信息", notes="根据url的退货单编号来指定更新对象，并根据传过来的退货单信息来更新退货单详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SwReturnModiVo swReturnModiVo){
        try {
            Result<Integer> _result =  swReturnService.update(swReturnModiVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改退货单成功");
        } catch (Exception e) {
            logger.error("修改退货单异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @ApiOperation(value = "退货单列表")
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
    public Result<PageUitls<SwReturnBaseResultVo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwReturnBaseResultVo> page =  swReturnService.findList(params);
        return Result.newSuccess(new PageUitls<SwReturnBaseResultVo>(page));
    }


    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @ApiOperation(value="审核退货单", notes="初审、终审接口")
    //@ApiImplicitParam(name = "swOrderVo", value = "退货单信息实体 swOrderVo",dataTypeClass = SysDictVo.class)
    public Result<String> audit(@ApiParam(name = "swReturnAuditVo", value = "退货单审核 swReturnAuditVo", required = true) @RequestBody SwReturnAuditVo swReturnAuditVo){
        ValidatorUtil.validateEntity(swReturnAuditVo, AddGroup.class);//校验
        try{
            swReturnAuditVo.setAuditUserNo(ShiroUtils.getCurrentUserNo());
            swReturnAuditVo.setAuditUserName(ShiroUtils.getCurrentUserName());
            Result<Integer> _result= swReturnService.audit(swReturnAuditVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("审核退货单成功");
        }catch (Exception e){
            logger.error("审核退货单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @RequestMapping(value = "/{returnNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取退货单详细信息", notes="根据url的退货编号来获取业务退货单详细信息")
    @ApiImplicitParam(name = "returnNo", value = "退货单编号", required = true, dataType = "string",paramType = "path")
    public Result<SwReturnResultVo> getUserById(@PathVariable("returnNo")String returnNo){
        SwReturnResultVo swReturnResultVo = swReturnService.getEntityByNo(returnNo);
        return Result.newSuccess(swReturnResultVo);
    }
}
