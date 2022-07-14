<template>
  <div id="app">
    <div class="col-8 offset-2">
      <!-- bootstrap样式，让div内的占八列，左右偏移2列，达到居中 -->
      <table class="table caption-top table-hover table-striped">
        <caption class="text-center">
          <!-- 表名 -->
          <h1>学生管理系统</h1>
          <el-button type="primary" @click="getStudents">获取学生信息</el-button>

          <el-button type="warning" @click="dialogVisible = true">添加学生</el-button>
          <el-dialog title="提示" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
            <div>添加学生信息</div>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="addStudent">添 加</el-button>
            </span>
            <div><span>学号</span><input v-model="newStudent.number"/></div>
            <div><span>姓名</span><input v-model="newStudent.name"/></div>
            <div><span>年龄</span><input v-model.number="newStudent.age"/></div>
            <div><span>语文</span><input v-model.number="newStudent.chi"/></div>
            <div><span>数学</span><input v-model.number="newStudent.math"/></div>
            <div><span>英语</span><input v-model.number="newStudent.eng"/></div>
          </el-dialog>
        </caption>
        <thead>
          <!-- 表头 -->
          <tr>
            <td ><span>学号</span></td>
            <td ><span>姓名</span></td>
            <td ><span>年龄</span></td>
            <td ><span>语文</span></td>
            <td ><span>数学</span></td>
            <td ><span>英语</span></td>
            <td colspan="2" class="text-center"><span>操作</span></td>
          </tr>
        </thead>
        <tbody>
          <StudentVue v-for="stu in students_for_page" :key="stu.id" :student="stu">
          </StudentVue>
        </tbody>
      </table>
      <div class="text-center">
        <el-button-group>
        <el-button type="primary" icon="el-icon-arrow-left" @click="last_page">上一页</el-button>
        <el-button type="primary" @click="next_page">下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
      </el-button-group>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import StudentVue from "./components/StudentVue";
export default {
  name: "App",
  components: {
    StudentVue,
  },
  data() {
    return {
      page:1,
      students: [],
      dialogVisible: false ,
      newStudent:{
        number:"",
        name:"",
        age:"",
        chi:"",
        math:"",
        eng:"",
      }
    };
  },
  methods: {
    getStudents() {
      axios({
        url: "http://localhost:8080/students",
        method: "GET",
      }).then((res) => {
        console.log(res.data);
        this.students = res.data;
      });
    },
    handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
    },
    addStudent(){
      axios({
        url: "http://localhost:8080/add",
        method: "POST",
        data:this.newStudent
      }).then((res) => {
        this.dialogVisible = false;
      });
    },
    next_page(){
      this.page+=1;
    },
    last_page(){
      this.page-=1;
    },
  },
  computed:{
    students_for_page(){
      return this.students.slice(this.page*5-5,this.page*5);
    }
  }
}
</script>

<style>
</style>
