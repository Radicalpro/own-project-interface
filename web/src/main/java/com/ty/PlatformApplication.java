package com.ty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * spring-boot 启动类
 *
 * @author tianyi
 * @since 2019-02-02
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

}

