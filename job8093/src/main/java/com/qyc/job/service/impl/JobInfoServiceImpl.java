package com.qyc.job.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qyc.job.bean.JobInfo;
import com.qyc.job.mapper.JobInfoMapper;
import com.qyc.job.service.JobInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/1 5:18 下午
 */
@Service
public class JobInfoServiceImpl extends ServiceImpl<JobInfoMapper, JobInfo> implements JobInfoService {

    @Override
    public List<JobInfo> showList() {
        QueryWrapper wrapper = new QueryWrapper();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public int updateJob(JobInfo jobInfo) {
        int i = baseMapper.updateById(jobInfo);
        return i;
    }

    @Override
    public int startNow(JobInfo jobInfo) {
        return 0;
    }

    @Override
    public int stopNow(JobInfo jobInfo) {
        return 0;
    }

    @Override
    public int addJob(JobInfo jobInfo) {
        return 0;
    }

    @Override
    public int push(JobInfo job) {
        return 0;
    }
}
