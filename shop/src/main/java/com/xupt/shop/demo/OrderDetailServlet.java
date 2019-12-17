package com.xupt.shop.demo;


import com.xupt.shop.bean.OrderDetail;
import com.xupt.shop.service.serviceDo.OrderDetailDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@MapperScan("com.xupt.shop.dao.impl")
public class OrderDetailServlet {
    @Autowired
    OrderDetailDo orderDetailDo;

    //根据订单号查找订单详情
    @RequestMapping("/findOrderDetailByOrderId")
    public List<OrderDetail> findOrderDetailByOrderId(long orderId){
        return orderDetailDo.findOrderDetailByOrderId(orderId);
    }

    //添加订单详情
    @RequestMapping("/addOrderDetail")
    public int addOrderDetail(long orderId,int commodityId,double commodityPrice,int commodityNum){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setCommodityId(commodityId);
        orderDetail.setCommodityNum(commodityNum);
        orderDetail.setCommodityPrice(commodityPrice);
        return orderDetailDo.addOrderDetail(orderDetail);
    }

    //根据订单号删除订单详情
    @RequestMapping("/delOrderDetailById")
    public int delOrderDetailById(long orderId){
        return orderDetailDo.delOrderDetailById(orderId);
    }

    //更新订单状态
    @RequestMapping("/updateOrderDetail")
    public int updateOrderDetail(OrderDetail orderDetail){
        return orderDetailDo.updateOrderDetail(orderDetail);
    }
}
