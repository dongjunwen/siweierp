package com.fangxin.siwei.fangzhi.vo.stock;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Date:2017/12/14 0014 18:07
 * @Author lu.dong
 * @Description：
 **/
public class SwStockInfoQueryVo {
    @ApiModelProperty(value = "所属仓库",required =false )
    private String materialStock;
    @ApiModelProperty(value = "物料类型",required =false )
    private String materialType;
    @ApiModelProperty(value = "物料编号",required =false )
    private String materialNo;

    public String getMaterialStock() {
        return materialStock;
    }

    public void setMaterialStock(String materialStock) {
        this.materialStock = materialStock;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }
}
