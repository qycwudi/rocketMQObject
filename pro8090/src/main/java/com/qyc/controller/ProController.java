package com.qyc.controller;/**
 * @CreatAuthor: qiangyuecheng
 * @CreatDate: 2021/6/22 2:27 上午
 */

import com.qyc.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName: ProController
 *@Description:
 *@Author: qiangyuecheng
 *@Date: 2021/6/22 2:27 上午
 */
@RestController
@RequestMapping("pro")
public class ProController {
    @Autowired
    private ProService proService;
    @GetMapping("send/{name}")
    public String send(@PathVariable("name") String name){
        proService.send(name);
        return "success";
    }
}
