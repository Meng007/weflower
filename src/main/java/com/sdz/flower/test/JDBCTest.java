package com.sdz.flower.test;

import com.sdz.flower.pojo.Student;
import com.sdz.flower.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * @author zhu
 */
public class JDBCTest {

    @Test
    public void test() throws SQLException {
        QueryRunner runner = new QueryRunner(DruidUtils.dataSource());
        String sql = "select * from student where id=?";
        Student stu = runner.query(sql, new BeanHandler<Student>(Student.class), 1);
        System.out.println(stu);

    }
}
