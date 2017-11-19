package com.fangxin.siwei.fangzhi.controller.produce;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.FileUtil;
import com.fangxin.siwei.fangzhi.service.produce.SwWorkService;
import com.fangxin.siwei.fangzhi.vo.produce.SwWorkDetailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @RequestMapping(value = "import",method = RequestMethod.POST)
    @ApiOperation(value="工时导入", notes="工时导入")
    public Result<List<SwWorkDetailVo>> importFile(@RequestParam(value="uploadFile")MultipartFile mFile){
        try{
            Result<List<SwWorkDetailVo>> _result= swWorkService.batchImport(mFile);
            if(!_result.isSuccess()){
                return Result.newError(_result.getCode(),_result.getMessage());
            }
            return  _result;
        }catch (Exception e){
            logger.error("工时导入预览异常!{}",e);
            return Result.newError(ResultCode.FAIL);
        }
    }

    @RequestMapping(value = "/downTemplate",method = RequestMethod.GET)
    public ResponseEntity<byte[]> download() throws IOException {
        String fileName="workTemplate.xls";
        String dfileName=FileUtil.getRealPath()+"/static/template/"+fileName;
         //dfileName = new String(dfileName.getBytes("gb2312"), "iso8859-1");
        logger.info("下载路径:{}",fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity<byte[]>(FileUtil.readFileToByteArray(dfileName), headers, HttpStatus.CREATED);
    }


}
