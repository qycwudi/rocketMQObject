package com.qyc.job.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/2 6:32 下午
 */
@Data
public class SysJobLog implements Serializable {
    /** ID */
    @TableId(value = "job_log_id", type = IdType.ID_WORKER)
    private Long jobLogId;

    /** 任务名称 */
    private String jobName;

    /** 任务组名 */
    private String jobGroup;

    /** 调用目标字符串 */
    private String invokeTarget;

    /** 日志信息 */
    private String jobMessage;

    /** 执行状态（0正常 1失败） */
    private String status;

    /** 异常信息 */
    private String exceptionInfo;

    /** 开始时间 */
    private Date createTime;

    /** 停止时间 */
    private Date stopTime;
    
    /**
     * 执行时间
    */
    private Long execution;
}
