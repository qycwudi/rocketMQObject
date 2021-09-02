package com.qyc.job.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/1 4:56 下午
 */
@Data
public class JobInfo implements Serializable {
    private Long id;

    /**
     * 任务名
     */
    private String jobName;

    /**
     * 任务描述
     */
    private String description;

    /**
     * cron表达式
     */
    private String cronExpression;

    /**
     * 任务执行时调用哪个类的方法 包名+类名
     */
    private String beanClass;

    /**
     * 任务状态
     */
    private String jobStatus;

    /**
     * 任务分组
     */
    private String jobGroup;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateUser;

    /**
     * 更新时间
    */
    private Date updateTime;

    /**
     * 支持并发
    */
    private String  concurrent;

    /**
     * 执行方法
    */
    private String methodName;
}
