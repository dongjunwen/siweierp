package com.fangxin.siwei.fangzhi.controller.system;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.service.system.SysUserService;
import com.fangxin.siwei.fangzhi.vo.SysUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date:2017/10/19 0019 15:05
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户",description = "用户相关api")
public class SysUserontroller {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    SysUserService sysUserService;

    /** restful api 增删改查*/
    @RequestMapping(value = "createUser",method = RequestMethod.POST)
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "sysUserVo", value = "用户操作实体 sysUserVo",dataTypeClass = SysUserVo.class)
    public Result<String> createUser(@RequestBody SysUserVo sysUserVo){
        ValidatorUtil.validateEntity(sysUserVo, AddGroup.class);//校验用户实体字段，
        try{
            Result<Integer> _result=sysUserService.createUser(sysUserVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("添加账号成功");
        }catch (Exception e){
            logger.error("用户添加异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }


    }

}
