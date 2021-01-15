package com.codeworld.fc.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "codeworld.worker")
@Component
@Data
@Primary
public class IdWorkerProperties {

    private long workerId;// 当前机器id

    private long datacenterId;// 序列号

}
