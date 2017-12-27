package com.fangxin.siwei.fangzhi.service.produce;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.produce.SwWorkDetailVo;
import com.fangxin.siwei.fangzhi.vo.result.SwWorkDetailResultVo;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Date:2017/11/15 0015 15:58
 * @Author lu.dong
 * @Description：
 **/
public interface SwWorkService {
    Result<List<SwWorkDetailVo>> batchImport(MultipartFile mFile);

    Page<SwWorkDetailResultVo> findList(Map<String, String> params);

    Result<Integer> save(SwWorkDetailVo swWorkDetailVo);

    List<SwWorkDetailResultVo> findCond(Map<String, String> params);

    Result<Integer> deleteByWorkNos(String workNos);

    Result<Integer> deleteByIdstr(String ids);
}
