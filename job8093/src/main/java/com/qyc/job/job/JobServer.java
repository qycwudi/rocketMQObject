package com.qyc.job.job;

import com.qyc.job.bean.JobInfo;
import com.qyc.job.util.BeanUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @description: 基于IOC容器的job
 * @author: qiangyuecheng
 * @date: 2021/9/2 6:17 下午
 */
public abstract class JobServer implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        JobInfo jobInfo = new JobInfo();
        BeanUtils.copyBeanProp(jobInfo,jobExecutionContext.getMergedJobDataMap().get("TASK_PROPERTIES"));
        try {
            doExecute(jobExecutionContext,jobInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void doExecute(JobExecutionContext context, JobInfo sysJob)throws Exception;
}
