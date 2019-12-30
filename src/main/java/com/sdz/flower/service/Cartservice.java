package com.sdz.flower.service;

import com.sdz.flower.pojo.Cart;

import java.util.List;

public interface Cartservice {
    Integer addCart(Cart cart);
    List<Cart> selectList();
    Integer deleteCart(Integer cid);
}
