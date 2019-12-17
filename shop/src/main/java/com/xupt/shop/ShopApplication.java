package com.xupt.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collection;

@ComponentScan(basePackages = "com.xupt.shop.demo")
@ComponentScan(basePackages = "com.xupt.shop.service")
@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }
}
