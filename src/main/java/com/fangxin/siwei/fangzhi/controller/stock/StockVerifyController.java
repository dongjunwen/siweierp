package com.fangxin.siwei.fangzhi.controller.stock;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.service.stock.SwStockInVerifyService;
import com.fangxin.siwei.fangzhi.vo.result.StockVerifyResultVo;
import com.fangxin.siwei.fangzhi.vo.stock.StockVerifyVo;
import com.fangxin.siwei.fangzhi.vo.stock.StockVerifyActionVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/6 0006 20:41
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/stockVerify")
@Api(tags = "入库单校验",description = "入库单校验相关API")
public class StockVerifyController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwStockInVerifyService stockInVerifyService;

    @RequestMapping(value = "/{reqNo}",method = RequestMethod.POST)
    @ApiOperation(value="创建入库校验单", notes="根据来源单号创建入库校验单")
    public Result<List<StockVerifyResultVo>> create(@ApiParam(name = "reqNo", value = "来源单号 ", required = true) @PathVariable("reqNo") String  reqNo){
        try{
            Result<List<StockVerifyResultVo>> _result= stockInVerifyService.create(reqNo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  _result;
        }catch (Exception e){
            logger.error("创建入库校验单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }
    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value="修改入库校验单", notes="根据来源单号修改入库校验单")
    public Result<Integer> update( @ApiParam(name = "stockVerifyVo", value = "入库校验单记录", required = true)@RequestBody StockVerifyVo stockVerifyVo){
        try{
            Result<Integer> _result= stockInVerifyService.update(stockVerifyVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  _result;
        }catch (Exception e){
            logger.error("修改入库单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "check",method = RequestMethod.POST)
    @ApiOperation(value="校验入库单", notes="入库单校验")
    public Result<Integer> check( @ApiParam(name = "stockVerifyActionVo", value = "入库单校验记录", required = true)@RequestBody StockVerifyActionVo stockVerifyActionVo){
        try{
            stockVerifyActionVo.setAuditUserNo(ShiroUtils.getCurrentUserNo());
            stockVerifyActionVo.setAuditUserName(ShiroUtils.getCurrentUserName());
            Result<Integer> _result= stockInVerifyService.check(stockVerifyActionVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  _result;
        }catch (Exception e){
            logger.error("入库单校验异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @ApiOperation(value = "入库单校验列表")
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
    public Result<PageUitls<StockVerifyResultVo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<StockVerifyResultVo> page =  stockInVerifyService.findList(params);
        return Result.newSuccess(new PageUitls<StockVerifyResultVo>(page));
    }

}
