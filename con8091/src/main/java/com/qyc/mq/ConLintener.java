package com.qyc.mq;/**
 * @CreatAuthor: qiangyuecheng
 * @CreatDate: 2021/6/22 2:32 上午
 */

import com.qyc.bean.Student;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *@ClassName: ConLintener
 *@Description:
 *@Author: qiangyuecheng
 *@Date: 2021/6/22 2:32 上午
 */
@Component
@RocketMQMessageListener(topic = "test01",consumerGroup = "CGroup1")
public class ConLintener implements RocketMQListener<Student> {
    @Override
    public void onMessage(Student student) {
        System.out.println("监听："+student);
    }
}
