package com.sdz.flower.service;

import com.sdz.flower.bean.PageInfo;
import com.sdz.flower.bean.ResultBean;
import com.sdz.flower.pojo.Flower;
import jdk.nashorn.internal.ir.CallNode;

import java.sql.SQLException;


/**
 * @author zhu
 */
public interface FlowerService {
    PageInfo<Flower> pageList(Integer page, Integer row) throws SQLException;

    Integer addFlower(Flower flower);

    Flower selectFlowerById(Integer id);

    Integer updateFlower(Flower flower);

    /*******************首页数据展示************************/
    ResultBean<Flower> pageList2(Integer page,Integer row ,String type);
}
