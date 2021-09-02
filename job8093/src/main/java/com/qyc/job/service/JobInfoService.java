package com.qyc.job.service;

import com.qyc.job.bean.JobInfo;

import java.util.List;

/**
 * @description: job信息 CRUD接口
 * @author: qiangyuecheng
 * @date: 2021/9/1 5:20 下午
 */
public interface JobInfoService {
    List<JobInfo> showList();
    int updateJob(JobInfo jobInfo);
    int startNow(JobInfo jobInfo);
    int stopNow(JobInfo jobInfo);
    int addJob(JobInfo jobInfo);
    int push(JobInfo job);
    List<JobInfo> showAllJob();
}
