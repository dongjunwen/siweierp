package com.fangxin.siwei.fangzhi.vo.produce;

import java.math.BigDecimal;

/**
 * @Date:2017/11/7 0007 14:21
 * @Author lu.dong
 * @Description：
 **/
public class SwReceiveDetailVo {
    private String recvSeqNo;

    private String materialNo;

    private String materialName;

    private String materialType;

    private String spec;

    private String pattern;

    private String unit;

    private BigDecimal num;

    public String getRecvSeqNo() {
        return recvSeqNo;
    }

    public void setRecvSeqNo(String recvSeqNo) {
        this.recvSeqNo = recvSeqNo;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
}
