package com.xupt.shop.demo;

import com.xupt.shop.bean.Order;
import com.xupt.shop.bean.OrderDetail;
import com.xupt.shop.bean.User;
import com.xupt.shop.service.serviceDo.OrderDetailDo;
import com.xupt.shop.service.serviceDo.OrderDo;
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
    OrderDetailDo orderDetailDo;

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

        Map commodityMap = new HashMap();
        commodityMap.put("name","辣条");
        commodityMap.put("count",2);
        commodityMap.put("price",1);
        commodityMap.put("commodity_id",1);

        List<Map> commodityList = new ArrayList<>();
        commodityList.add(commodityMap);

        Map orderMap = new HashMap();
        orderMap.put("order_id",123456);
        orderMap.put("time","2019_11_11 11:11:11");
        orderMap.put("shop_name","Test");
        orderMap.put("order_price",12);
        orderMap.put("count",1);
        orderMap.put("order_status","成功");
        orderMap.put("commodity",commodityList);

        List<Map> orderList = new ArrayList<>();
        orderList.add(orderMap);

        Map dataMap = new HashMap();
        dataMap.put("count",1);
        dataMap.put("order",orderList);
        return dataMap;
//        User user = (User) request.getSession().getAttribute("user");
//        int userType = user.getType();
//        int userId = user.getId();
//        if(userType == 2){
//            return findOrderByShopsId(userId);
//        }
//        else if(userType == 1)
//            return findOrderByUserId(userId);
//        return null;
    }

    //通过商家id查询订单
    private List findOrderByShopsId(int shopsId){
        return orderDo.findOrderByShopsId(shopsId);
    }

    //通过用户id查询订单
//    private List findOrderByUserId(int userId){
//        Map map = new HashMap<>();
//        List<Order> orderList = orderDo.findOrderByUserId(userId);
//        for (Order order : orderList){
//            order.setOrderDetailList(orderDetailDo.findOrderDetailByOrderId(order.getId()));
//        }
//    }

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
