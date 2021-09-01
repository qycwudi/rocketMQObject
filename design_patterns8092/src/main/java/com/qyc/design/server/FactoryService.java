package com.qyc.design.server;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qyc.design.bean.FactoryInfo;
import com.qyc.design.factory.FactoryMethod;
import com.qyc.design.mapper.FactoryMapper;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/1 11:56 上午
 */
@Service
public class FactoryService extends ServiceImpl<FactoryMapper, FactoryInfo> {
    public String operate(String id){
        FactoryInfo factoryPojo = baseMapper.selectById(id);
        if(factoryPojo==null){
            return "没有记录";
        }
        FactoryMethods factoryMethods = FactoryMethod.init(factoryPojo.getBeanName());
        try {
            return factoryMethods.todo();
        }catch (Exception e){
            return "执行方法错误";
        }
    }
}
