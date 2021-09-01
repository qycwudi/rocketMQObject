package com.qyc.design.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description: 从IOC获取bean实例
 * @author: qiangyuecheng
 * @date: 2021/9/1 1:01 下午
 */
@Component
public class SpringIOCUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("===setApplicationContext===");
        SpringIOCUtil.applicationContext = applicationContext;
    }

    public Object getBean(String beanName) {
        Object object = null;
        try {
            object = applicationContext.getBean(beanName);
        } catch (Exception e) {
            System.out.println("没有找到");
        } finally {
            return object;
        }
    }
}
