package com.xupt.shop.demo;

import com.xupt.shop.bean.Shopcat;
import com.xupt.shop.service.serviceDo.ShopcatDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopcatSerclet {
    @Autowired
    ShopcatDo shopcatDo;
    //添加商品进入购物车
    @RequestMapping("/addShopcat")
    public String addShopcat(int user_id,int commodity_id,int quantity){
        int m=shopcatDo.selectCommodity(commodity_id);
        if(m>=0)
        {
                shopcatDo.updateCommodity(m,quantity);
                return "添加成功";
        }
        Shopcat shopcat=new Shopcat();
        shopcat.setCommodity_id(commodity_id);
        shopcat.setQuantity(quantity);
        shopcat.setUser_id(user_id);
        if(shopcatDo.addCommodity(shopcat)>=0)
        {
            return "添加成功";
        }
        return "添加失败";
    }
    @RequestMapping("/deleteShopcat")
    //删除商品进入购物车
    public String deleteShopcat(int id){
        if(shopcatDo.deleteCommodity(id)>=0)
        {
            return "删除成功";
        }
        return "删除失败";
    }
    @RequestMapping("/findAllShopcat")
    //查询购物车商品
    public List findAllShopcat(int user_id){
        return shopcatDo.findAllCommodity(user_id);
    }

}
