package com.sdz.flower.dao;

import com.sdz.flower.pojo.Comment;

import java.sql.SQLException;
import java.util.List;

/** 评论 数据访问接口
 * @author  史德竹
 */
public interface CommentDao {

    Integer addComm(Comment comment) throws SQLException;
    Integer deleteComm(Integer cid) throws SQLException;
    Comment selectComm ();
    List<Comment> selectCommList(Integer page,Integer row) throws SQLException;

    Integer reply(String reply,Integer cid) throws SQLException;
}
