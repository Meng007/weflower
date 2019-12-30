package com.sdz.flower.pojo;

import java.util.Date;

/** 花泽类 哈哈！
 * @author zhu
 */
public class Flower {
    private Integer fid;
    /**
     * 花名
     */
    private String name;
    /**
     * 价格
     */
    private Double price;
    /**
     * 类别
     */
    private String type;
    /**
     * 是否下架 1 下架，0未下架
     */
    private Integer bock;
    /**
     * 假删除 0 表示删除 1 表示未删除
     */
    private Integer isDelete;
    private Date time;
    private Integer num;
    private String pic;
    private String title;
    private Date updated;

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "fid=" + fid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", bock=" + bock +
                ", isDelete=" + isDelete +
                ", time=" + time +
                ", num=" + num +
                ", pic='" + pic + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBock() {
        return bock;
    }

    public void setBock(Integer bock) {
        this.bock = bock;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
