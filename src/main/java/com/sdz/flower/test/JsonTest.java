package com.sdz.flower.test;

import com.alibaba.fastjson.JSON;
import com.sdz.flower.pojo.Student;
import org.junit.jupiter.api.Test;

/** 字符串解析json格式
 * @author zhu
 */
public class JsonTest {
    @Test
    public void json(){
        String stu = "{'id':1314,'name':'小竹'}";
        //字符串转对象
        Student student1 = JSON.parseObject(stu, Student.class);
        System.out.println(student1);
        Student student = new Student();
        student.setSid(1314);
        student.setUsername("小明");
        //对象转json字符串
        String s = JSON.toJSONString(student);

        System.out.println(s);
    }
}
