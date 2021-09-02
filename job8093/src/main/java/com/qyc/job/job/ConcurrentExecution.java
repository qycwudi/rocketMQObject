package com.qyc.job.job;

import com.qyc.job.bean.JobInfo;
import com.qyc.job.util.QuartzManager;
import org.quartz.JobExecutionContext;

/**
 * @description: 并发执行
 * @author: qiangyuecheng
 * @date: 2021/9/2 6:22 下午
 */
public class ConcurrentExecution extends JobServer{

    @Override
    public void doExecute(JobExecutionContext context, JobInfo sysJob) throws Exception{
        QuartzManager.invokeMethod(sysJob);
    }
}
