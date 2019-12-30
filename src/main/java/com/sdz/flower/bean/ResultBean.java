package com.sdz.flower.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author  zhu
 */
public class ResultBean<T> implements Serializable {
    /**
     * 每页展示的数据条数
     */
    private Integer row;
    /**
     * 当前页数
     */
    private Integer page;
    /**
     *  数据总条数
     */
    private Integer coutn;
    /**
     *  数据 集合
     */
    private List<T> list;

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCoutn() {
        return coutn;
    }

    public void setCoutn(Integer coutn) {
        this.coutn = coutn;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "row=" + row +
                ", page=" + page +
                ", coutn=" + coutn +
                ", list=" + list +
                '}';
    }
}
