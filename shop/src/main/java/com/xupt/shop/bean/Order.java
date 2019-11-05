package com.xupt.shop.bean;

public class Order {
    private String orderNum;
    private datetime orderTime;
    private String orderAddr;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public datetime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(datetime orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }
}
