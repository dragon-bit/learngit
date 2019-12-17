package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.OrderDetail;
import com.xupt.shop.dao.impl.OrderDetailDao;
import com.xupt.shop.service.interf.InterfOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderDetailDo implements InterfOrderDetail {

    @Resource
    OrderDetailDao orderDetailDao;

    @Override
    public List<OrderDetail> findOrderDetailByOrderId(long orderId) {
        return orderDetailDao.findOrderDetailByOrderId(orderId);
    }

    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.addOrderDetail(orderDetail);
    }

    @Override
    public int delOrderDetailById(long orderId) {
        return orderDetailDao.delOrderDetailById(orderId);
    }

    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.updateOrderDetail(orderDetail);
    }
}
