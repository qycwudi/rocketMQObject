package com.qyc.design.server;

import org.springframework.stereotype.Component;

/**
 * @description: 实现方法2
 * @author: qiangyuecheng
 * @date: 2021/9/1 12:54 下午
 */
@Component
public class FactoryMethods2Impl implements FactoryMethods{
    @Override
    public String todo() {
        return "实现方法2";
    }
}
