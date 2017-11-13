package com.fangxin.siwei.fangzhi.controller.stock;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.service.stock.SwStockInfoService;
import com.fangxin.siwei.fangzhi.vo.result.StockVerifyResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwStockInfoResultVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Date:2017/11/6 0006 20:42
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/stockInfo")
@Api(tags = "库存信息",description = "库存信息相关API")
public class StockInfoController {
    @Resource
    SwStockInfoService swStockInfoService;

    @ApiOperation(value = "库存信息列表")
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
    public Result<PageUitls<SwStockInfoResultVo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwStockInfoResultVo> page =  swStockInfoService.findList(params);
        return Result.newSuccess(new PageUitls<SwStockInfoResultVo>(page));
    }
}
