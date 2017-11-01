package com.fangxin.siwei.fangzhi.controller.purchase;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.service.purchase.PurchaseService;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderAuditVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderBaseResultVo;
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
    PurchaseService purchaseService;

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


    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @ApiOperation(value="审核订单", notes="初审、终审接口")
    //@ApiImplicitParam(name = "swPurOrderVo", value = "采购单信息实体 swPurOrderVo",dataTypeClass = SysDictVo.class)
    public Result<String> audit(@ApiParam(name = "swOrderAuditVo", value = "订单审核 swOrderAuditVo", required = true) @RequestBody SwOrderAuditVo swOrderAuditVo){
        ValidatorUtil.validateEntity(swOrderAuditVo, AddGroup.class);//校验
        try{
            swOrderAuditVo.setAuditUserNo(ShiroUtils.getCurrentUserNo());
            swOrderAuditVo.setAuditUserName(ShiroUtils.getCurrentUserName());
            Result<Integer> _result= purchaseService.audit(swOrderAuditVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("审核采购单成功");
        }catch (Exception e){
            logger.error("审核采购单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @RequestMapping(value = "/{orderNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取订单详细信息", notes="根据url的用户编号来获取业务订单详细信息")
    @ApiImplicitParam(name = "orderNo", value = "订单编号", required = true, dataType = "string",paramType = "path")
    public Result<SwPurOrderResultVo> getUserById(@PathVariable("orderNo")String orderNo){
        SwPurOrderResultVo swPurOrderResultVo = purchaseService.getEntityByNo(orderNo);
        return Result.newSuccess(swPurOrderResultVo);
    }
}
