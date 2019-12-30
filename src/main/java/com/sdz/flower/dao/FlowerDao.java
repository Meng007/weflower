package com.sdz.flower.dao;

import com.sdz.flower.pojo.Flower;
import org.apache.commons.fileupload.util.LimitedInputStream;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhu
 */
public interface FlowerDao {
    Flower selectFlowerById(Integer fid) throws SQLException;
    List<Flower> selectFlowerList(Integer page,Integer row) throws SQLException;
    Integer addFlower(Flower flower) throws SQLException;
    Integer updateFlower(Flower flower) throws SQLException;
    Integer deleteFlower(Integer fid) throws SQLException;
    Integer selectCount() throws SQLException;

    List<Flower> selectFlowerList(Integer page,Integer row,String type) throws SQLException;
    Integer updateFlowerNum(Integer num) throws SQLException;
}
