package com.clx;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author CLX
 * @date 2020/1/12 23:28.
 */
@EnableZuulProxy
@SpringCloudApplication
public class ShopGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopGateWayApplication.class);
    }
}
