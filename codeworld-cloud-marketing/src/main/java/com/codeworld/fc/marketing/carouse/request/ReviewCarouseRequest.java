package com.codeworld.fc.marketing.carouse.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * ClassName ReviewCarouseRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/2/24
 * Version 1.0
**/
@Data
public class ReviewCarouseRequest {

    /**
     * id
     */
    @NotNull(message = "Id为空")
    private Long id;

    /**
     * 审核状态
     */
    @NotNull(message = "审核状态为空")
    private Integer reviewStatus;

    /**
     * 开始时间
     */
    @NotNull(message = "开始时间为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    /**
     * 结束时间
     */
    @NotNull(message = "结束时间为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

}
