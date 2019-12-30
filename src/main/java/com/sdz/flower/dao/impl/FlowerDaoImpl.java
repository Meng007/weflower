package com.sdz.flower.dao.impl;

import com.sdz.flower.dao.FlowerDao;
import com.sdz.flower.pojo.Flower;
import com.sdz.flower.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhu
 */
public class FlowerDaoImpl implements FlowerDao {
    private QueryRunner runner = new QueryRunner(DruidUtils.dataSource());
    @Override
    public Flower selectFlowerById(Integer fid) throws SQLException {
        String sql = "select * from flower where fid=? and isDelete=1";
        Flower flower = runner.query(sql, new BeanHandler<>(Flower.class), fid);
        return flower;
    }

    @Override
    public List<Flower> selectFlowerList(Integer page, Integer row) throws SQLException {
        String sql ="select * from flower where isDelete=1 limit ?,?";
        List<Flower> f = runner.query(sql, new BeanListHandler<>(Flower.class), new Object[]{page, row});
        return f;
    }

    @Override
    public Integer addFlower(Flower flower) throws SQLException {
        String sql = "insert into flower (name,price,num,pic,title,updated) values(?,?,?,?,?,?)";
        int update = runner.update(sql, new Object[]{
                flower.getName(),
                flower.getPrice(),
                flower.getNum(),
                flower.getPic(),
                flower.getTitle(),
                flower.getUpdated()
        });
        return update;
    }

    @Override
    public Integer updateFlower(Flower flower) throws SQLException {
        String sql = "update flower set name =?, price=?,type=?,bock=?,title=?,pic=? ,updated=? where fid = ? ";
        int update = runner.update(sql, new Object[]{
                flower.getName(),
                flower.getPrice(),
                flower.getTitle(),
                flower.getBock(),
                flower.getTitle(),
                flower.getPic(),
                flower.getUpdated(),
                flower.getFid()
        });
        return update;
    }

    @Override
    public Integer deleteFlower(Integer fid) throws SQLException {
        String sql = "update flower set isDelete = 0 where fid = ?";
        int update = runner.update(sql, fid);
        return update;
    }

    @Override
    public Integer selectCount() throws SQLException {
        String sql = "select count(fid) from flower where isDelete = 1";
        Object query = runner.query(sql, new ScalarHandler<>());
        return Integer.parseInt(String.valueOf(query));
    }

    @Override
    public List<Flower> selectFlowerList(Integer page, Integer row, String type) throws SQLException {
        String sql ="select * from flower where type like ? and isDelete=1 limit ?,?";
        List<Flower> f = runner.query(sql, new BeanListHandler<>(Flower.class), new Object[]{type,page, row});
        return f;
    }

    @Override
    public Integer updateFlowerNum(Integer num) throws SQLException {
        String sql = "update flower set num=num-1 where fid = ?";
        int i = runner.update(sql, num);
        return i;
    }
}
