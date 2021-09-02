package com.qyc.job.util;

import com.qyc.job.bean.JobInfo;
import com.qyc.job.enums.ConcurrentEnum;
import com.qyc.job.enums.ScheduleConstants;
import com.qyc.job.enums.StatusEnum;
import com.qyc.job.job.ConcurrentExecution;
import com.qyc.job.job.Execution;
import com.qyc.job.service.impl.Todo1;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/2 12:45 上午
 */
@Service
public class QuartzManager {
    @Resource
    private Scheduler scheduler;


    /**
     * 添加任务
     *
     * @param task
     * @throws SchedulerException
     */
    @SuppressWarnings("unchecked")
    public void addJob(JobInfo task) {
        try {
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            Class<? extends Job> jobClass = getQuartzJobClass(task);
            System.out.println("jobClass.getName:"+jobClass.getName());
            JobKey jobKey = JobKey.jobKey(task.getJobName(), task.getJobGroup());
            // 任务名称和组构成任务key
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(task.getJobName(), task.getJobGroup()).build();
            //调用方法时使用
            jobDetail.getJobDataMap().put("TASK_PROPERTIES", task);
            // 表达式调度构建器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(task.getCronExpression());
            cronScheduleBuilder = cronScheduleBuilder.withMisfireHandlingInstructionDoNothing();

            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(task.getJobName(), task.getJobGroup())
                    .withSchedule(cronScheduleBuilder).build();

            // 把作业和触发器注册到任务调度中
            if(scheduler.checkExists(jobKey)){
                scheduler.deleteJob(jobKey);
            }
            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown()&& StatusEnum.RUN.getInfo().equals(task.getJobStatus())) {
                System.out.println("启动:"+task);
//                scheduler.start();
            }else {
                //暂停
                System.out.println("暂停:"+task);
                scheduler.pauseJob(jobKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取执行方式（是否并发）
    */
    private static Class<? extends Job> getQuartzJobClass(JobInfo sysJob)
    {
        boolean isConcurrent = ConcurrentEnum.ZC.getInfo().equals(sysJob.getConcurrent());
        return isConcurrent ? ConcurrentExecution.class : Execution.class;
    }

    /**
     * 设置定时任务策略
     */
    public static CronScheduleBuilder handleCronScheduleMisfirePolicy(JobInfo job, CronScheduleBuilder cb)

    {
        switch (job.getDescription())
        {
            case ScheduleConstants.MISFIRE_DEFAULT:
                return cb;
            case ScheduleConstants.MISFIRE_IGNORE_MISFIRES:
                return cb.withMisfireHandlingInstructionIgnoreMisfires();
            case ScheduleConstants.MISFIRE_FIRE_AND_PROCEED:
                return cb.withMisfireHandlingInstructionFireAndProceed();
            case ScheduleConstants.MISFIRE_DO_NOTHING:
                return cb.withMisfireHandlingInstructionDoNothing();
            default:
                return null;
        }
    }

    /**
     * 执行方法
    */
    public static void invokeMethod(JobInfo jobInfo){
        System.out.println("开始执行:"+jobInfo.getJobName());
        //获取加载的bean实例  暂不支持带参数
        String beanName = jobInfo.getBeanClass();
        String methodName = jobInfo.getMethodName();
        Object bean = SpringIOCUtil.getBean(beanName);
        System.out.println("获取bean:"+bean);
        try {
            Method method = bean.getClass().getMethod(methodName);
            method.invoke(bean);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取所有计划中的任务列表
     *
     * @return
     * @throws SchedulerException
     */
    public List<JobInfo> getAllJob() throws SchedulerException {
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
        List<JobInfo> jobList = new ArrayList<JobInfo>();
        for (JobKey jobKey : jobKeys) {
            List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
            for (Trigger trigger : triggers) {
                JobInfo job = new JobInfo();
                job.setJobName(jobKey.getName());
                job.setJobGroup(jobKey.getGroup());
                job.setDescription("触发器:" + trigger.getKey());
                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                job.setJobStatus(triggerState.name());
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    job.setCronExpression(cronExpression);
                }
                jobList.add(job);
            }
        }
        return jobList;
    }

}
