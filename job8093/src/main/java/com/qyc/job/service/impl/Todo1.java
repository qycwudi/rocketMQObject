package com.qyc.job.service.impl;

import com.qyc.job.bean.JobInfo;
import com.qyc.job.service.JobInfoService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/2 12:51 上午
 */
@Service
public class Todo1 {

    @Autowired
    private JobInfoService jobInfoService;

    public void todo11() {
        List<JobInfo> list = jobInfoService.showList();
        System.out.println("todo11");
    }
    public void todo12() {
        System.out.println("todo12");
    }
}
