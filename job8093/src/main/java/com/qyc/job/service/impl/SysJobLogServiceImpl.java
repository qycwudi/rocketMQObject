package com.qyc.job.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qyc.job.bean.SysJobLog;
import com.qyc.job.mapper.SysJobLogMapper;
import com.qyc.job.service.SysJobSysService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/3 1:44 上午
 */
@Service
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements SysJobSysService {
    @Override
    public void insertLog(SysJobLog sysJobLog) {
        baseMapper.insert(sysJobLog);
    }

    @Override
    public List<SysJobLog> selectAllLog() {
        QueryWrapper wrapper = new QueryWrapper();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<SysJobLog> select10Log() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("create_time");
        wrapper.last("limit 1");
        return baseMapper.selectList(wrapper);
    }
}
