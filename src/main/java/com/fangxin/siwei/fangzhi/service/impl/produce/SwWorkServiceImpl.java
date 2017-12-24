package com.fangxin.siwei.fangzhi.service.impl.produce;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.excel.Excel;
import com.fangxin.siwei.fangzhi.common.excel.ExcelSheet;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.*;
import com.fangxin.siwei.fangzhi.mapper.SwWorkDetailMapper;
import com.fangxin.siwei.fangzhi.modal.SwWorkDetail;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.impl.system.SysDictUtils;
import com.fangxin.siwei.fangzhi.service.produce.SwWorkService;
import com.fangxin.siwei.fangzhi.service.system.SysUserService;
import com.fangxin.siwei.fangzhi.vo.produce.SwWorkDetailVo;
import com.fangxin.siwei.fangzhi.vo.result.SwWorkDetailResultVo;
import com.github.pagehelper.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/15 0015 16:32
 * @Author lu.dong
 * @Description：
 **/
@Service
public class SwWorkServiceImpl extends AbstractService<SwWorkDetail> implements SwWorkService {
    private static final Logger logger= LoggerFactory.getLogger(SwWorkServiceImpl.class);
    @Resource
    private SwWorkDetailMapper swWorkDetailMapper;
    @Resource
    private SysUserService sysUserService;

    @Override
    public Result<List<SwWorkDetailVo> > batchImport(MultipartFile mFile) {

        String originFileName=mFile.getOriginalFilename();
        String prefix=originFileName.substring(originFileName.indexOf("."));
        String saveFileName="/home/file/"+ UUIDUtils.genUUID("I")+prefix;
        InputStream importFile= null;
        try {
            importFile = mFile.getInputStream();
            FileUtil.saveFile(saveFileName,importFile);
            logger.info("保存文件:{}成功!",saveFileName);
            String keyValue = "计件日期:workDate,订单号:orderNo,订单序号:orderSeqNo,工号:userNo,姓名:userName,流程步骤:stepName,工艺:processName,单位:unit,数量:num";
            Excel excel = new Excel(saveFileName);
            ExcelSheet sheet = excel.getSheet();
            List<SwWorkDetailVo> swWorkDetailVos = sheet.getList(0, 0, keyValue).toObject(SwWorkDetailVo.class);
            List<SwWorkDetail> swWorkDetails=new ArrayList<>();
            for(SwWorkDetailVo swWorkDetailVo:swWorkDetailVos){
                String workNo= UUIDUtils.genUUID("I");
                SwWorkDetail swWorkDetail=new SwWorkDetail();
                String stepNo=SysDictUtils.getCodeByUniqName("STEP_NO",swWorkDetailVo.getStepName());
                swWorkDetailVo.setWorkNo(workNo);
                swWorkDetailVo.setStepNo(stepNo);
                convertVoToEntity(swWorkDetail,swWorkDetailVo);
                swWorkDetail.setCreateNo(ShiroUtils.getCurrentUserNo());
                swWorkDetail.setCreateTime(new Date());
                swWorkDetail.setModiNo(ShiroUtils.getCurrentUserNo());
                swWorkDetail.setModiTime(new Date());
                swWorkDetail.setVersion(0);
                swWorkDetails.add(swWorkDetail);
            }
            swWorkDetailMapper.insertBatch(swWorkDetails);
            logger.info("记录数据:{}成功!",saveFileName);
            FileUtil.delFile(saveFileName);
            return Result.newSuccess(swWorkDetailVos);
        } catch (IOException e) {
            logger.error("IO异常:{}"+e.getMessage());
            return Result.newError(ResultCode.FAIL);
        }
    }

    private void convertVoToEntity(SwWorkDetail swWorkDetail,SwWorkDetailVo swWorkDetailVo) {
            BeanUtilsEx.copyProperties(swWorkDetail,swWorkDetailVo);
    }

