package com.sdz.flower.dao;

import com.sdz.flower.pojo.Student;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhu
 */
public interface StudentDao {
    Student selectStudentByName(String username) throws SQLException;
    Integer addStudent(Student student) throws SQLException;
    Integer updateStudent(Student student) throws SQLException;
    Integer deleteStudent(Integer sid) throws SQLException;
    List<Student> selectStudentList(Integer page,Integer row) throws SQLException;
    Integer selectCount() throws SQLException;
    Student selectStudentById(Integer id) throws SQLException;
}
