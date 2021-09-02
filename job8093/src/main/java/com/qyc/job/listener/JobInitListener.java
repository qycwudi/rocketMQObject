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

/**
 * CommandLineRunner接口被用作将其加入spring容器中时执行其run方法。
 * 多个CommandLineRunner可以被同时执行在同一个spring上下文中并且执行顺序是以order注解的参数顺序一致。
 * @author qiangyuecheng
 */
@Component
@Order(value = 1)
public class JobInitListener implements CommandLineRunner {

    @Resource
    private TaskServer taskServer;
    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("初始化Job列表");
            taskServer.initSchedule();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
