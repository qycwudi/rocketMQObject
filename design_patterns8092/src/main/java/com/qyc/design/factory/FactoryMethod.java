package com.qyc.design.factory;

import com.qyc.design.server.FactoryMethods;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 根据beanName从IOC容器中获取对象
 * @author: qiangyuecheng
 * @date: 2021/9/1 12:03 下午
 */

public class FactoryMethod {
    public static FactoryMethods init(String beanName){
        SpringIOCUtil springIOCUtil = new SpringIOCUtil();
        return (FactoryMethods)springIOCUtil.getBean(beanName);
    }
}
