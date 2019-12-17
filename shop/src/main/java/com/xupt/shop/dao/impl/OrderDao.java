package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {
    //查询所有订单
    List<Order> findAllOrder();
    //根据商铺id查询订单
    List<Order> findOrderByShopsId(int shopsId);
    //根据用户id查询订单
    List<Order> findOrderByUserId(int userId);
    //由订单ID删除订单
    int delOrderByOrderId(long orderId);
    //添加订单
    int addOrder(Order order);
    //修改订单状态
    int updateOrder(@Param("orderId") long orderId, @Param("status") int status);
}
