package com.codeworld.fc.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName OrderExcelProperties
 * Description TODO
 * Author Lenovo
 * Date 2021/2/2
 * Version 1.0
**/
@Component
@ConfigurationProperties(prefix = "codeworld.order.excel")
@Data
public class OrderExcelProperties {

    private String title;
}
