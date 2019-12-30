package com.sdz.flower.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.sdz.flower.dao.CartDao;
import com.sdz.flower.pojo.Cart;
import com.sdz.flower.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author  zhuzhu
 */
public class CartDaoImpl implements CartDao {
    QueryRunner runner = new QueryRunner(DruidUtils.dataSource());
    @Override
    public Integer addCart(Cart cart) throws SQLException {
        String sql ="insert into cart (sid,fid,count,price) values(?,?,?,?)";
        int update = runner.update(sql, new Object[]{cart.getSid(),cart.getFid(),cart.getCount(),cart.getPrice()});
        return update;
    }

    @Override
    public Integer deleteCart(Integer cid) throws SQLException {
        String sql = "update cart set isDelete = 0 where cid=?";
        int update = runner.update(sql, cid);
        return update;
    }

    @Override
    public Cart selectCart(Integer cid) throws SQLException {
        String sql = "select * from cart where isDelete=1 and cid = ?";
        Cart cart = runner.query(sql, new BeanHandler<>(Cart.class), cid);
        return cart;
    }

    @Override
    public List<Cart> selectCartList(Integer page, Integer row) throws SQLException {
        String sql = "select * from cart where isDelete=1 limit ?,?";
        List<Cart> carts = runner.query(sql, new BeanListHandler<>(Cart.class), new Object[]{page, row});
        return carts;
    }

    @Override
    public List<Cart> selectCartList() throws SQLException {
        String sql = "select * from cart where isDelete=1 ";
        List<Cart> carts = runner.query(sql, new BeanListHandler<>(Cart.class));
        return carts;
    }
}
