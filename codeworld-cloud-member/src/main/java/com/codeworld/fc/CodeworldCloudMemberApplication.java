package com.codeworld.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CodeworldCloudMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeworldCloudMemberApplication.class, args);
    }

}
