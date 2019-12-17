package com.xupt.shop.demo;

import com.xupt.shop.bean.*;
import com.xupt.shop.service.serviceDo.CommodityDo;
import com.xupt.shop.service.serviceDo.OrderDetailDo;
import com.xupt.shop.service.serviceDo.OrderDo;
import com.xupt.shop.service.serviceDo.ShopsDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@MapperScan("com.xupt.shop.dao.impl")
public class OrderServlet {
    @Autowired
    OrderDo orderDo;

    @Autowired
    OrderDetailDo orderDetailDo;

    @Autowired
    CommodityDo commodityDo;

    @Autowired
    ShopsDo shopsDo;

    //添加订单
    @RequestMapping("/addOrder")
    public int addOrder(int shopsId,int userId,String orderAddr) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Order order = new Order();
        order.setShopsId(shopsId);
        order.setUserId(userId);
        order.setOrderTime(f.format(new Date()));
        order.setOrderAddr(orderAddr);
        return orderDo.addOrder(order);
    }

    //查询所有订单
    @RequestMapping("/findAllOrder")
    public List findAllOrder(){
        return orderDo.findAllOrder();
    }

    //查询订单
    @RequestMapping("/findOrder")
    public Map findOrder(HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        int userType = user.getType();
        int Id = user.getId();
        Map dataMap = new HashMap();

        List<Order> orderList = null;

        if(userType == 0){
            orderList = orderDo.findOrderByShopsId(Id);
        }
        else if(userType == 1){
            orderList = orderDo.findOrderByUserId(Id);
        }

        //新建返回数据的订单列表
        List<Map> orders = new ArrayList<>();
        int orderNum = 0;
        //根据循环订单列表添加每一个订单的详情
        for (Order order : orderList){
            //先获取订单中的商品列表
            List<OrderDetail> orderDetailList = orderDetailDo.findOrderDetailByOrderId(order.getId());
            //获取该订单的商铺
            Shops shops = (Shops) shopsDo.findAllShops(order.getShopsId()).get(0);
            //新建返回数据的商品列表
            List<Map> commodityList = new ArrayList<>();

            double orderPrice = 0;
            //根据商品列表逐个添加商品键对值，并将每一个商品键对添加进商品列表
            for(OrderDetail orderDetail : orderDetailList){
                Commodity commodity = commodityDo.findCommodityById(orderDetail.getCommodityId());

                Map commodityMap = new HashMap();
                commodityMap.put("name",commodity.getName());
                commodityMap.put("count",orderDetail.getCommodityNum());
                commodityMap.put("price",orderDetail.getCommodityPrice());
                commodityMap.put("commodity_id",orderDetail.getCommodityId());

                orderPrice += orderDetail.getCommodityPrice();
                commodityList.add(commodityMap);
            }
            Map orderMap = new HashMap();
            orderMap.put("order_id",order.getId());
            orderMap.put("time",order.getOrderTime());
            orderMap.put("shop_name",shops.getName());
            orderMap.put("order_price",orderPrice);
            orderMap.put("count",orderDetailList.size());
            if(order.getOrderStatus() == 0)
                orderMap.put("order_status","未支付订单");
            else if(order.getOrderStatus() == 1)
                orderMap.put("order_status","已完成订单");
            else if(order.getOrderStatus() == 2)
                orderMap.put("order_status","已取消订单");
            orderMap.put("commodity",commodityList);

            orders.add(orderMap);
        }

        dataMap.put("count",orderList.size());
        dataMap.put("order",orders);
        return dataMap;

    }

    //通过商家id查询订单
    private List findOrderByShopsId(int shopsId){
        return orderDo.findOrderByShopsId(shopsId);
    }

    //通过用户id查询订单
    private List findOrderByUserId(int userId){
        return orderDo.findOrderByUserId(userId);
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
