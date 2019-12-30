package com.sdz.flower.test;

import com.sdz.flower.bean.PageInfo;
import com.sdz.flower.pojo.Flower;
import com.sdz.flower.service.impl.FlowerServiceImpl;

import java.sql.SQLException;

public class ServiceTest {
    public static void main(String[] args) throws SQLException {
        FlowerServiceImpl flowerService = new FlowerServiceImpl();
        PageInfo<Flower> flowerPageInfo = flowerService.pageList(1, 10);
        System.out.println(flowerPageInfo.getData());
    }
}
