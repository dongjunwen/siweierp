package com.fangxin.siwei.fangzhi.service.impl.produce;

import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.excel.Excel;
import com.fangxin.siwei.fangzhi.common.excel.ExcelSheet;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.DateUtil;
import com.fangxin.siwei.fangzhi.common.utils.FileUtil;
import com.fangxin.siwei.fangzhi.common.utils.ShiroUtils;
import com.fangxin.siwei.fangzhi.common.utils.UUIDUtils;
import com.fangxin.siwei.fangzhi.mapper.TmpWorkDetailMapper;
import com.fangxin.siwei.fangzhi.modal.TmpWorkDetail;
import com.fangxin.siwei.fangzhi.service.produce.SwWorkService;
import com.fangxin.siwei.fangzhi.vo.produce.SwWorkDetailVo;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date:2017/11/15 0015 16:32
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SwWorkServiceImpl implements SwWorkService {
    private static final Logger logger= LoggerFactory.getLogger(SwWorkServiceImpl.class);
    @Resource
    private TmpWorkDetailMapper tmpWorkDetailMapper;

    @Override
    public Result<List<SwWorkDetailVo> > batchImport(MultipartFile mFile) {

        String originFileName=mFile.getOriginalFilename();
        String prefix=originFileName.substring(originFileName.indexOf("."));
        String saveFileName="D:\\home\\file\\"+ UUIDUtils.genUUID("I")+prefix;
        InputStream importFile= null;
        try {
            importFile = mFile.getInputStream();
            FileUtil.saveFile(saveFileName,importFile);
        String keyValue = "计件日期:workDate,订单号:orderNo,订单序号:orderSeqNo,工号:userNo,姓名:userName,流程步骤:stepName,工艺:processName,单位:unit,数量:num";
        Excel excel = new Excel(saveFileName);
        ExcelSheet sheet = excel.getSheet();
        String importNo= UUIDUtils.genUUID("I");
        List<SwWorkDetailVo> swWorkDetailVos = sheet.getList(0, 0, keyValue).toObject(SwWorkDetailVo.class);
        List<TmpWorkDetail> tmpWorkDetails=new ArrayList<>();
        for(SwWorkDetailVo swWorkDetailVo:swWorkDetailVos){
            swWorkDetailVo.setImportNo(importNo);
            TmpWorkDetail tmpWorkDetail=new TmpWorkDetail();
            try {
                BeanUtils.copyProperties(tmpWorkDetail,swWorkDetailVo);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            tmpWorkDetail.setCreateNo(ShiroUtils.getCurrentUserNo());
            tmpWorkDetail.setCreateTime(new Date());
            tmpWorkDetail.setModiNo(ShiroUtils.getCurrentUserNo());
            tmpWorkDetail.setModiTime(new Date());
            tmpWorkDetail.setVersion(0);
            tmpWorkDetail.setImportNo(importNo);
            tmpWorkDetails.add(tmpWorkDetail);
        }
        tmpWorkDetailMapper.insertBatch(tmpWorkDetails);
           // FileUtil.delFile(saveFileName);
        return Result.newSuccess(swWorkDetailVos);
        } catch (IOException e) {
            logger.error("IO异常:{}"+e.getMessage());
            return Result.newError(ResultCode.FAIL);
        }
    }


}
