package com.clx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author CLX
 * @date 2020/1/21 14:43.
 */
@Configuration
public class CorsFliterConfig {

    @Bean
    public CorsFilter corsFilter() {

        //增加配置信息
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //配置为*的话，将无法使用cookie
        corsConfiguration.addAllowedOrigin("http://manage.clxshop.com");
        //是否发送cookie信息
        corsConfiguration.setAllowCredentials(true);
        //允许的方法
        corsConfiguration.addAllowedMethod("OPTIONS");
        corsConfiguration.addAllowedMethod("HEAD");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("PATCH");
        //允许的请求头
        corsConfiguration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(corsConfigurationSource);


    }

}

