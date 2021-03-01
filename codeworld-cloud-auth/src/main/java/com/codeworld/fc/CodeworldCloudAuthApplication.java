package com.codeworld.fc;

import com.codeworld.fc.common.utils.CodecUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties
@EnableCircuitBreaker
@EnableHystrix
public class CodeworldCloudAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeworldCloudAuthApplication.class, args);
    }

}
