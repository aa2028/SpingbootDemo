package com.softeem.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描mapper包
@MapperScan("com.softeem.springbootdemo.mapper")
public class SpingbootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpingbootDemoApplication.class, args);
    }

}
