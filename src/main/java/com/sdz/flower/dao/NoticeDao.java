package com.sdz.flower.dao;

import com.sdz.flower.pojo.Notice;

import java.sql.SQLException;
import java.util.List;

/** 公告 数据访问接口
 * @author zhu
 */
public interface NoticeDao {
    Integer addNotice(Notice notice) throws SQLException;
    Integer deleteNotice(Integer nid) throws SQLException;

    List<Notice> selectNoticeList(Integer page,Integer row) throws SQLException;
    Notice selectNoticeOne(Integer nid) throws SQLException;
}
