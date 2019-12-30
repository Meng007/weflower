package com.sdz.flower.pojo;

/** 订单 类
 * @author zhu
 */
public class Order {
    private Integer oid;
    private String numbers;
    private Integer fid;
    private Integer sid;
    private String stated;
    private Integer isDelete;

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", number='" + numbers + '\'' +
                ", fid=" + fid +
                ", sid=" + sid +
                ", state='" + stated + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String number) {
        this.numbers = number;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStated() {
        return stated;
    }

    public void setStated(String state) {
        this.stated = state;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
