package com.fangxin.siwei.fangzhi.controller.produce;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.FileUtil;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.validator.ValidatorUtil;
import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import com.fangxin.siwei.fangzhi.service.produce.SwWorkService;
import com.fangxin.siwei.fangzhi.vo.produce.SwWorkDetailVo;
import com.fangxin.siwei.fangzhi.vo.purchase.SwPurOrderModiVo;
import com.fangxin.siwei.fangzhi.vo.result.SwPurOrderBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwWorkDetailResultVo;
import com.fangxin.siwei.fangzhi.vo.system.SysDictVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/6 0006 20:47
 * @Author lu.dong
 * @Description：
 **/
@RestController
@RequestMapping("/api/work")
@Api(tags = "工时",description = "工时相关API")
public class WorkContoller {


    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SwWorkService swWorkService;

    /** restful api 增删改查*/
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="工时保存", notes="工时保存")
    public Result<String> create(@ApiParam(name = "swWorkDetailVo", value = "工时信息实体 swWorkDetailVo", required = true) @RequestBody SwWorkDetailVo swWorkDetailVo){
        ValidatorUtil.validateEntity(swWorkDetailVo, AddGroup.class);//校验
        try{
            Result<Integer> _result= swWorkService.save(swWorkDetailVo);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  Result.newSuccess("保存工时成功");
        }catch (Exception e){
            logger.error("保存工异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "import",method = RequestMethod.POST)
    @ApiOperation(value="工时导入", notes="工时导入")
    public Result<List<SwWorkDetailVo>> importFile(@RequestParam(value="uploadFile")MultipartFile mFile){
        try{
            Result<List<SwWorkDetailVo>> _result= swWorkService.batchImport(mFile);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            logger.info("工时导入成功!");
            return  _result;
        }catch (Exception e){
            logger.error("工时导入预览异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/downTemplate",method = RequestMethod.GET)
    public ResponseEntity<byte[]> download() throws IOException {
        String fileName="workTemplate.xls";
        //String dfileName=FileUtil.getRealPath()+"/static/template/"+fileName;
        InputStream inputStream = this.getClass().getResourceAsStream("/static/template/"+fileName);
         //dfileName = new String(dfileName.getBytes("gb2312"), "iso8859-1");
        logger.info("下载路径:{}",fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity<byte[]>(FileUtil.readFsToByteArray(inputStream), headers, HttpStatus.CREATED);
    }

    @ApiOperation(value="删除工时", notes="删除工时")
    @RequestMapping(value = "{ids}",method = RequestMethod.DELETE)
    @ApiImplicitParam(name = "ids",value = "工时Id编号 以逗号分隔 ")
    public Result<String> delete(@PathVariable("ids") String ids){
        try {
            Result<Integer> result= swWorkService.deleteByIdstr(ids);
            if (!result.isSuccess()) {
                return Result.newError(result.getCode(), result.getMessage());
            }
            return Result.newSuccess("删除工时成功!");
        } catch (Exception e) {
            logger.error("删除工时异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }


    @ApiOperation(value = "工时列表")
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
    public Result<PageUitls<SwWorkDetailResultVo>> findList(@RequestParam @ApiParam(hidden = true) Map<String,String> params){
        Page<SwWorkDetailResultVo> page =  swWorkService.findList(params);
        return Result.newSuccess(new PageUitls<SwWorkDetailResultVo>(page));
    }


}
