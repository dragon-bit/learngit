package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.OrderInfo;

import java.util.List;

public interface OrderInfoDao {
    //由订单号查找订单信息
    List<OrderInfo> findOrderInfoByNum(String OrderNum);
    //添加订单信息
    int addOrderInfo(OrderInfo orderInfo);
    //删除订单信息
    int delOrderInfoByNum(String OrderNum);

}
