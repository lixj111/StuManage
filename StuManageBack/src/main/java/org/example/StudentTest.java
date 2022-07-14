package org.example;

import lombok.Data;

//lombok--可以给实体类编译后自动生成get、set、equals、tostring、带参构造等函数

@Data//可以给Student添加一个tostring方法
//@AllArgsConstructor//可以给添加一个有参构造，有报错？？？why

//演示作用，项目中无用
public class StudentTest {
    private long id;
    private String name;
    private int age;

    public StudentTest(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
