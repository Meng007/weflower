package com.sdz.flower.dao.impl;

import com.sdz.flower.dao.NoticeDao;
import com.sdz.flower.pojo.Notice;
import com.sdz.flower.utils.DruidUtils;
import com.sun.xml.internal.ws.model.AbstractWrapperBeanGenerator;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhu
 */
public class NoticeDaoImpl implements NoticeDao {
    QueryRunner runner = new QueryRunner(DruidUtils.dataSource());
    @Override
    public Integer addNotice(Notice notice) throws SQLException {
        String sql = "insert into (title,content,pic,) values(?,?,?)";
        int update = runner.update(sql, new Object[]{notice.getTitle(), notice.getContent(), notice.getPic()});

        return update;
    }

    @Override
    public Integer deleteNotice(Integer nid) throws SQLException {
        String sql = "update notice set isDelete = 0 where nid=?";
        int update = runner.update(sql, nid);
        return update;
    }

    @Override
    public List<Notice> selectNoticeList(Integer page, Integer row) throws SQLException {
        String sql = "select * from notice where isDelete = 1 limit ?,?";
        List<Notice> notices = runner.query(sql, new BeanListHandler<>(Notice.class), new Object[]{page, row});
        return notices;
    }

    @Override
    public Notice selectNoticeOne(Integer nid) throws SQLException {
        String sql = "select * from notice where isDelete =1 ";
        Notice notice = runner.query(sql, new BeanHandler<>(Notice.class), nid);

        return notice;
    }
}
