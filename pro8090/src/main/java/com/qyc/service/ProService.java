package com.qyc.service;/**
 * @CreatAuthor: qiangyuecheng
 * @CreatDate: 2021/6/22 2:29 上午
 */

import com.qyc.bean.Student;
import org.apache.rocketmq.client.producer.SendCallback;
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

    public Student getStudent(String name){
        Student student = new Student();
        student.setName(name);
        student.setAge(23);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("获取-student");
        return student;
    }
    /**
        @Description: 发送同步消息
     */
    public void send(String name){
        SendResult sendResult = rocketMQTemplate.syncSend("test01",getStudent(name));
        System.out.println(sendResult.toString());
        System.out.println("return sendAsync");
    }
    
    /**
        @Description: 发送异步消息
     */
    public void sendAsync(String name){
        Student student = new Student();
        student.setName(name);
        student.setAge(23);
        SendCallback sendCallback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功："+sendResult.toString());
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送失败："+throwable.toString());
            }
        };
        rocketMQTemplate.asyncSend("test01", getStudent(name),sendCallback);
        System.out.println("return sendAsync");
    }
    /**
        @Description: 单向发送消息
     */
    
    /**
        @Description: 顺序消息生产
     */
    
    /**
        @Description: 延时消息生产
     */

    /**
        @Description: 批量消息
     */

    /**
        @Description: 消息事务
     */


}
