package com.qyc.design.server;

import org.springframework.stereotype.Component;

/**
 * 实现方法1
 * @author: qiangyuecheng
 * @date: 2021/9/1
 */
@Component
public class FactoryMethods1Impl implements FactoryMethods{

    @Override
    public String todo() {
        return "实现方法1";
    }
}
