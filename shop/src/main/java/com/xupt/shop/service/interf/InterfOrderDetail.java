package com.xupt.shop.service.interf;

import com.xupt.shop.bean.OrderDetail;
import java.util.List;

public interface InterfOrderDetail {
    //根据订单号查找订单详情
    List<OrderDetail> findOrderDetailByOrderId(long orderId);
    //添加订单详情
    int addOrderDetail(OrderDetail orderDetail);
    //根据订单号删除订单详情
    int delOrderDetailById (long orderId);
    //更新订单状态
    int updateOrderDetail(OrderDetail orderDetail);
}
