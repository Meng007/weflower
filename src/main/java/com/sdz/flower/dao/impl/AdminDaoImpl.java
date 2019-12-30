package com.sdz.flower.dao.impl;

import com.sdz.flower.dao.AdminDao;
import com.sdz.flower.pojo.Admin;
import com.sdz.flower.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**  管理员 实现类
 * @author zhu
 */
public class AdminDaoImpl implements AdminDao {
    QueryRunner runner = new QueryRunner(DruidUtils.dataSource());

    @Override
    public Integer addAdmin(Admin admin) throws SQLException {
        String sql="insert into admin (username,password,email,phone) values(?,?,?,?)";
        int insert = runner.update(sql, new Object[]{
                admin.getUsername(),
                admin.getPassword(),
                admin.getEmail(),
                admin.getPhone()
        });

        return insert;
    }

    @Override
    public Integer updateAdmin(Admin admin) throws SQLException {
        String sql = "update admin set username=?,password=?,email=?,phone=? where aid=?";
        int update = runner.update(sql, new Object[]{
                admin.getUsername(),
                admin.getPassword(),
                admin.getEmail(),
                admin.getPhone(),
                admin.getAid()
        });
        return update;
    }

    @Override
    public Integer deleteAdmin(Integer aid) throws SQLException {
        String sql = "update admin set isDelete = 0 where aid =?";
        int delete = runner.update(sql, aid);
        return delete;
    }

    @Override
    public Admin selectAdminByName(String username) throws SQLException {
        String sql = "select * from admin where username=? and isDelete=1";
        Admin admin = runner.query(sql, new BeanHandler<>(Admin.class), username);
        return admin;
    }

    @Override
    public List<Admin> selectAdminList(Integer page, Integer row) throws SQLException {
        String sql = "select * from admin where isDelete=1 limit ?,?";
        List<Admin> adminList = runner.query(sql, new BeanListHandler<>(Admin.class), new Object[]{
                page, row
        });
        return adminList;
    }

    @Override
    public Integer selectCount() throws SQLException {
        String sql = "select count(aid) from admin where isDelete = 1";
        Object count = runner.query(sql, new ScalarHandler());
        return Integer.parseInt(String.valueOf(count));
    }
}
