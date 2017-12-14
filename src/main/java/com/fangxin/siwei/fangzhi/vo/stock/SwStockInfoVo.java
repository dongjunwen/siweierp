package com.fangxin.siwei.fangzhi.vo.stock;

import com.fangxin.siwei.fangzhi.common.excel.ExcelField;

import java.math.BigDecimal;

/**
 * @Date:2017/11/13 0013 10:52
 * @Author lu.dong
 * @Description：
 **/
public class SwStockInfoVo {
    @ExcelField(title = "物料编号",sort = 1)
    private String materialNo;
    @ExcelField(title = "物料名称",sort = 1)
    private String materialName;
    @ExcelField(title = "数量",sort = 1)
    private String num;

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
