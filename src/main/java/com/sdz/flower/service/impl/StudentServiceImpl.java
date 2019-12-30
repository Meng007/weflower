package com.sdz.flower.service.impl;

import com.sdz.flower.bean.PageInfo;
import com.sdz.flower.dao.StudentDao;
import com.sdz.flower.dao.impl.StudentDaoImpl;
import com.sdz.flower.pojo.Flower;
import com.sdz.flower.pojo.Student;
import com.sdz.flower.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**  学生业务  实现类
 * @author zhu
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao  = new StudentDaoImpl();
    @Override
    public Integer register(Student student) {
        Integer integer=0;
        try {
            integer = studentDao.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer login(String username, String password) {
        return null;
    }

    @Override
    public PageInfo<Student> pageList(Integer page, Integer row) throws SQLException {
        PageInfo<Student> info = new PageInfo<>();
        info.setRecordsTotal(studentDao.selectCount());
        info.setRecordsFiltered(studentDao.selectCount());
        List<Student> stu = studentDao.selectStudentList(page, row);
        info.setData(stu);
        return info;
    }

    @Override
    public Student selectStudentByName(String name) {
        Student student=null;
        try {
            student = studentDao.selectStudentByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Integer deleteStudent(Integer id) {
        Integer integer = null;
        try {
            integer = studentDao.deleteStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Student selectStudentById(Integer sid) {
        Student student = null;
        try {
            student = studentDao.selectStudentById(sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Integer updateStudent(Student student) {
        Integer i = null;
        try {
            i = studentDao.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }
}
