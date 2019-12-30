package com.sdz.flower.dao;

import com.sdz.flower.pojo.Admin;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhu
 */
public interface AdminDao {
    Integer addAdmin(Admin admin) throws SQLException;
    Integer updateAdmin(Admin admin) throws SQLException;
    Integer deleteAdmin(Integer aid) throws SQLException;
    Admin selectAdminByName(String username) throws SQLException;
    List<Admin> selectAdminList(Integer page,Integer row) throws SQLException;
    Integer selectCount() throws SQLException;
}
