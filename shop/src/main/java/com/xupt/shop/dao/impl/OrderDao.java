package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.Order;

import java.util.List;

public interface OrderDao {
    //查询所有订单
    List<Order> findAllOrder();
    //根据用户id查询订单
    List<Order> findOrderByOrderNum(String OrderNum);
    //删除订单
    int delOrderByOrderNum(String OrderNum);
    //添加订单
    int addOrder(Order order);
    //修改订单地址
    int updateOrder(Order order);
}
