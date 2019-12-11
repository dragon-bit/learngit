package com.xupt.shop.bean;

/*
* 该类为订单详情
* 存储一个订单内的一个商品
* 将一个订单的所有商品单独存储
*/

public class OrderDetail {
    private long orderId;       //订单号，长整形，数据库外键，自增
    private int commodityId;    //产品id，一个订单中包含多个商品
    private double commodityPrice;  //该条订单详情总价，即 商品个数*单价 后所得
    private int commodityNum;   //该商品个数
    private int status;         //商品状态，0为默认未送达，1为送达

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public int getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(int commodityNum) {
        this.commodityNum = commodityNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }
}
