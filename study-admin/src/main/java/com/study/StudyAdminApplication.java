package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.dao")
public class StudyAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyAdminApplication.class, args);
    }
}
