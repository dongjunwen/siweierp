package com.fangxin.siwei.fangzhi.vo.stock;

import com.fangxin.siwei.fangzhi.common.enums.AuditActionEnum;
import com.fangxin.siwei.fangzhi.common.enums.RefuseTypeEnum;
import com.fangxin.siwei.fangzhi.common.enums.ReturnStatus;
import com.fangxin.siwei.fangzhi.common.enums.StockStatus;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Date:2017/11/8 0008 10:54
 * @Author lu.dong
 * @Description：
 **/
public class StockVerifyActionVo {
    /**
     * 审核单号
     */
    @ApiModelProperty(value = "入库单号列表",required =false )
    private List<String> orderNos;
    /**
     * 审核动作
     */
    @ApiModelProperty(value = "审核动作",required =false )
    private AuditActionEnum auditAction;
    /**
     * 当前状态
     */
    @ApiModelProperty(value = "当前状态",required =false )
    private StockStatus stockStatus;
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

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
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
