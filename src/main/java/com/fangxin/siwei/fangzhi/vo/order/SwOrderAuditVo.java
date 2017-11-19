package com.fangxin.siwei.fangzhi.vo.order;

import com.fangxin.siwei.fangzhi.common.enums.AuditActionEnum;
import com.fangxin.siwei.fangzhi.common.enums.OrderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Date:2017/10/25 0025 14:31
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "订单审核Vo SwOrderAuditVo")
public class SwOrderAuditVo {
    /**
     * 审核单号
     */
    @NotNull(message = "单号不能为空!")
    @ApiModelProperty(value = "订单号列表",required =true )
    private List<String> orderNos;
    /**
     * 审核动作
     */
    @ApiModelProperty(value = "审核动作",required =true )
    private AuditActionEnum auditAction;
    /**
     * 当前状态
     */
    @ApiModelProperty(value = "当前状态",required =false )
    private OrderStatus orderStatus;
    @ApiModelProperty(value = "审核描述",required =false )
    private String auditDesc;
    private String auditUserNo;
    private String auditUserName;


    public List<String> getOrderNos() {
        return orderNos;
    }

    public void setOrderNos(List<String> orderNos) {
        this.orderNos = orderNos;
    }

    public AuditActionEnum getAuditAction() {
        return auditAction;
    }

    public void setAuditAction(AuditActionEnum auditAction) {
        this.auditAction = auditAction;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getAuditUserNo() {
        return auditUserNo;
    }

    public void setAuditUserNo(String auditUserNo) {
        this.auditUserNo = auditUserNo;
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }


}
