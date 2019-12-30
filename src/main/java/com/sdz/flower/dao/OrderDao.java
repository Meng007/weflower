package com.sdz.flower.dao;

import com.sdz.flower.pojo.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 🐖
 */
public interface OrderDao {

    Integer addOrder(Order order) throws SQLException;
    Integer deleteOreder(Integer oid) throws SQLException;

    Order selectOrderOne(Integer oid) throws SQLException;
    List<Order> selectOrderList(Integer page,Integer row) throws SQLException;
    List<Order> selectOrderList() throws SQLException;
}
