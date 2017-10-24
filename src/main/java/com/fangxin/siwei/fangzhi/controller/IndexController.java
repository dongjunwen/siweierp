package com.fangxin.siwei.fangzhi.controller;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.validator.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springfox.documentation.annotations.ApiIgnore;

/**
 * author:lu.dong
 * date:2017-10-17
 *  desc:首页显示
 */
@RestController
@RequestMapping("")
@Api(tags = "首页",description ="App相关操作接口定义类")
//@ApiIgnore
public class IndexController {

    @ApiOperation(value = "Api首页",notes = "所有api接口")
    @RequestMapping(value = "/swagger",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("swagger/index.html");
    }

    @ApiOperation(value = "登录首页",notes = "登录首页")
    @RequestMapping(value = "/loginIndex",method = RequestMethod.GET)
    public ModelAndView loginIndex(){
        return new ModelAndView("web/loginIndex.html");
    }

    @ApiOperation(value = "无权限页面",notes = "无权限页面")
    @RequestMapping(value = "/403",method = RequestMethod.GET)
    public ModelAndView Error403(){
        return new ModelAndView("web/403.html");
    }

    @ApiOperation(value = "登录",notes = "登录接口")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",paramType = "form"),
            @ApiImplicitParam(name = "password",value = "用户密码",paramType = "form")
    })
    public Result<String> login(String name, String password, RedirectAttributes redirectAttributes){
        Assert.isBlank(name,"用户名不能为空");
        Assert.isBlank(password,"密码不能为空");
        //模拟登录
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject currentUser  = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            return Result.newSuccess(name+"登录成功!");
        }catch(Exception e){
            //return new ResponseEntity<String>("用户名或密码错误", HttpStatus.UNPROCESSABLE_ENTITY);
            return Result.newError(ResultCode.USERNAME_OR_PASS_ERR);
        }
    }

    @ApiOperation(value = "退出登录")
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public Result<String> logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.newSuccess("已退出!");
    }
}
