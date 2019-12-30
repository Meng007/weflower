package com.sdz.flower.pojo;

import org.omg.PortableInterceptor.INACTIVE;

/** 购物车
 * @author  zhu zhu zhu zhu
 */
public class Cart {
    private Integer cid;
    private Integer sid;
    private Integer fid;
    private Integer count;// 商品数量
    private Double price; //价格

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
