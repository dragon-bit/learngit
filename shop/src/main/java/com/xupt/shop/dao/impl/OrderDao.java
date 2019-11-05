package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.Order;

public interface OrderDao {
    //查询所有订单
    List<Order> findAllOrder();
    //根据用户id查询订单
    List<Order> findOrderByUserId();
}
