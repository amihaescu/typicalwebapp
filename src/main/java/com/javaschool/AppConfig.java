package com.javaschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(excludeFilters = @ComponentScan.Filter(Configuration.class))
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class);
    }


}
