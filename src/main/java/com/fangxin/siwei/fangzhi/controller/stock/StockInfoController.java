package com.fangxin.siwei.fangzhi.controller.stock;

import com.alibaba.fastjson.JSON;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.excel.Excel;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.FileUtil;
import com.fangxin.siwei.fangzhi.common.utils.PageUitls;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.service.stock.SwStockInfoService;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderModiVo;
import com.fangxin.siwei.fangzhi.vo.produce.SwWorkDetailVo;
import com.fangxin.siwei.fangzhi.vo.result.StockVerifyResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwStockInfoResultVo;
import com.fangxin.siwei.fangzhi.vo.stock.SwStockInfoQueryVo;
import com.fangxin.siwei.fangzhi.vo.stock.SwStockInfoVo;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
    private static final Logger logger= LoggerFactory.getLogger(StockInfoController.class);

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

    @RequestMapping(value = "/downTemplate",method = RequestMethod.GET)
    public ResponseEntity<byte[]> download() throws IOException {
        String fileName="stockInfoTemplate.xls";
       // String dfileName= FileUtil.getProjectPath()+"/static/template/"+fileName;
        InputStream inputStream = this.getClass().getResourceAsStream("/static/template/"+fileName);
        //dfileName = new String(dfileName.getBytes("gb2312"), "iso8859-1");
        logger.info("下载路径:{}",fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity<byte[]>(FileUtil.readFsToByteArray(inputStream), headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "import",method = RequestMethod.POST)
    @ApiOperation(value="库存导入", notes="库存导入")
    public Result<List<SwStockInfoVo>> importFile(@RequestParam(value="uploadFile")MultipartFile mFile){
        try{
            Result<List<SwStockInfoVo>> _result= swStockInfoService.batchImport(mFile);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            logger.info("库存导入成功!");
            return  _result;
        }catch (Exception e){
            logger.error("库存导入异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value="更新库存信息", notes="根据url的物料编号来指定更新对象，并根据传过来的订单信息来更新库存详细信息")
    @RequestMapping(method = RequestMethod.PUT)
    public Result<String> update(@RequestBody SwStockInfoVo swStockInfoVo){
        try {
            Result<Integer> _result =swStockInfoService.saveStockInfo(swStockInfoVo);
            if (!_result.isSuccess()) {
                return Result.newError(_result.getCode(), _result.getMessage());
            }
            return Result.newSuccess("更新库存成功");
        } catch (Exception e) {
            logger.error("更新库存异常!{}", e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @ApiOperation(value = "库存信息导出Excel")
    @RequestMapping(value = "exportExcel",method = RequestMethod.GET)
    public ResponseEntity<byte[]>  exportExcel(SwStockInfoQueryVo swStockInfoQueryVo)throws Exception {
        List<SwStockInfoResultVo> swStockInfoResultVos = swStockInfoService.findCond(swStockInfoQueryVo);
        Excel excel=new Excel();
        String fileName="stockInfoExportTemplate.xls";
        String templateFileName= FileUtil.getRealPath()+"/static/template/"+fileName;
        String prefix=fileName.substring(fileName.indexOf("."));
        String saveFileName=UUIDUtils.genUUID("SE")+prefix;
        String saveRealFileName="/home/file/"+saveFileName ;
        excel.createExcel(templateFileName,swStockInfoResultVos,saveRealFileName);
        logger.info("下载路径:{}",saveFileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", saveFileName);
        return new ResponseEntity<byte[]>(FileUtil.readFileToByteArray(saveRealFileName), headers, HttpStatus.CREATED);
    }
}
