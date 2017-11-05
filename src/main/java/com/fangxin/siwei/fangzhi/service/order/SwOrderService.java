package com.fangxin.siwei.fangzhi.service.order;

import com.fangxin.siwei.fangzhi.common.result.Result;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderAuditVo;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderModiVo;
import com.fangxin.siwei.fangzhi.vo.order.SwOrderVo;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderBaseResultVo;
import com.fangxin.siwei.fangzhi.vo.result.SwOrderResultVo;
import com.github.pagehelper.Page;

import java.util.Map; /**
 * @Date:2017/10/24 0024 14:48
 * @Author lu.dong
 * @Description：订单接口类
 **/
public interface SwOrderService {
    /**
     * 创建合同接口
     * @param swOrderVo
     * @return
     */
    Result<Integer> create(SwOrderVo swOrderVo);

    /**
     * 查询列表
     * @param params
     * @return
     */
    Page<SwOrderBaseResultVo> findList(Map<String, String> params);

    /**
     * 订单审核
     * @param swOrderAuditVo
     * @return
     */
    Result<Integer> audit(SwOrderAuditVo swOrderAuditVo);

    /**
     * 按照订单号查询详情
     * @param orderNo
     * @return
     */
    SwOrderResultVo getEntityByNo(String orderNo);

    Result<Integer> update(SwOrderModiVo swOrderModiVo);
}
