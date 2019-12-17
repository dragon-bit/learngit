package com.xupt.shop.bean;

import java.util.List;

public class Order {
    private long id;            //订单id，数据库中自增字段，同时也是订单号
    private int shopsId;        //商家id，存储该订单为哪一家商铺的
    private int userId;         //用户id，存储该订单为哪一用户的订单
    private String orderTime;     //订单时间
    private String orderAddr;   //订单地址
    private int orderStatus;    //订单状态，默认为0，表示订单未配送，1表示订单已完成

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    private List<OrderDetail> orderDetailList;

    public void setId(long id) {
        this.id = id;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public int getShopsId() {
        return shopsId;
    }

    public void setShopsId(int shopsId) {
        this.shopsId = shopsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

}
