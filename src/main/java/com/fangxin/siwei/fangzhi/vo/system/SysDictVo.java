package com.fangxin.siwei.fangzhi.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
 * @Date:2017/10/24 0024 13:50
 * @Author lu.dong
 * @Description：
 **/
@ApiModel(value = "数据字典Vo SysDictVo")
public class SysDictVo  {

    @Length(max = 32,message = "字典类型长度不能超过32")
    @ApiModelProperty(value = "字典类型",required =false )
    private String dictType;
    @Length(max = 32,message = "字典代码长度不能超过32")
    @ApiModelProperty(value = "字典代码",required =false )
    private String dictCode;
    @Length(max = 64,message = "字典名称长度不能超过64")
    @ApiModelProperty(value = "字典名称",required =false )
    private String dictName;
    @Length(max = 128,message = "字典值长度不能超过128")
    @ApiModelProperty(value = "字典值",required =false )
    private String dictValue;
    @Length(max = 128,message = "字典描述长度不能超过128")
    @ApiModelProperty(value = "字典描述",required =false )
    private String dictDesc;
    @Length(max = 32,message = "上级字典代码长度不能超过32")
    @ApiModelProperty(value = "上级字典代码",required =false )
    private String fhDictCode;
    @Length(max = 128,message = "备注长度不能超过128")
    @ApiModelProperty(value = "备注",required =false )
    private String memo;

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    public String getFhDictCode() {
        return fhDictCode;
    }

    public void setFhDictCode(String fhDictCode) {
        this.fhDictCode = fhDictCode;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
