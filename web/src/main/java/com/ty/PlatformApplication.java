package com.ty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * spring-boot 启动类
 *
 * @author tian'yi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

}

