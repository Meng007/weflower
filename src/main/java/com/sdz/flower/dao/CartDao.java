package com.sdz.flower.dao;

import com.sdz.flower.pojo.Cart;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.SQLException;
import java.util.List;

/** 购物车 数据访问接口
 * @author  zhu
 */
public interface CartDao {

    Integer addCart(Cart cart) throws SQLException;
    Integer deleteCart(Integer cid) throws SQLException;

    Cart selectCart(Integer cid) throws SQLException;
    List<Cart> selectCartList(Integer page,Integer row) throws SQLException;
    List<Cart> selectCartList() throws SQLException;
}
