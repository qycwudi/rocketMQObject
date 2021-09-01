package com.qyc.design.controller;

import com.qyc.design.server.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 工厂方法controller层
 * @author: qiangyuecheng
 * @date: 2021/9/1 1:08 下午
 */
@RestController
@RequestMapping("/factory")
public class FactoryController {

    @Resource
    FactoryService factoryService;
    @GetMapping("/test1/{id}")
    public String test1(@PathVariable("id") String id){
        return factoryService.operate(id);
    }

}
