package com.codeworld.fc.logistics.response;

import com.codeworld.fc.logistics.domain.LogisticsInformation;
import com.codeworld.fc.logistics.entity.Logistics;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * ClassName LogisticsInformationCollection
 * Description TODO
 * Author Lenovo
 * Date 2021/3/5
 * Version 1.0
**/
@Data
@ApiModel("物流信息集合")
public class LogisticsInformationCollection {

    @ApiModelProperty("状态")
    private Integer state;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("物流信息")
    private List<Logistics> logistics;

    @ApiModelProperty("物流基本信息")
    private LogisticsInformation information;

}
