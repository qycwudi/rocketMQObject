package com.qyc.service;/**
 * @CreatAuthor: qiangyuecheng
 * @CreatDate: 2021/6/22 2:29 上午
 */

import com.qyc.bean.Student;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *@ClassName: ProService
 *@Description:
 *@Author: qiangyuecheng
 *@Date: 2021/6/22 2:29 上午
 */
@Component
public class ProService {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    public void send(String name){
        Student student = new Student();
        student.setName(name);
        student.setAge(23);
        SendResult sendResult = rocketMQTemplate.syncSend("test01",student);
        System.out.println(sendResult.toString());
    }
}
