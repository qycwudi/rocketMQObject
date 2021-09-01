package com.qyc.job.cfg;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.quartz.AdaptableJobFactory;

import javax.annotation.Resource;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/2 12:16 上午
 */
@Component
public class JobFactory extends AdaptableJobFactory{
    @Resource
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    public Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
