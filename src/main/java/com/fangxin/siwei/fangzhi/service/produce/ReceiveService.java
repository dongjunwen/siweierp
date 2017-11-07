package com.fangxin.siwei.fangzhi.service.produce;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.produce.SwReceiveAuditVo;
import com.fangxin.siwei.fangzhi.vo.produce.SwReceiveModiVo;
import com.fangxin.siwei.fangzhi.vo.produce.SwReceiveVo;
import com.fangxin.siwei.fangzhi.vo.result.SwReceiveBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwReceiveResultVo;
import com.github.pagehelper.Page;

import java.util.Map; /**
 * @Date:2017/11/7 0007 14:18
 * @Author lu.dong
 * @Description：
 **/
public interface ReceiveService {
    Result<Integer> audit(SwReceiveAuditVo swReceiveAuditVo);

    Result<Integer> create(SwReceiveVo swReceiveVo);

    Result<Integer> update(SwReceiveModiVo swReceiveModiVo);

    Page<SwReceiveBaseResultVo> findList(Map<String, String> params);

    SwReceiveResultVo getEntityByNo(String purNo);
}
