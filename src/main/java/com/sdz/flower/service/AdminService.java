package com.sdz.flower.service;

import com.sdz.flower.pojo.Admin;

import java.util.List;

/**
 * @author zhu
 */
public interface AdminService {
    Admin selectAdminByName(String name);
    Integer addAdmin(Admin admin);
    List<Admin> pageList(Integer page,Integer row);
    Integer updateAdmin(Admin admin);
    Integer deleteAdmin(Integer aid);
}
