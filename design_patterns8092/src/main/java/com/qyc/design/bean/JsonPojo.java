package com.qyc.design.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/1 2:25 下午
 */
@Data
public class JsonPojo implements Serializable {
    private String id;
    private String name;
    private FactoryInfo factoryInfo;
    private List<String> children;
}
