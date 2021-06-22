package com.bnuz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.bnuz.mapper")
public class PropertySpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertySpringbootApplication.class, args);
    }

}
