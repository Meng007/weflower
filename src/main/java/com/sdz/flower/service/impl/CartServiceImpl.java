package com.sdz.flower.service.impl;

import com.sdz.flower.dao.CartDao;
import com.sdz.flower.dao.impl.CartDaoImpl;
import com.sdz.flower.pojo.Cart;
import com.sdz.flower.service.Cartservice;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 史德竹
 */
public class CartServiceImpl implements Cartservice {
    private CartDao cartDao = new CartDaoImpl();
    @Override
    public Integer addCart(Cart cart) {
        Integer i = null;
        try {
            i = cartDao.addCart(cart);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Cart> selectList() {
        List<Cart> carts = null;
        try {
            carts = cartDao.selectCartList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carts;
    }

    @Override
    public Integer deleteCart(Integer cid) {
        Integer i = null;
        try {
            i = cartDao.deleteCart(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
