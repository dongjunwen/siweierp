package com.fangxin.siwei.fangzhi.controller.stock;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.service.purchase.PurchaseService;
import com.fangxin.siwei.fangzhi.service.stock.StockInService;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Date:2017/11/6 0006 20:40
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/stockIn")
@Api(tags = "入库单",description = "入库单相关API")
public class StockInController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    StockInService stockInService;

    @RequestMapping(value = "/{reqNo}",method = RequestMethod.POST)
    @ApiOperation(value="创建入库单", notes="根据来源单号创建入库单")
    public Result<String> create(@ApiParam(name = "reqNo", value = "来源单号 ", required = true) @PathVariable("reqNo") String  reqNo){
        try{
            Result<Integer> _result= stockInService.create(reqNo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("创建入库单成功");
        }catch (Exception e){
            logger.error("创建入库单异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }
    
}
