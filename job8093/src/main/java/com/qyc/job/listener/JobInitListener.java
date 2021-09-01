package com.qyc.job.listener;



import com.qyc.job.service.TaskServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/2 12:07 上午
 */
@Component
@Order(value = 1)
public class JobInitListener implements CommandLineRunner {

    @Resource
    private TaskServer taskServer;
    @Override
    public void run(String... args) throws Exception {
        try {
            taskServer.initSchedule();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
