package com.fangxin.siwei.fangzhi.service.order;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.modal.SwOrderBase;
import com.fangxin.siwei.fangzhi.vo.SwOrderVo;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderResultVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Map; /**
 * @Date:2017/10/24 0024 14:48
 * @Author lu.dong
 * @Description：订单接口类
 **/
public interface SwOrderService {
    Result<Integer> create(SwOrderVo swOrderVo);

    Page<SwOrderResultVo> findList(Map<String, String> params);
}
