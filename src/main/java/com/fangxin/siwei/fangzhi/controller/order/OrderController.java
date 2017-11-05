package com.fangxin.siwei.fangzhi.controller.order;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.modal.SysUser;
import com.fangxin.siwei.fangzhi.service.order.SwOrderService;
import com.fangxin.siwei.fangzhi.vo.base.SwMaterialInfoVo;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderAuditVo;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderModiVo;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderVo;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderResultVo;
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
@RequestMapping("/api/order")
@Api(tags = "业务订单",description = "业务订单相关API")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwOrderService swOrderService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="创建订单合同", notes="根据订单合同对象创建订单合同")
    //@ApiImplicitParam(name = "swOrderVo", value = "订单合同信息实体 swOrderVo",dataTypeClass = SysDictVo.class)
    public Result<String> create(@ApiParam(name = "swOrderVo", value = "订单合同信息实体 swOrderVo", required = true) @RequestBody SwOrderVo swOrderVo){
        ValidatorUtil.validateEntity(swOrderVo, AddGroup.class);//校验
        ValidatorUtil.validateEntity(swOrderVo.getSwOrderBaseVo(), AddGroup.class);//校验
        try{
            Result<Integer> _result= swOrderService.create(swOrderVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加订单合同成功");
        }catch (Exception e){
            logger.error("添加订单合同异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新订单详细信息", notes="根据url的订单编号来指定更新对象，并根据传过来的订单信息来更新订单详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SwOrderModiVo swOrderModiVo){
        try {
            Result<Integer> _result =  swOrderService.update(swOrderModiVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("修改订单成功");
        } catch (Exception e) {
            logger.error("修改订单异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @ApiOperation(value = "订单合同列表")
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
    public Result<PageUitls<SwOrderBaseResultVo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwOrderBaseResultVo> page =  swOrderService.findList(params);
        return Result.newSuccess(new PageUitls<SwOrderBaseResultVo>(page));
    }


    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @ApiOperation(value="审核订单", notes="初审、终审接口")
    //@ApiImplicitParam(name = "swOrderVo", value = "订单合同信息实体 swOrderVo",dataTypeClass = SysDictVo.class)
    public Result<String> audit(@ApiParam(name = "swOrderAuditVo", value = "订单审核 swOrderAuditVo", required = true) @RequestBody SwOrderAuditVo swOrderAuditVo){
        ValidatorUtil.validateEntity(swOrderAuditVo, AddGroup.class);//校验
        try{
            swOrderAuditVo.setAuditUserNo(ShiroUtils.getCurrentUserNo());
            swOrderAuditVo.setAuditUserName(ShiroUtils.getCurrentUserName());
            Result<Integer> _result= swOrderService.audit(swOrderAuditVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("审核订单合同成功");
        }catch (Exception e){
            logger.error("审核订单合同异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @RequestMapping(value = "/{orderNo}",method = RequestMethod.GET)
    @ApiOperation(value="获取订单详细信息", notes="根据url的用户编号来获取业务订单详细信息")
    @ApiImplicitParam(name = "orderNo", value = "订单编号", required = true, dataType = "string",paramType = "path")
    public Result<SwOrderResultVo> getUserById(@PathVariable("orderNo")String orderNo){
        SwOrderResultVo swOrderResultVo = swOrderService.getEntityByNo(orderNo);
        return Result.newSuccess(swOrderResultVo);
    }
}
