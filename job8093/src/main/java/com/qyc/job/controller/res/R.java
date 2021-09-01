package com.qyc.job.controller.res;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: qiangyuecheng
 * @date: 2021/9/1 6:28 下午
 */
@Data
public class R implements Serializable {
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;
}
