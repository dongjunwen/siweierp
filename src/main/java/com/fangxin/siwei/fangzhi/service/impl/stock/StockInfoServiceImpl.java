package com.fangxin.siwei.fangzhi.service.impl.stock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.excel.Excel;
import com.fangxin.siwei.fangzhi.common.excel.ExcelSheet;
import com.fangxin.siwei.fangzhi.common.exception.RRException;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.*;
import com.fangxin.siwei.fangzhi.mapper.SwStockInfoMapper;
import com.fangxin.siwei.fangzhi.modal.*;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.base.SwMaterialInfoService;
import com.fangxin.siwei.fangzhi.service.impl.system.SysDictUtils;
import com.fangxin.siwei.fangzhi.service.stock.SwStockInfoService;
import com.fangxin.siwei.fangzhi.vo.result.SwStockInfoResultVo;
import com.fangxin.siwei.fangzhi.vo.stock.SwStockInfoQueryVo;
import com.fangxin.siwei.fangzhi.vo.stock.SwStockInfoVo;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Date:2017/11/7 0007 16:36
 * @Author lu.dong
 * @Description：
 **/
@Service
public class StockInfoServiceImpl extends AbstractService<SwStockInfo> implements SwStockInfoService {
    private static  final Logger logger= LoggerFactory.getLogger(StockInfoServiceImpl.class);
    @Resource
    SwStockInfoMapper swStockInfoMapper;
    @Resource
    SwMaterialInfoService swMaterialInfoService;

    @Override
    public int saveSingleStock(SwStockInfo swStockInfo) {
        int saveNum=0;
        swStockInfo.setNum(swStockInfo.getNum());
        swStockInfo.setModiTime(new Date());
        SwStockInfo oldSwStockInfo=swStockInfoMapper.selectByMaterialNo(swStockInfo.getMaterialNo());
        if(oldSwStockInfo==null){
            swStockInfo.setVersion(0);
            saveNum=swStockInfoMapper.insertSelective(swStockInfo);
        }else{

            swStockInfo.setVersion(oldSwStockInfo.getVersion());
            saveNum=swStockInfoMapper.addNum(swStockInfo);
        }
        return  saveNum;
    }

