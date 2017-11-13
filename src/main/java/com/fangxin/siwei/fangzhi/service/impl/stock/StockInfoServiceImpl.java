package com.fangxin.siwei.fangzhi.service.impl.stock;

import com.fangxin.siwei.fangzhi.common.constant.ConstantKey;
import com.fangxin.siwei.fangzhi.common.utils.Common;
import com.fangxin.siwei.fangzhi.common.utils.DateUtil;
import com.fangxin.siwei.fangzhi.mapper.SwStockInfoMapper;
import com.fangxin.siwei.fangzhi.modal.SwMaterialInfo;
import com.fangxin.siwei.fangzhi.modal.SwOrderBase;
import com.fangxin.siwei.fangzhi.modal.SwStockInfo;
import com.fangxin.siwei.fangzhi.modal.SysDict;
import com.fangxin.siwei.fangzhi.service.AbstractService;
import com.fangxin.siwei.fangzhi.service.base.SwMaterialInfoService;
import com.fangxin.siwei.fangzhi.service.impl.system.SysDictUtils;
import com.fangxin.siwei.fangzhi.service.stock.SwStockInfoService;
import com.fangxin.siwei.fangzhi.vo.result.SwStockInfoResultVo;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
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
        List<SwStockInfo> swStockIns = findByCondition(serviceCondition);
        Page<SwStockInfoResultVo> swStockInfoResultVos= new Page<SwStockInfoResultVo>();
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
}
