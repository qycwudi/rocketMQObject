package com.qyc.design.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/1 11:53 上午
 */
@Data
public class FactoryInfo implements Serializable {
    private Long id;
    private String beanName;
}
