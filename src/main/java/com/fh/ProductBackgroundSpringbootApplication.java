package com.fh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fh.*.*.mapper")
@MapperScan("com.fh.*.mapper")
public class ProductBackgroundSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductBackgroundSpringbootApplication.class, args);
    }

}
