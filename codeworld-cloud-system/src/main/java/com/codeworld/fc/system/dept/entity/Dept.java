package com.codeworld.fc.system.dept.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Dept
 * Description 部门Model
 * Author Lenovo
 * Date 2020/11/26
 * Version 1.0
**/
@Data
@ApiModel("部门Model")
public class Dept {
    @ApiModelProperty("部门主键Id")
    private Long id;

    @ApiModelProperty("上级部门Id")
    private Long parentId;

    @ApiModelProperty("部门名称")
    private String title;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("部门简介")
    private String remarks;

    @ApiModelProperty("排序")
    private Integer sortNo;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
