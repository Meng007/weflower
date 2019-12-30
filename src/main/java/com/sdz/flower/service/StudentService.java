package com.sdz.flower.service;

import com.sdz.flower.bean.PageInfo;
import com.sdz.flower.pojo.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhu
 */
public interface StudentService {
    Integer register(Student student);
    Integer login(String username,String password);
    PageInfo<Student> pageList(Integer page, Integer row) throws SQLException;
    Student selectStudentByName(String name);
    Integer deleteStudent(Integer id);
    Student selectStudentById(Integer sid);
    Integer updateStudent(Student student);

}
