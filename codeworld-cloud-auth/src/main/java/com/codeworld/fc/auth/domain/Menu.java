package com.codeworld.fc.auth.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Menu
 * Description Ȩ�޲˵���
 * Author Lenovo
 * Date 2020/11/5
 * Version 1.0
**/
@Data
@ApiModel("Ȩ�޲˵���")
public class Menu {

    @ApiModelProperty("�˵�Id")
    private Long id;

    @ApiModelProperty("�ϼ�Id")
    private Long parentId;

    @ApiModelProperty("�˵�Url")
    private String url;

    @ApiModelProperty("�˵�����")
    private String title;

    @ApiModelProperty("�˵�����")
    private String resources;

    @ApiModelProperty("����")
    private String type;

    @ApiModelProperty("�˵����")
    private String remarks;

    @ApiModelProperty("����")
    private Integer sortNo;

    @ApiModelProperty("����ʱ��")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm",timezone = "GTM+8")
    private Date createTime;

    @ApiModelProperty("����ʱ��")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm",timezone = "GTM+8")
    private Date updateTime;
}
