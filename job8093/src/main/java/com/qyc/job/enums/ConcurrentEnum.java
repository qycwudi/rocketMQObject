package com.qyc.job.enums;

import cn.hutool.core.text.replacer.StrReplacer;
import lombok.Data;

import java.util.Collection;

/**
 * 支持并发
 * @author: qiangyuecheng
 * @date: 2021/9/2 11:36 下午
 */
public enum ConcurrentEnum {
    /**
     * 支持并发
    */
    ZC("1","支持"),
    BZC("0","不支持");
    private final String code;
    private final String info;
    ConcurrentEnum(String code,String info){
        this.code = code;
        this.info = info;
    }
    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }

    public static String getConnection(String code){
        for (ConcurrentEnum concurrentEnum:ConcurrentEnum.values()){
            if(concurrentEnum.code.equals(code)){
                return concurrentEnum.getInfo();
            }
        }
        return "未找到";
    }
}
