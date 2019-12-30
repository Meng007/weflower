package com.sdz.flower.dao.impl;

import com.sdz.flower.dao.OrderDao;
import com.sdz.flower.pojo.Order;
import com.sdz.flower.utils.DruidUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author  史德竹
 */
public class OrderDaoImpl implements OrderDao {
    QueryRunner runner = new QueryRunner(DruidUtils.dataSource());
    @Override
    public Integer addOrder(Order order) throws SQLException {
        String sql = "insert into orders (numbers, fid,sid,stated) values(?,?,?,?)";
        int update = runner.update(sql, new Object[]{order.getNumbers(), order.getFid(), order.getSid(), order.getStated()});

        return update;
    }

    @Override
    public Integer deleteOreder(Integer oid) throws SQLException {
        String sql = "update order set isDelete=0 where oid=?";
        int update = runner.update(sql, oid);

        return update;
    }

    @Override
    public Order selectOrderOne(Integer oid) throws SQLException {
        String sql = "select * from order where isDelete=1 and oid=?";
        Order query = runner.query(sql, new BeanHandler<>(Order.class), oid);

        return query;
    }

    @Override
    public List<Order> selectOrderList(Integer page, Integer row) throws SQLException {
        String sql = "select * order where isDelete =1 limit ?,?";
        List<Order> query = runner.query(sql, new BeanListHandler<>(Order.class), new Object[]{page, row});

        return query;
    }

    @Override
    public List<Order> selectOrderList() throws SQLException {
        String sql = "select * order where isDelete =1 ";
        List<Order> query = runner.query(sql, new BeanListHandler<>(Order.class));

        return query;
    }
}
