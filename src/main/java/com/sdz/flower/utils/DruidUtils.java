package com.sdz.flower.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 竹
 */
public class DruidUtils {
    private static Properties properties = null;
    static{

        try {
            properties = new Properties();
           properties.load(DruidUtils.class.getResourceAsStream("/druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataSource dataSource(){
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
