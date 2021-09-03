package com.qyc.job.util;

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
public final class SpringIOCUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("===ApplicationContext===");
//        for (String beanName :
//                applicationContext.getBeanDefinitionNames()) {
//            System.out.println(beanName);
//        }
        SpringIOCUtil.applicationContext = applicationContext;
    }

    public static Object getBean(String beanName)throws Exception {
        Object object = null;
            object = applicationContext.getBean(beanName);
            return object;
    }
}
