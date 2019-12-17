package com.xupt.shop.demo;

import com.xupt.shop.MySessionContext;
import com.xupt.shop.bean.*;
import com.xupt.shop.service.serviceDo.CommodityDo;
import com.xupt.shop.service.serviceDo.OrderDetailDo;
import com.xupt.shop.service.serviceDo.OrderDo;
import com.xupt.shop.service.serviceDo.ShopsDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xupt.shop.Cache;
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

    public User getUser(){
        MySessionContext mySessionContext = new MySessionContext();
        Cache cache = (Cache) mySessionContext.get("1");
        return  (User) cache.getValue();
    }

    //添加订单
    @RequestMapping("/addOrder")
    public long addOrder(int commodityId,int commodityNum) {

        Commodity commodity = commodityDo.findCommodityById(commodityId);
        double commodityPrice = commodity.getPrice();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Order order = new Order();
        order.setShopsId(commodity.getShop_id());
        order.setUserId(getUser().getId());
        order.setOrderTime(f.format(new Date()));
        order.setOrderAddr(getUser().getAddr());
        if(orderDo.addOrder(order) == 1){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setCommodityId(commodityId);
            orderDetail.setCommodityNum(commodityNum);
            orderDetail.setCommodityPrice(commodityPrice*commodityNum);
            orderDetail.setOrderId(order.getId());
            orderDetail.setStatus(0);
            orderDetailDo.addOrderDetail(orderDetail);
            return order.getId();
        }
        return 0;
    }

    //查询所有订单
    @RequestMapping("/findAllOrder")
    public List findAllOrder(){
        return orderDo.findAllOrder();
    }

    //查询订单
    @RequestMapping("/findOrder")
    public Map findOrder(String type){


//        int userType = getUser().getType();
//        int Id = getUser().getId();
        int userType = 1;
        int Id = 3;
        Map<String,Object> dataMap = new HashMap<>();

        List<Order> orderList = null;

        if(userType == 0){
            orderList = orderDo.findOrderByShopsId(Id);
        }
        else if(userType == 1){
            orderList = orderDo.findOrderByUserId(Id);
        }

        //新建返回数据的全部订单列表
        List<Map> ordersAll = new ArrayList<>();
        //新建返回数据的未支付订单列表
        List<Map> ordersNo = new ArrayList<>();

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

                Map<String,Object> commodityMap = new HashMap<>();
                commodityMap.put("name",commodity.getName());
                commodityMap.put("count",orderDetail.getCommodityNum());
                commodityMap.put("price",orderDetail.getCommodityPrice());
                commodityMap.put("commodity_id",orderDetail.getCommodityId());

                orderPrice += orderDetail.getCommodityPrice();
                commodityList.add(commodityMap);
            }
            Map<String,Object> orderMap = new HashMap<>();
            orderMap.put("order_id",order.getId());
            orderMap.put("time",order.getOrderTime());
            orderMap.put("shop_name",shops.getName());
            orderMap.put("order_price",orderPrice);
            orderMap.put("count",orderDetailList.size());
            orderMap.put("commodity",commodityList);
            if(order.getOrderStatus() == 0) {
                orderMap.put("order_status", "未支付订单");
                ordersNo.add(orderMap);
                orderNum += 1;
            }
            else if(order.getOrderStatus() == 1)
                orderMap.put("order_status","已完成订单");
            else if(order.getOrderStatus() == 2)
                orderMap.put("order_status","已取消订单");

            ordersAll.add(orderMap);

        }


        if(type.equals("all")) {
            dataMap.put("count", orderList.size());
            dataMap.put("order", ordersAll);
        }
        else if(type.equals("wait")){
            dataMap.put("count", orderNum);
            dataMap.put("order", ordersNo);
        }

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
    public int delOrderByOrderId(long orderId){
        return orderDo.delOrderByOrderId(orderId);
    }

    //更新订单
    @RequestMapping("/updateOrder")
    public int updateOrder(String status,long orderId){
        return orderDo.updateOrder(orderId,Integer.parseInt(status));
    }
}
