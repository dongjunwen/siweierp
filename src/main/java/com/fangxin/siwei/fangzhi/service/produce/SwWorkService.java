package com.fangxin.siwei.fangzhi.service.produce;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.produce.SwWorkDetailVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Date:2017/11/15 0015 15:58
 * @Author lu.dong
 * @Description：
 **/
public interface SwWorkService {
    Result<List<SwWorkDetailVo>> batchImport(MultipartFile mFile);
}
