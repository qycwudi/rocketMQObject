package com.qyc.job.job;

import cn.hutool.json.JSONUtil;
import com.qyc.job.bean.JobInfo;
import com.qyc.job.bean.SysJobLog;
import com.qyc.job.service.impl.SysJobLogServiceImpl;
import com.qyc.job.socket.JobWebSocketServer;
import com.qyc.job.util.BeanUtils;
import com.qyc.job.util.SpringIOCUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @description: 基于IOC容器的job
 * @author: qiangyuecheng
 * @date: 2021/9/2 6:17 下午
 */
public abstract class JobServer implements Job {

    private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();
    private void before(){
        threadLocal.set(new Date());
    }

    private void after(JobInfo job){
        SysJobLogServiceImpl log = null;
        try {
            log = (SysJobLogServiceImpl) SpringIOCUtil.getBean("sysJobLogServiceImpl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date startTime = threadLocal.get();
        threadLocal.remove();
        SysJobLog sysJobLog = new SysJobLog();
        sysJobLog.setCreateTime(startTime);
        sysJobLog.setExecution(System.currentTimeMillis()-startTime.getTime());
        sysJobLog.setJobGroup(job.getJobGroup());
        sysJobLog.setJobName(job.getJobName());
        sysJobLog.setInvokeTarget(job.getMethodName());
        sysJobLog.setJobMessage("运行正常");
        log.insertLog(sysJobLog);
        JobWebSocketServer socketServer = null;
        try {
            socketServer = (JobWebSocketServer) SpringIOCUtil.getBean("jobWebSocketServer");
        } catch (Exception e) {
            e.printStackTrace();
        }
        socketServer.sendMessageToAll(JSONUtil.toJsonStr(log.select10Log().get(0)));

    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        JobInfo jobInfo = new JobInfo();
        BeanUtils.copyBeanProp(jobInfo,jobExecutionContext.getMergedJobDataMap().get("TASK_PROPERTIES"));
        try {
            before();
            doExecute(jobExecutionContext,jobInfo);
            after(jobInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void doExecute(JobExecutionContext context, JobInfo sysJob)throws Exception;
}
