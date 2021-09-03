package com.qyc.job.service;

import com.qyc.job.bean.SysJobLog;

import java.util.List;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/3 1:43 上午
 */
public interface SysJobSysService {
    void insertLog(SysJobLog sysJobLog);
    List<SysJobLog> selectAllLog();
    List<SysJobLog> select10Log();
}
