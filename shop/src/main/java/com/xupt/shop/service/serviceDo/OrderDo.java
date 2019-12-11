package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.Order;
import com.xupt.shop.dao.impl.OrderDao;
import com.xupt.shop.service.interf.InterfOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDo implements InterfOrder {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> findAllOrder() {
        return orderDao.findAllOrder();
    }

    @Override
    public List<Order> findOrderByShopsId(int shopsId) {
        return orderDao.findOrderByShopsId(shopsId);
    }

    @Override
    public List<Order> findOrderByUserId(int userId) {
        return orderDao.findOrderByUserId(userId);
    }

    @Override
    public int delOrderByOrderId(long orderId) {
        return orderDao.delOrderByOrderId(orderId);
    }

    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }
}
