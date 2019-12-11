package com.xupt.shop.demo;

import com.xupt.shop.bean.Order;
import com.xupt.shop.service.serviceDo.OrderDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@MapperScan("com.xupt.shop.dao.impl")
public class OrderServlet {
    @Autowired
    OrderDo orderDo;

    //添加订单
    @RequestMapping("/addOrder")
    public int addOrder(int shopsId,int userId,String orderTime,String orderAddr) {
        Order order = new Order();
        order.setShopsId(shopsId);
        order.setUserId(userId);
        order.setOrderTime(orderTime);
        order.setOrderAddr(orderAddr);
        return orderDo.addOrder(order);
    }

    //查询所有订单
    @RequestMapping("/findAllOrder")
    public List findAllOrder(){
        List orderList = orderDo.findAllOrder();
        return orderList;
    }

    //通过商铺id查询订单
    @RequestMapping("/findOrderByShopsId")
    public List findOrderByShopsId(int shopsId){
        List orderList = orderDo.findOrderByShopsId(shopsId);
        return orderList;
    }

    //通过用户id查询订单
    @RequestMapping("/findOrderByUserId")
    public List findOrderByUserId(int userId){
        List orderList = orderDo.findOrderByUserId(userId);
        return orderList;
    }

    //通过订单号删除订单
    @RequestMapping("/delOrderByOrderId")
    public int delOrderByOrderId(int orderId){
        return orderDo.delOrderByOrderId(orderId);
    }

    //更新订单
    @RequestMapping("/updateOrder")
    public int updateOrder(Order order){
        return orderDo.updateOrder(order);
    }

}
