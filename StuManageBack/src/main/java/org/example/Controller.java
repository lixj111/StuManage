package org.example;

import com.google.gson.Gson;
import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*", "null"})
@SuppressWarnings("all") //把所有警告去掉
@RestController
public class Controller {
    @Autowired //自动连线，Mybatis plus自动找mapper，对映上实体，连接到数据库

    StudentMapper studentMapper;//这里要是报错，可以在StudentMapper接口上添加Repository

    private Gson gson = new Gson();
    //配置路由规则
    @GetMapping("/students")
    public String getStudents(){
        List<Student> students = studentMapper.selectList(null);
        return gson.toJson(students);
    }

    //增改删都用post方法
    @PostMapping("/delete")
    public void deleteStudent(@RequestBody Student student){
        studentMapper.deleteById(student);
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
        studentMapper.insert(student);
    }

    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student){//接收请求体，从前端传过来的数据
        studentMapper.updateById(student);
    }
}
