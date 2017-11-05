package com.fangxin.siwei.fangzhi.service.impl.system;

import com.fangxin.siwei.fangzhi.modal.SysDict;
import com.fangxin.siwei.fangzhi.service.system.SysDictService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    @Resource
    SysDictService sysDictService;

    private Map cacheDictMap=new HashMap<String,String>();


    public void loadDict(){
        List<SysDict> sysDictList=sysDictService.findList(null);
        for(SysDict sysDict:sysDictList){
            if(!cacheDictMap.containsKey(sysDict.getDictType())) {
                cacheDictMap.put(sysDict.getDictType(),sysDict);
            }else{

            }

        }
    }
}
