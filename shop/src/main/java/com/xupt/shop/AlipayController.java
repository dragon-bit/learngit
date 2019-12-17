package com.xupt.shop;

import com.alipay.api.AlipayApiException;
import com.xupt.shop.bean.OrderDetail;
import com.xupt.shop.service.serviceDo.AlipayDo;
import com.xupt.shop.service.serviceDo.OrderDetailDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlipayController {
    @Autowired
    private AlipayDo alipayDo;
    @Autowired
    OrderDetailDo orderDetailDo;

    @PostMapping("/getPagePay")
    public String getPagePay(long orderId) throws Exception {
        List<OrderDetail> orderDetail = orderDetailDo.findOrderDetailByOrderId(orderId);
        String pay=alipayDo.webPagePay(String.valueOf(orderId), String.valueOf(orderDetail.get(0).getCommodityPrice()),"西邮派");
        System.out.println(pay);
        return pay;
    }
    @PostMapping("/alipayclose")
    public String alipayClose(OrderDetail orderDetail) throws AlipayApiException {
        String close = alipayDo.close(String.valueOf(orderDetail.getOrderId()));

        return close;
    }
}
