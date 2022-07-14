package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

//演示作用，项目中无用
public class StuManage {
    public static void main(String[] args) {
        Gson gson = new Gson();
        List<StudentTest> students = new ArrayList<StudentTest>();
        StudentTest student = new StudentTest(11,"小",0);
        students.add(student);
        System.out.println(gson.toJson(student));
        System.out.println(gson.toJson(students));
    }

}
