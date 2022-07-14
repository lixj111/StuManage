package org.example.pojo;

import lombok.Data;

@Data//添加构造方法
public class Student {
    private long id;//对应数据库id的longint类型
    private String number;
    private String name;
    private int age;

    //语数英成绩
    private int chi;
    private int math;
    private int eng;
}
