package com.qyc.job.service.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/2 12:51 上午
 */
@Service
public class Todo2 implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("todo2:" + new Date());
    }
}