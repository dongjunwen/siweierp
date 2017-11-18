package com.fangxin.siwei.fangzhi.service.impl.system;

import com.fangxin.siwei.fangzhi.modal.SysDict;
import com.fangxin.siwei.fangzhi.service.system.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/5 0005 15:52
 * @Author lu.dong
 * @Description：
 **/
@Component
public class SysDictUtils {
    private static final Logger logger= LoggerFactory.getLogger(SysDictUtils.class);
    @Resource
    SysDictService sysDictService;

    private static Map<String,List<SysDict>> dictTypeMap=new HashMap<String,List<SysDict>>();

    private static Map<String,SysDict> dictCodeMap=new HashMap<String,SysDict>();


    @PostConstruct
    public void loadDict(){
        logger.info("==================数据字典初始化Begin=========================");
        List<SysDict> sysDictList=sysDictService.findAll();
        putDictTypeMap(sysDictList);
        putdictCodeMap(sysDictList);
        logger.info("==================数据字典初始化End=========================");
    }

    /**
     * 按照type,code存储
     * @param sysDictList
     */
    private void putdictCodeMap(List<SysDict> sysDictList) {
        for(SysDict sysDict:sysDictList){
            String key=sysDict.getDictType()+"-"+sysDict.getDictCode();
            dictCodeMap.put(key,sysDict);
        }
    }

    /**
     * 按照类型存储
     * @param sysDictList
     */
    private void putDictTypeMap(List<SysDict> sysDictList) {
        for(SysDict sysDict:sysDictList){
            if(!dictTypeMap.containsKey(sysDict.getDictType())) {
                List dictLists=new ArrayList();
                dictLists.add(sysDict);
                dictTypeMap.put(sysDict.getDictType(),dictLists);
            }else{
                List oldDictLists=dictTypeMap.get(sysDict.getDictType());
                oldDictLists.add(sysDict);
                dictTypeMap.put(sysDict.getDictType(),oldDictLists);
            }

        }
    }

    public static List<SysDict> getValueByType(String dictType){
        return  dictTypeMap.get(dictType);
    }

    public static SysDict getValueByUniq(String dictType,String dictValue){
        String key=dictType+"-"+dictValue;
        return  dictCodeMap.get(key);
    }

    public static String getNameByUniq(String dictType, String dictValue) {
        SysDict sysDict= getValueByUniq(dictType,dictValue);
        return sysDict.getDictName();
    }
}
