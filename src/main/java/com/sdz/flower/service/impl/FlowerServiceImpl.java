package com.sdz.flower.service.impl;

import com.sdz.flower.bean.PageInfo;
import com.sdz.flower.bean.ResultBean;
import com.sdz.flower.dao.FlowerDao;
import com.sdz.flower.dao.impl.FlowerDaoImpl;
import com.sdz.flower.pojo.Flower;
import com.sdz.flower.service.FlowerService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhu
 */
public class FlowerServiceImpl implements FlowerService {
    private FlowerDao flowerDao = new FlowerDaoImpl();
    @Override
    public PageInfo<Flower> pageList(Integer page, Integer row) throws SQLException {
        PageInfo<Flower> info = new PageInfo<>();
        info.setRecordsTotal(flowerDao.selectCount());
        info.setRecordsFiltered(flowerDao.selectCount());
        List<Flower> flowers = flowerDao.selectFlowerList(page, row);
        info.setData(flowers);
        return info;
    }

    @Override
    public Integer addFlower(Flower flower) {
        Integer integer = null;
        try {
            integer = flowerDao.addFlower(flower);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Flower selectFlowerById(Integer id) {
        Flower flower = null;
        try {
            flower = flowerDao.selectFlowerById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flower;
    }

    @Override
    public Integer updateFlower(Flower flower) {
        Integer integer = null;
        try {
            integer = flowerDao.updateFlower(flower);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return integer;
    }

    /**
     *  首页展示
     * @param page
     * @param row
     * @return
     * @throws SQLException
     */
    @Override
    public ResultBean<Flower> pageList2(Integer page, Integer row,String type)   {
        ResultBean<Flower> flowerResultBean = new ResultBean<>();
        List<Flower> flowers = null;
        Integer count=null;
        try {
            flowers = flowerDao.selectFlowerList((page - 1) * row, row,type);
            count=flowerDao.selectCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        flowerResultBean.setList(flowers);
        flowerResultBean.setCoutn(count);
        flowerResultBean.setPage(page);
        flowerResultBean.setRow(row);
        return flowerResultBean;
    }
}
