package com.ty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * spring-boot 启动类
 *
 * @author tian'yi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ServletComponentScan
@MapperScan("com.ty.*.mapper")
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

}