    @Override
    public Page<SwStockInfoResultVo> findList(Map<String, String> params) {
        //日期查询条件
        //Condition serviceCondition = Common.getServiceCondition(params, SwStockInfo.class);
       // Page<SwStockInfo> swStockIns = (Page)findByCondition(serviceCondition);
        int pageNum = 1;    //当前页默认为1
        int pageSize = 5;   //默认每页显示5条
        String pageNumStr =  params.get("currPage");
        String pageSizeStr = params.get("pageSize");
        if(StringUtils.isNotBlank(pageNumStr)){
            pageNum = Integer.parseInt(pageNumStr);
        }
        if(StringUtils.isNotBlank(pageSizeStr)){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        String filter = params.get("filter");
        if(StringUtils.isNotBlank(filter)){
            try {
                JSONObject filterOjb = JSON.parseObject(filter);
                params.put("materialNo",filterOjb.getString("materialNo"));
                params.put("materialStock",filterOjb.getString("materialStock"));
                params.put("materialType",filterOjb.getString("materialType"));
            }catch (Exception e){
                throw new RRException("filter格式错误，请填写json格式");
            }
        }
        int startIndex=(pageNum-1)*pageSize;
        int endIndex=(pageNum-1)*pageSize+pageSize;
        params.put("startIndex",String.valueOf(startIndex));
        params.put("endIndex",String.valueOf(endIndex));
        int total=swStockInfoMapper.countByCondition(params);
        List<SwStockInfo> swStockIns=swStockInfoMapper.findList(params);
        int pages=total%pageSize==0?total/pageSize:total/pageSize+1;
        Page<SwStockInfoResultVo> swStockInfoResultVos= new Page<SwStockInfoResultVo>();
        swStockInfoResultVos.setPageSize(pageSize);
        swStockInfoResultVos.setPageNum(pageNum);
        swStockInfoResultVos.setPages(pages);
        swStockInfoResultVos.setTotal(total);
        for(SwStockInfo swStockInfo: swStockIns){
            SwStockInfoResultVo swStockInfoResultVo=new SwStockInfoResultVo();
            convertToVo(swStockInfo,swStockInfoResultVo);
            swStockInfoResultVos.add(swStockInfoResultVo);
        }
        return swStockInfoResultVos;
    }

    @Override
    public Result<List<SwStockInfoVo>> batchImport(MultipartFile mFile) {
        String originFileName=mFile.getOriginalFilename();
        String prefix=originFileName.substring(originFileName.indexOf("."));
        String saveFileName="/home/file/"+ UUIDUtils.genUUID("S")+prefix;
        InputStream importFile= null;
        try {
            importFile = mFile.getInputStream();
            FileUtil.saveFile(saveFileName,importFile);
            logger.info("保存文件:{}成功!",saveFileName);
            String keyValue = "物料编码:materialNo,物料名称:materialName,数量:num";
            Excel excel = new Excel(saveFileName);
            ExcelSheet sheet = excel.getSheet();
            List<SwStockInfoVo> swStockInfoVos = sheet.getList(0, 0, keyValue).toObject(SwStockInfoVo.class);
            for(SwStockInfoVo swStockInfoVo:swStockInfoVos){
                SwStockInfo swStockInfo=new SwStockInfo();
                swStockInfo.setMaterialNo(swStockInfoVo.getMaterialNo());
                swStockInfo.setNum(new BigDecimal(swStockInfoVo.getNum()));
                saveStock(swStockInfo);
            }
            logger.info("记录数据:{}成功!",saveFileName);
            FileUtil.delFile(saveFileName);
            return Result.newSuccess(swStockInfoVos);
        } catch (IOException e) {
            logger.error("IO异常:{}"+e.getMessage());
            return Result.newError(ResultCode.FAIL);
        }
    }

    @Override
    public Result<Integer> saveStockInfo(SwStockInfoVo swStockInfoVo) {
        SwStockInfo swStockInfo=new SwStockInfo();
        swStockInfo.setMaterialNo(swStockInfoVo.getMaterialNo());
        swStockInfo.setNum(new BigDecimal(swStockInfoVo.getNum()));
        return  Result.newSuccess( this.saveStock(swStockInfo));
    }

    @Override
    public List<SwStockInfoResultVo> findCond(Map<String, String> params) {
        String filter = params.get("filter");
        if(StringUtils.isNotBlank(filter)){
            try {
                JSONObject filterOjb = JSON.parseObject(filter);
                params.put("materialNo",filterOjb.getString("materialNo"));
                params.put("materialStock",filterOjb.getString("materialStock"));
                params.put("materialType",filterOjb.getString("materialType"));
            }catch (Exception e){
                throw new RRException("filter格式错误，请填写json格式");
            }
        }
        List<SwStockInfo>  swStockInfos=swStockInfoMapper.selecByCond(params);
        List<SwStockInfoResultVo> swStockInfoResultVos=new ArrayList<>();
        for(SwStockInfo swStockInfo: swStockInfos){
            SwStockInfoResultVo swStockInfoResultVo=new SwStockInfoResultVo();
            convertToVo(swStockInfo,swStockInfoResultVo);
            swStockInfoResultVos.add(swStockInfoResultVo);
        }
        return swStockInfoResultVos;
    }

    private void convertToVo(SwStockInfo swStockInfo,SwStockInfoResultVo swStockInfoResultVo) {
        swStockInfoResultVo.setMaterialNo(swStockInfo.getMaterialNo());
        SwMaterialInfo swMaterialInfo=swMaterialInfoService.getEntityByNo(swStockInfo.getMaterialNo());
        swStockInfoResultVo.setMaterialName(swMaterialInfo.getMaterialName());
        swStockInfoResultVo.setMaterialLong(swMaterialInfo.getMaterialLong());
        swStockInfoResultVo.setMaterialWidth(swMaterialInfo.getMaterialWidth());
        swStockInfoResultVo.setMaterialType(swMaterialInfo.getMaterialType());
        swStockInfoResultVo.setMaterialStock(swMaterialInfo.getMaterialStock());
        SysDict sysDict=SysDictUtils.getValueByUniq(ConstantKey.MATERIAL_TYPE,swMaterialInfo.getMaterialType());
        swStockInfoResultVo.setMaterialTypeName(sysDict.getDictName());
        SysDict stocDict=SysDictUtils.getValueByUniq(ConstantKey.MATERIAL_STOCK,swMaterialInfo.getMaterialStock());
        swStockInfoResultVo.setMaterialStockName(stocDict.getDictName());
        swStockInfoResultVo.setPattern(swMaterialInfo.getPattern());
        swStockInfoResultVo.setSpec(swMaterialInfo.getSpec());
        swStockInfoResultVo.setUnit(swMaterialInfo.getUnit());
        swStockInfoResultVo.setNum(swStockInfo.getNum());
        swStockInfoResultVo.setModiTime(DateUtil.formatDateTime(swStockInfo.getModiTime()));
    }

    /**
     * 直接覆盖
     * @param swStockInfo
     * @return
     */
    public int saveStock(SwStockInfo swStockInfo) {
        int saveNum=0;
        swStockInfo.setModiTime(new Date());
        SwStockInfo oldSwStockInfo=swStockInfoMapper.selectByMaterialNo(swStockInfo.getMaterialNo());
        if(oldSwStockInfo==null){
            swStockInfo.setVersion(0);
            saveNum=swStockInfoMapper.insertSelective(swStockInfo);
        }else{
            swStockInfo.setVersion(oldSwStockInfo.getVersion());
            saveNum=swStockInfoMapper.updateByNo(swStockInfo);
        }
        return  saveNum;
    }
}
