package com.fangxin.siwei.fangzhi.service.order;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.order.SwDeliverAuditVo;
import com.fangxin.siwei.fangzhi.vo.order.SwDeliverModiVo;
import com.fangxin.siwei.fangzhi.vo.order.SwDeliverVo;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderAuditVo;
import com.fangxin.siwei.fangzhi.vo.result.SwDeliverBaseResutVo;
import com.fangxin.siwei.fangzhi.vo.result.SwDeliverResultVo;
import com.github.pagehelper.Page;

import java.util.Map; /**
 * @Date:2017/10/26 0026 14:18
 * @Author lu.dong
 * @Description：
 **/
public interface SwDeliverService {
    Result<Integer> create(SwDeliverVo swDeliverVo);

    Page<SwDeliverBaseResutVo> findList(Map<String, String> params);

    Result<Integer> audit(SwDeliverAuditVo swDeliverAuditVo);

    SwDeliverResultVo getEntityByNo(String deliverNo);

    Result<Integer> update(SwDeliverModiVo swDeliverModiVo);
}
