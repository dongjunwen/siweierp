package com.fangxin.siwei.fangzhi.service.order;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.SwOrderVo; /**
 * @Date:2017/10/24 0024 14:48
 * @Author lu.dong
 * @Description：订单接口类
 **/
public interface SwOrderService {
    Result<Integer> create(SwOrderVo swOrderVo);
}
