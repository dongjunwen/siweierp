package com.fangxin.siwei.fangzhi.service.impl.stock;

import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
import com.fangxin.siwei.fangzhi.common.enums.ResultCode;
import com.fangxin.siwei.fangzhi.common.excel.Excel;
import com.fangxin.siwei.fangzhi.common.excel.ExcelSheet;
import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.common.utils.*;
import com.fangxin.siwei.fangzhi.mapper.SwStockInfoMapper;
import com.fangxin.siwei.fangzhi.modal.*;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.base.SwMaterialInfoService;
import com.fangxin.siwei.fangzhi.service.impl.system.SysDictUtils;
import com.fangxin.siwei.fangzhi.service.stock.SwStockInfoService;
import com.fangxin.siwei.fangzhi.vo.produce.SwWorkDetailVo;
import com.fangxin.siwei.fangzhi.vo.result.SwStockInfoResultVo;
import com.fangxin.siwei.fangzhi.vo.stock.SwStockInfoVo;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        Condition serviceCondition = Common.getServiceCondition(params, SwStockInfo.class);
        Page<SwStockInfo> swStockIns = (Page)findByCondition(serviceCondition);
        Page<SwStockInfoResultVo> swStockInfoResultVos= new Page<SwStockInfoResultVo>();
        swStockInfoResultVos.setPageSize(swStockIns.getPageSize());
        swStockInfoResultVos.setPageNum(swStockIns.getPageNum());
        swStockInfoResultVos.setPages(swStockIns.getPages());
        swStockInfoResultVos.setTotal(swStockIns.getTotal());
        for(SwStockInfo swStockInfo: swStockIns){
            SwStockInfoResultVo swStockInfoResultVo=new SwStockInfoResultVo();
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
                swStockInfo.setModiTime(new Date());
                swStockInfo.setVersion(0);
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

    public int saveStock(SwStockInfo swStockInfo) {
        int saveNum=0;
        swStockInfo.setNum(swStockInfo.getNum());
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
