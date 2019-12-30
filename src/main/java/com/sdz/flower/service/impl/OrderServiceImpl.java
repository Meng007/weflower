package com.sdz.flower.service.impl;

import com.sdz.flower.dao.FlowerDao;
import com.sdz.flower.dao.OrderDao;
import com.sdz.flower.dao.impl.FlowerDaoImpl;
import com.sdz.flower.dao.impl.OrderDaoImpl;
import com.sdz.flower.pojo.Order;
import com.sdz.flower.service.OrderService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author  zhu
 */
public class OrderServiceImpl  implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private FlowerDao flowerDao = new FlowerDaoImpl();
    @Override
    public Integer addOrder(Order order) {
        Integer i = null;
        try {
            i = orderDao.addOrder(order);
            Integer j = flowerDao.updateFlowerNum(order.getFid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Order> pageList() {
        List<Order> orders = null;
        try {
            orders = orderDao.selectOrderList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Integer deleteOrder(Integer oid) {
        Integer i = null;
        try {
            i = orderDao.deleteOreder(oid);
        } catch (SQLException e) {


        }
        return i;
    }
}
