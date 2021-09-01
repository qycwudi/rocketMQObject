package com.qyc.design.test;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.qyc.design.bean.FactoryInfo;
import com.qyc.design.bean.JsonPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/1 2:24 下午
 */
public class Test1 {
    public static void main(String[] args) {
        JsonPojo jsonPojo = new JsonPojo();
        jsonPojo.setId("1");
        jsonPojo.setName("强月城");

        FactoryInfo factoryInfo = new FactoryInfo();
        factoryInfo.setId(2L);
        factoryInfo.setBeanName("factoryMethods2Impl");

        jsonPojo.setFactoryInfo(factoryInfo);
        List<String> list = new ArrayList<>();
        list.add("第一");
        list.add("第二");
        list.add("第三");
        jsonPojo.setChildren(list);
        String json = JSONUtil.toJsonStr(jsonPojo);
        System.out.println(json);
        JSONObject jsonObject = JSONUtil.parseObj(json);
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.get("children"));

    }
}
