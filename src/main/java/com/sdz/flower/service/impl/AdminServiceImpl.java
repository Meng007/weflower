package com.sdz.flower.service.impl;

import com.sdz.flower.dao.AdminDao;
import com.sdz.flower.dao.impl.AdminDaoImpl;
import com.sdz.flower.pojo.Admin;
import com.sdz.flower.service.AdminService;

import java.sql.SQLException;
import java.util.List;

/**
 *  管理员 业务实现
 * @author  zhu aini
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin selectAdminByName(String name) {
        Admin admin=null;
        try {
            admin = adminDao.selectAdminByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public Integer addAdmin(Admin admin) {

        Integer add = 0;
        try {
            add = adminDao.addAdmin(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return add;
    }

    @Override
    public List<Admin> pageList(Integer page, Integer row) {
        List<Admin> admins=null;
        try {
            admins = adminDao.selectAdminList((page - 1) * row, row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    @Override
    public Integer updateAdmin(Admin admin) {
        Integer update=0;
        try {
            update = adminDao.updateAdmin(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public Integer deleteAdmin(Integer aid) {
        Integer admin=0;
        try {
            admin = adminDao.deleteAdmin(aid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
