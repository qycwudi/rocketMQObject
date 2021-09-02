package com.qyc.job.service;

import com.qyc.job.bean.JobInfo;
import com.qyc.job.util.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/2 12:11 上午
 */
@Service
public class TaskServer {

    @Resource
    private QuartzManager quartzmanager;
    @Resource
    private JobInfoService jobInfoService;

    public void initSchedule() {
        List<JobInfo> list = jobInfoService.showList();
        for (JobInfo job : list
        ) {
            //加载全部job
            quartzmanager.addJob(job);
        }

    }
}
