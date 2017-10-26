package com.fangxin.siwei.fangzhi.vo.order;

import com.fangxin.siwei.fangzhi.common.enums.AuditActionEnum;
import com.fangxin.siwei.fangzhi.common.enums.DeliverStatus;
import com.fangxin.siwei.fangzhi.common.enums.OrderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Date:2017/10/25 0025 14:31
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "发货单审核Vo SwDeliverAuditVo")
public class SwDeliverAuditVo {
    /**
     * 审核单号
     */
    @ApiModelProperty(value = "发货单号列表",required =false )
    private List<String> deliverNos;
    /**
     * 审核动作
     */
    @ApiModelProperty(value = "审核动作",required =false )
    private AuditActionEnum auditAction;
    /**
     * 当前状态
     */
    @ApiModelProperty(value = "当前状态",required =false )
    private DeliverStatus deliverStatus;
    @ApiModelProperty(value = "审核描述",required =false )
    private String auditDesc;
    private String auditUserNo;
    private String auditUserName;


    public List<String> getDeliverNos() {
        return deliverNos;
    }

    public void setDeliverNos(List<String> deliverNos) {
        this.deliverNos = deliverNos;
    }

    public AuditActionEnum getAuditAction() {
        return auditAction;
    }

    public void setAuditAction(AuditActionEnum auditAction) {
        this.auditAction = auditAction;
    }

    public DeliverStatus getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(DeliverStatus deliverStatus) {
        this.deliverStatus = deliverStatus;
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