    @Override
    public Page<SwWorkDetailResultVo> findList(Map<String, String> params) {
        //日期查询条件
        params.put("timeCond1","work_date");
        Condition serviceCondition = Common.getServiceCondition(params, SwWorkDetail.class);
        Page<SwWorkDetail> swWorkDetails = (Page)findByCondition(serviceCondition);
        Page<SwWorkDetailResultVo> swWorkDetailResultVos= new Page<SwWorkDetailResultVo>();
        swWorkDetailResultVos.setPageSize(swWorkDetails.getPageSize());
        swWorkDetailResultVos.setPageNum(swWorkDetails.getPageNum());
        swWorkDetailResultVos.setPages(swWorkDetails.getPages());
        swWorkDetailResultVos.setTotal(swWorkDetails.getTotal());
        for(SwWorkDetail swWorkDetail: swWorkDetails){
            SwWorkDetailResultVo swWorkDetailResultVo=new SwWorkDetailResultVo();
            convertEntityTVo(swWorkDetailResultVo,swWorkDetail);
            swWorkDetailResultVo.setWorkDate(DateUtil.formatDate(swWorkDetail.getWorkDate()));
            swWorkDetailResultVo.setCreateName(sysUserService.getUserNameById(swWorkDetailResultVo.getCreateNo()));
            swWorkDetailResultVo.setModiName(sysUserService.getUserNameById(swWorkDetailResultVo.getModiNo()));
            swWorkDetailResultVo.setCreateTime(DateUtil.formatDateTime(swWorkDetail.getCreateTime()));
            swWorkDetailResultVo.setModiTime(DateUtil.formatDateTime(swWorkDetail.getModiTime()));
            swWorkDetailResultVos.add(swWorkDetailResultVo);
        }
        return swWorkDetailResultVos;
    }

    private void convertEntityTVo(SwWorkDetailResultVo swWorkDetailResultVo, SwWorkDetail swWorkDetail) {
            BeanUtilsEx.copyProperties(swWorkDetailResultVo,swWorkDetail);
    }

    @Override
    public Result<Integer> deleteByIdstr(String ids) {
        return Result.newSuccess(swWorkDetailMapper.deleteByIds(ids));
    }

    @Override
    public Result<Integer> save(SwWorkDetailVo swWorkDetailVo) {
        String workNo=swWorkDetailVo.getWorkNo();
        SwWorkDetail swWorkDetail=new SwWorkDetail();
        convertVoToEntity(swWorkDetail,swWorkDetailVo);
        if(StringUtils.isNotEmpty(workNo)){
            swWorkDetailMapper.updateByWorkNo(swWorkDetail);
        }else{
            swWorkDetailMapper.insertSelective(swWorkDetail);
        }
        return Result.newSuccess(1);
    }

    @Override
    public List<SwWorkDetailResultVo> findCond(Map<String, String> params) {
        String filter = params.get("filter");
        if(StringUtils.isNotBlank(filter)){
            try {
                JSONObject filterOjb = JSON.parseObject(filter);
                params.put("orderNo",filterOjb.getString("orderNo"));
                params.put("userName",filterOjb.getString("userName"));
                params.put("stepNo",filterOjb.getString("stepNo"));
            }catch (Exception e){
                throw new RRException("filter格式错误，请填写json格式");
            }
        }
        String startTime = params.get("startTime");
        String endTime = params.get("endTime");
        if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(endTime)){
            startTime=startTime+" 00:00:00";
            endTime=endTime+" 23:59:59";
            params.put("startTime",startTime);
            params.put("endTime",endTime);
        }else if(StringUtils.isNotEmpty(startTime)){
            startTime=startTime+" 00:00:00";
            params.put("startTime",startTime);
        }else if(StringUtils.isNotEmpty(endTime)){
            endTime=endTime+" 23:59:59";
            params.put("endTime",endTime);
        }
        List<SwWorkDetail>  swWorkDetails=swWorkDetailMapper.selectByCond(params);
        List<SwWorkDetailResultVo> swWorkDetailResultVos=new ArrayList<>();
        for(SwWorkDetail swWorkDetail: swWorkDetails){
            SwWorkDetailResultVo swWorkDetailResultVo=new SwWorkDetailResultVo();
            convertEntityTVo(swWorkDetailResultVo,swWorkDetail);
            swWorkDetailResultVo.setWorkDate(DateUtil.formatDate(swWorkDetail.getWorkDate()));
            swWorkDetailResultVo.setCreateName(sysUserService.getUserNameById(swWorkDetailResultVo.getCreateNo()));
            swWorkDetailResultVo.setModiName(sysUserService.getUserNameById(swWorkDetailResultVo.getModiNo()));
            swWorkDetailResultVo.setCreateTime(DateUtil.formatDateTime(swWorkDetail.getCreateTime()));
            swWorkDetailResultVo.setModiTime(DateUtil.formatDateTime(swWorkDetail.getModiTime()));
            swWorkDetailResultVos.add(swWorkDetailResultVo);
        }
        return swWorkDetailResultVos;
    }

    @Override
    public Result<Integer> deleteByWorkNos(String workNos) {
        Integer delNum=swWorkDetailMapper.deleteByWorkNos(workNos);
        return Result.newSuccess(delNum);
    }


}
