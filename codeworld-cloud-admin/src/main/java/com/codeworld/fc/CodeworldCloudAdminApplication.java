package com.codeworld.fc;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class CodeworldCloudAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeworldCloudAdminApplication.class, args);
    }

}
