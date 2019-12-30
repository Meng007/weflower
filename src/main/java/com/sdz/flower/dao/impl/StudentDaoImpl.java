package com.sdz.flower.dao.impl;

import com.sdz.flower.dao.StudentDao;
import com.sdz.flower.pojo.Student;
import com.sdz.flower.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhu 学生数据访问 实现类
 */
public class StudentDaoImpl implements StudentDao {
    QueryRunner runner = new QueryRunner(DruidUtils.dataSource());
    @Override
    public Student selectStudentByName(String username) throws SQLException {
        String sql = "select * from student where username = ?";
        Student stu = runner.query(sql, new BeanHandler<>(Student.class), username);

        return stu;
    }

    @Override
    public Integer addStudent(Student student) throws SQLException {
        String sql = "insert into student (username,password,phone,address,email,updated) values(?,?,?,?,?,?)";
        Integer insert = runner.update(sql,new Object[]{
                student.getUsername(),
                student.getPassword(),
                student.getPhone(),
                student.getAddress(),
                student.getEmail(),
                student.getUpdated()
        });
        return insert;
    }

    /**
     *  更新操作
     * @param student 前端数据
     * @return 返回影响行数
     * @throws SQLException 异常
     */
    @Override
    public Integer updateStudent(Student student) throws SQLException {
        String sql = "update student set username=?,password=?,phone=?,email=?,address=?,updated=? where sid=?";
        int update = runner.update(sql, new Object[]{
                student.getUsername(),
                student.getPassword(),
                student.getPhone(),
                student.getEmail(),
                student.getAddress(),
                student.getUpdated(),
                student.getSid()
        });
        return update;
    }

    @Override
    public Integer deleteStudent(Integer sid) throws SQLException {
        String sql = "delete from student where sid = ?";
        int delete = runner.update(sql, sid);
        return delete;
    }

    @Override
    public List<Student> selectStudentList(Integer page, Integer row) throws SQLException {
        String sql = "select * from student where isDelete=1 limit ?,?";
        List<Student> stu = runner.query(sql, new BeanListHandler<>(Student.class), new Object[]{page, row});
        return stu;
    }

    @Override
    public Integer selectCount() throws SQLException {
        String sql = "select count(sid) from student where isDelete=1";
        Object count = runner.query(sql, new ScalarHandler<>());
        return Integer.parseInt(String.valueOf(count));
    }

    @Override
    public Student selectStudentById(Integer id) throws SQLException {
        String sql = "select * from student where sid = ?";
        Student stu = runner.query(sql, new BeanHandler<>(Student.class), id);
        return stu;
    }
}
