package com.clx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author CLX
 * @date 2020/1/12 22:54.
 */
@SpringBootApplication
@EnableEurekaServer
public class ShopRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopRegistryApplication.class);
    }
}
