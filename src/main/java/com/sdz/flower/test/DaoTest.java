package com.sdz.flower.test;

import com.sdz.flower.dao.impl.OrderDaoImpl;
import com.sdz.flower.dao.impl.StudentDaoImpl;
import com.sdz.flower.pojo.Order;

import java.sql.SQLException;
import java.util.UUID;

/**
 * @author zhu
 */
public class DaoTest {

    public static void main(String[] args) throws SQLException {
        StudentDaoImpl dao = new StudentDaoImpl();
        OrderDaoImpl orderDao = new OrderDaoImpl();
        Order order = new Order();
        order.setStated("123");
        order.setSid(1);
        order.setNumbers(UUID.randomUUID().toString());
        order.setFid(1);
        Integer i = orderDao.addOrder(order);
        System.out.println(i);
        Integer integer = dao.selectCount();
        System.out.println(integer);
    }
}
