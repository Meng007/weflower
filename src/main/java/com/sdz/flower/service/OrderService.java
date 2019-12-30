package com.sdz.flower.service;

import com.sdz.flower.pojo.Order;

import java.util.List;

/**
 * @author 猪猪侠
 */
public interface OrderService {
    Integer addOrder(Order order);
    List<Order> pageList();
    Integer deleteOrder(Integer oid);
}
