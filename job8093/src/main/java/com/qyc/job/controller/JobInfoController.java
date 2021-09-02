package com.qyc.job.controller;

import com.qyc.job.bean.JobInfo;
import com.qyc.job.controller.res.R;
import com.qyc.job.service.JobInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/1 5:27 下午
 */
@RestController
@RequestMapping("job")
public class JobInfoController {
    @Resource
    private JobInfoService jobInfoService;

    /**
     * 查看job列表
    */
    @GetMapping("showJobList")
    public R showJobList(){
        List<JobInfo> list = jobInfoService.showList();
        R r = new R();
        r.setCode(0);
        r.setMsg("成功");
        r.setData(list);
        return r;
    }

    /**
     * 修改
    */
    @RequestMapping("update")
    public R update(@RequestBody JobInfo job){

        R r = new R();
        if(jobInfoService.updateJob(job)==1){
            r.setCode(0);
            r.setMsg("成功");
            r.setData("");
        }else {
            r.setCode(1);
            r.setMsg("失败");
            r.setData("");
        }
        return r;
    }

    /**
     * 启动
    */
    @RequestMapping("start")
    public R start(@RequestBody JobInfo job){
        System.out.println("start:"+job);
        R r = new R();
        if(jobInfoService.startNow(job)==1){
            r.setCode(0);
        }else {
            r.setCode(1);
        }
        return r;
    }

    /**
     * 停止
    */
    @RequestMapping("stop")
    public R stop(@RequestBody JobInfo job){
        System.out.println("stop:"+job);

        R r = new R();
        if(jobInfoService.stopNow(job)==1){
            r.setCode(0);
        }else {
            r.setCode(1);
        }
        return r;
    }

    /**
     * 触发
    */
    @RequestMapping("push")
    public R push(@RequestBody JobInfo job){
        System.out.println("push:"+job);

        R r = new R();
        if(jobInfoService.push(job)==1){
            r.setCode(0);
        }else {
            r.setCode(1);
        }
        return r;
    }

    /**
     * 获取注册的JOB
    */
    @RequestMapping("getAllJob")
    public R getAllJob(){
        List<JobInfo> list = jobInfoService.showAllJob();
        for (JobInfo job :
                list) {
            System.out.println(job);
        }
        R r = new R();
        return r;
    }

}
