package com.qyc.design;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/1 11:39 上午
 */
@SpringBootApplication
@MapperScan("com.qyc.design.mapper")
public class Main8092 {
    public static void main(String[] args) {
        SpringApplication.run(Main8092.class,args);
    }
}
