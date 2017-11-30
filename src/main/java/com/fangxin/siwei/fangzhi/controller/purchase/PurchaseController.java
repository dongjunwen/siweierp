package com.fangxin.siwei.fangzhi.controller.purchase;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.service.purchase.SwPurchaseService;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurAuditVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderModiVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderVo;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderDetailResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderDetailResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderResultVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Date:2017/10/31 0031 18:07
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/purchase")
@Api(tags = "采购单",description = "采购单相关API")
public class PurchaseController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwPurchaseService purchaseService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建采购单", notes="根据采购单对象创建采购单")
    //@ApiImplicitParam(name = "swPurOrderVo", value = "采购单信息实体 swPurOrderVo",dataTypeClass = SysDictVo.class)
    public Result<String> create(@ApiParam(name = "swPurOrderVo", value = "采购单信息实体 swPurOrderVo", required = true) @RequestBody SwPurOrderVo swPurOrderVo){
        ValidatorUtil.validateEntity(swPurOrderVo, AddGroup.class);//校验
        ValidatorUtil.validateEntity(swPurOrderVo.getSwPurOrderBaseVo(), AddGroup.class);//校验
        try{
            Result<Integer> _result= purchaseService.create(swPurOrderVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加采购单成功");
        }catch (Exception e){
            logger.error("添加采购单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @ApiOperation(value="更新采购单详细信息", notes="根据url的采购单编号来指定更新对象，并根据传过来的采购单信息来更新采购单详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SwPurOrderModiVo swPurOrderModiVo){
        try {
            Result<Integer> _result =  purchaseService.update(swPurOrderModiVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改采购单成功");
        } catch (Exception e) {
            logger.error("修改采购单异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @ApiOperation(value = "采购单列表")
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
    public Result<PageUitls<SwPurOrderBaseResultVo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwPurOrderBaseResultVo> page =  purchaseService.findList(params);
        return Result.newSuccess(new PageUitls<SwPurOrderBaseResultVo>(page));
    }


    @ApiOperation(value = "订单合同详细列表")
    @RequestMapping(value = "findDetailList",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currPage",value = "当前页",paramType = "query"),
            @ApiImplicitParam(name = "sort",value = "排序 ASC 或 DESC",required = false,example = "asc/desc",paramType = "query"),
            @ApiImplicitParam(name = "orderBy",value = "排序字段",required = false,example = "createdTime",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示条数",required = false,example = "createdTime",paramType = "query"),
            @ApiImplicitParam(name = "startTime",value = "开始时间 YYYY-MM-DD格式",required = false,dataType = "string",paramType = "query"),//如果时间类型则可以打开
            @ApiImplicitParam(name = "endTime",value = "结束时间 YYYY-MM-DD格式",required = false,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "purNo",value = "订单号",required = false,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "purStatus",value = "采购状态",required = false,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "supplyCompNo",value = "客户编号",required = true,dataType = "string",paramType = "query")
    })
    public Result<PageUitls<SwPurOrderDetailResultVo>> findDetailList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwPurOrderDetailResultVo> page =  purchaseService.findDetailList(params);
        return Result.newSuccess(new PageUitls<SwPurOrderDetailResultVo>(page));
    }

    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @ApiOperation(value="审核采购单", notes="初审、终审接口")
    //@ApiImplicitParam(name = "swPurOrderVo", value = "采购单信息实体 swPurOrderVo",dataTypeClass = SysDictVo.class)
    public Result<String> audit(@ApiParam(name = "swPurAuditVo", value = "审核采购单 swPurAuditVo", required = true) @RequestBody SwPurAuditVo swPurAuditVo){
        ValidatorUtil.validateEntity(swPurAuditVo, AddGroup.class);//校验
        try{
            swPurAuditVo.setAuditUserNo(ShiroUtils.getCurrentUserNo());
            swPurAuditVo.setAuditUserName(ShiroUtils.getCurrentUserName());
            Result<Integer> _result= purchaseService.audit(swPurAuditVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("审核采购单成功");
        }catch (Exception e){
            logger.error("审核采购单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @RequestMapping(value = "/{purNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取采购单详细信息", notes="根据url的用户编号来获取采购单详细信息")
    @ApiImplicitParam(name = "purNo", value = "采购单编号", required = true, dataType = "string",paramType = "path")
    public Result<SwPurOrderResultVo> getUserById(@PathVariable("purNo")String purNo){
        SwPurOrderResultVo swPurOrderResultVo = purchaseService.getEntityByNo(purNo);
        return Result.newSuccess(swPurOrderResultVo);
    }
}
