package com.qyc.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/1 4:54 下午
 */
@SpringBootApplication
@MapperScan("com.qyc.job.mapper")
public class Main8093 {
    public static void main(String[] args) {
        SpringApplication.run(Main8093.class,args);
    }
}
