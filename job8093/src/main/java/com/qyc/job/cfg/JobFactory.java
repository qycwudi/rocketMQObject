package com.qyc.job.cfg;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.quartz.AdaptableJobFactory;

import javax.annotation.Resource;

/**
 * @description: 原因:定时任务Job的作业类中无法注入Service等由Spring容器所管理的Bean
 * @author: qiangyuecheng
 * @date: 2021/9/2 12:16 上午
 */
@Component
public class JobFactory extends AdaptableJobFactory{
    
    /**
     * 自动写入
    */
    @Resource
    private AutowireCapableBeanFactory capableBeanFactory;

    /**
     * 创建Job实例
    */
    @Override
    public Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
