package com.codeworld.fc.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class CodeworldCloudSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeworldCloudSystemApplication.class, args);
    }
}
