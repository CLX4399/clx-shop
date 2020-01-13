package com.clx;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author CLX
 * @date 2020/1/13 11:14.
 */
@EnableDiscoveryClient
@SpringCloudApplication
@MapperScan("com.clx.mapper")
public class ShopItemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopItemServiceApplication.class);
    }

}
