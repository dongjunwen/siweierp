package com.fangxin.siwei.fangzhi.vo.base;

import com.fangxin.siwei.fangzhi.common.validator.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

/**
 * @Date:2017/10/20 0020 17:51
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "物料操作实体 SwMaterialInfoVo")
public class SwMaterialInfoVo {

    @NotBlank(message = "物料编码不能为空",groups = {AddGroup.class})
    @Length(min = 1,max = 32,message = "物料编码长度不能超过32")
    @ApiModelProperty(value = "物料编码",required =true )
    private String materialNo;
    @Length(max = 32,message = "物料名称长度不能超过32")
    @ApiModelProperty(value = "物料名称",required =false )
    private String materialName;
    @Length(max = 32,message = "物料类型长度不能超过32")
    @ApiModelProperty(value = "物料类型",required =false )
    private String materialType;
    @Length(max = 100,message = "物料规格长度不能超过100")
    @ApiModelProperty(value = "物料规格",required =false )
    private String spec;
    @Length(max = 100,message = "物料型号长度不能超过100")
    @ApiModelProperty(value = "物料型号",required =false )
    private String pattern;
    @Length(max = 12,message = "物料单位长度不能超过12")
    @ApiModelProperty(value = "物料单位",required =false )
    private String unit;
    @Length(max = 128,message = "物料备注长度不能超过128")
    @ApiModelProperty(value = "备注",required =false )
    private String memo;
    @DecimalMin(value = "0.01",message = "单价最小金额为0.01")
    @ApiModelProperty(value = "备注",required =false )
    private BigDecimal price;
    @Length(max = 32,message = "所属仓库长度不能超过32")
    @ApiModelProperty(value = "所属仓库",required =false )
    private String materialStock;
    @DecimalMin(value = "0.01",message = "长度最小金额为0.01")
    @ApiModelProperty(value = "长度",required =false )
    private BigDecimal materialLong;
    @DecimalMin(value = "0.01",message = "宽度最小金额为0.01")
    @ApiModelProperty(value = "宽度",required =false )
    private BigDecimal materialWidth;

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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMaterialStock() {
        return materialStock;
    }

    public void setMaterialStock(String materialStock) {
        this.materialStock = materialStock;
    }

    public BigDecimal getMaterialLong() {
        return materialLong;
    }

    public void setMaterialLong(BigDecimal materialLong) {
        this.materialLong = materialLong;
    }

    public BigDecimal getMaterialWidth() {
        return materialWidth;
    }

    public void setMaterialWidth(BigDecimal materialWidth) {
        this.materialWidth = materialWidth;
    }
}
