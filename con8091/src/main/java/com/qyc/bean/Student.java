package com.qyc.bean;/**
 * @CreatAuthor: qiangyuecheng
 * @CreatDate: 2021/6/22 2:33 上午
 */

import lombok.Data;

import java.io.Serializable;

/**
 *@ClassName: Student
 *@Description:
 *@Author: qiangyuecheng
 *@Date: 2021/6/22 2:33 上午
 */
@Data
public class Student  implements Serializable {
    private String name;
    private Integer age;
}
