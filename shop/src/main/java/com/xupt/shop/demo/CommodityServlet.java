package com.xupt.shop.demo;

import com.xupt.shop.bean.Commodity;
import com.xupt.shop.service.serviceDo.CommodityDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommodityServlet {
    @Autowired
    CommodityDo commodityDo;
    @RequestMapping("/addCommodity")
    public String addCommodity(String name,int shop_id,int price,String img,String introduct,int quantity){
        Commodity commodity = new Commodity();
        commodity.setName(name);
        commodity.setShop_id(shop_id);
        commodity.setPrice(price);
        commodity.setImg(img);
        commodity.setIntroduct(introduct);
        commodity.setQuantity(quantity);
        if(commodityDo.addCommodity(commodity)>=0)
            return "添加成功";
        else return "添加失败";
    }
    @RequestMapping("/deleteCommodity")
    public String deleteCommodity(int id){
        if(commodityDo.deleteCommodity(id)>=0)
            return "删除成功";
        else return "删除失败";
    }

    @RequestMapping("/updateCommodity")
    public String updateCommodity(int id,String name,int shop_id,int price,String img,String introduct,int quantity){
        Commodity commodity = new Commodity();
        commodity.setId(id);
        commodity.setName(name);
        commodity.setShop_id(shop_id);
        commodity.setPrice(price);
        commodity.setImg(img);
        commodity.setIntroduct(introduct);
        commodity.setQuantity(quantity);
        if(commodityDo.updateCommodity(commodity)>=0)
            return "修改成功";
        else return "修改失败";
    }

    @RequestMapping("/findAllCommodity")
    public List findAllCommodity(){
        List list = commodityDo.findAllCommodity();
        return list;
    }

    @RequestMapping("/findNameCommodity")
    public List findNameCommodity(String name){
        List list = commodityDo.findNameCommodity(name);
        return list;
    }


}
