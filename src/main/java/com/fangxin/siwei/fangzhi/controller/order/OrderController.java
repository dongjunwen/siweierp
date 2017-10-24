package com.fangxin.siwei.fangzhi.controller.order;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.service.order.SwOrderService;
import com.fangxin.siwei.fangzhi.vo.SwOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date:2017/10/20 0020 9:47
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/order")
@Api(tags = "订单中心",description = "订单相关API")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwOrderService swOrderService;

    /** restful api 增删改查*/
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
}
