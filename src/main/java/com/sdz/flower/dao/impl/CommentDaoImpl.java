package com.sdz.flower.dao.impl;

import com.sdz.flower.dao.CommentDao;
import com.sdz.flower.pojo.Comment;
import com.sdz.flower.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author  zhu
 */
public class CommentDaoImpl implements CommentDao {
    QueryRunner runner = new QueryRunner(DruidUtils.dataSource());
    @Override
    public Integer addComm(Comment comment) throws SQLException {
        String sql = "insert into comment (sid,content) values(?,?)";
        int update = runner.update(sql, new Object[]{comment.getSid(), comment.getContent()});
        return update;
    }

    @Override
    public Integer deleteComm(Integer cid) throws SQLException {
        String sql = "update comment set isDelete = 0 where cid=?";
        int update = runner.update(sql, cid);
        return update;
    }

    @Override
    public Comment selectComm() {

        return null;
    }

    @Override
    public List<Comment> selectCommList(Integer page, Integer row) throws SQLException {
        String sql = "select * from comment where isDelete =1 limit ?,?";
        List<Comment> comms = runner.query(sql, new BeanListHandler<>(Comment.class), new Object[]{page, row});
        return comms;
    }

    @Override
    public Integer reply(String reply,Integer cid) throws SQLException {
        String sql = "insert into comment set reply=? where cid=?";
        int update = runner.update(sql, new Object[]{reply, cid});
        return update;
    }
}
