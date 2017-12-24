package com.fangxin.siwei.fangzhi.vo.produce;

import com.fangxin.siwei.fangzhi.common.excel.ExcelField;

import java.util.Date;

/**
 * @Date:2017/11/15 0015 16:57
 * @Author lu.dong
 * @Description：
 **/
public class SwWorkDetailVo {
    private Integer id;
    private String workNo;
    @ExcelField(title = "计件日期",sort = 1)
    private String workDate;
    @ExcelField(title = "订单号",sort = 2)
    private String orderNo;
    @ExcelField(title = "订单序号",sort = 3)
    private String orderSeqNo;
    @ExcelField(title = "工号",sort = 4)
    private String userNo;
    @ExcelField(title = "姓名",sort = 5)
    private String userName;
    private String stepNo;
    @ExcelField(title = "流程步骤",sort = 6)
    private String stepName;
    private String processNo;
    @ExcelField(title = "工艺",sort = 7)
    private String processName;
    @ExcelField(title = "单位",sort = 8)
    private String unit;
    @ExcelField(title = "数量",sort = 9)
    private String num;

    public SwWorkDetailVo() {
    }

    public SwWorkDetailVo(Integer id, String workDate, String orderNo, String orderSeqNo, String userNo, String userName, String stepNo, String stepName, String processNo, String processName, String unit, String num) {
        this.id = id;
        this.workDate = workDate;
        this.orderNo = orderNo;
        this.orderSeqNo = orderSeqNo;
        this.userNo = userNo;
        this.userName = userName;
        this.stepNo = stepNo;
        this.stepName = stepName;
        this.processNo = processNo;
        this.processName = processName;
        this.unit = unit;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderSeqNo() {
        return orderSeqNo;
    }

    public void setOrderSeqNo(String orderSeqNo) {
        this.orderSeqNo = orderSeqNo;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStepNo() {
        return stepNo;
    }

    public void setStepNo(String stepNo) {
        this.stepNo = stepNo;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
