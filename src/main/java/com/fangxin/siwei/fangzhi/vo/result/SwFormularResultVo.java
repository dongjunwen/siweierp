package com.fangxin.siwei.fangzhi.vo.result;

import java.math.BigDecimal;

/**
 * @Date:2017/11/29 0029 14:20
 * @Author lu.dong
 * @Description：公式结果
 **/
public class SwFormularResultVo {
    private String formularNo;

    private String formularName;

    private String formularValue;

    private BigDecimal formularPrice;

    private String formularType;

    private BigDecimal calValue;

    public String getFormularNo() {
        return formularNo;
    }

    public void setFormularNo(String formularNo) {
        this.formularNo = formularNo;
    }

    public String getFormularName() {
        return formularName;
    }

    public void setFormularName(String formularName) {
        this.formularName = formularName;
    }

    public String getFormularValue() {
        return formularValue;
    }

    public void setFormularValue(String formularValue) {
        this.formularValue = formularValue;
    }

    public BigDecimal getFormularPrice() {
        return formularPrice;
    }

    public void setFormularPrice(BigDecimal formularPrice) {
        this.formularPrice = formularPrice;
    }

    public String getFormularType() {
        return formularType;
    }

    public void setFormularType(String formularType) {
        this.formularType = formularType;
    }

    public BigDecimal getCalValue() {
        return calValue;
    }

    public void setCalValue(BigDecimal calValue) {
        this.calValue = calValue;
    }
}
