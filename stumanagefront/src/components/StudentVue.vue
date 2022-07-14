<template>
    <tr>
    
        <td v-show="!is_edit">{{student.number}}</td>
        <td v-show="!is_edit">{{student.name}}</td>
        <td v-show="!is_edit">{{student.age}}</td>
        <td v-show="!is_edit">{{student.chi}}</td>
        <td v-show="!is_edit">{{student.math}}</td>
        <td v-show="!is_edit">{{student.eng}}</td>
        <td v-show="!is_edit">
            <el-button type="primary" icon="el-icon-edit" circle @click="modify"></el-button>
        </td>
        <td v-show="!is_edit">
            <el-button type="danger" icon="el-icon-delete" circle @click="deleteStudent"></el-button>
        </td>

        <td v-show="is_edit"><input class="w-50" type="text" v-model="student.number"/></td>
        <td v-show="is_edit"><input class="w-50" type="text" v-model="student.name"/></td>
        <td v-show="is_edit"><input class="w-50" type="text" v-model.number="student.age"/></td>
        <!-- v-model.number：输入框输入的数字会被识别为string，加上.number将其转换为number -->
        <td v-show="is_edit"><input class="w-50" type="text" v-model.number="student.chi"/></td>
        <td v-show="is_edit"><input class="w-50" type="text" v-model.number="student.math"/></td>
        <td v-show="is_edit"><input class="w-50" type="text" v-model.number="student.eng"/></td>
        <td v-show="is_edit">
            <el-button type="primary" icon="el-icon-edit" circle @click="save"></el-button>
        </td>
        <td v-show="is_edit">
            <el-button type="primary" icon="el-icon-edit" circle @click="save"></el-button>
        </td>

    </tr>
</template>

<script>
import axios from 'axios';
export default {
    props:["student"],
    data(){
        return{
            is_edit:false
        }
    },
    methods:{
        modify(){
            this.is_edit=true;
        },
        save(){
            axios({
                url:"http://localhost:8080/update",
                method:"POST",
                data:this.student
            }).then(res=>{
                this.is_edit=false;
            })
        },
        deleteStudent(){
            axios({
                url:"http://localhost:8080/delete",
                method:"POST",
                data:this.student
            }).then(res=>{
                location.reload();
            })
        }
    }
}
</script>

<style>

</style>