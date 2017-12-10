package com.fangxin.siwei.fangzhi.vo.produce;

import java.math.BigDecimal;

/**
 * @Date:2017/11/7 0007 14:20
 * @Author lu.dong
 * @Description：
 **/
public class SwReceiveBaseVo {

    private String recver;

    private String recvStatus;

    private String useWay;

    private BigDecimal num;

    private String memo;

    private String auditName;

    private String auditDesc;

    public String getRecver() {
        return recver;
    }

    public void setRecver(String recver) {
        this.recver = recver;
    }

    public String getRecvStatus() {
        return recvStatus;
    }

    public void setRecvStatus(String recvStatus) {
        this.recvStatus = recvStatus;
    }

    public String getUseWay() {
        return useWay;
    }

    public void setUseWay(String useWay) {
        this.useWay = useWay;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }
}
