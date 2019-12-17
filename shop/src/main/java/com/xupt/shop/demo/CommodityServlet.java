package com.xupt.shop.demo;

import com.xupt.shop.bean.Commodity;
import com.xupt.shop.service.serviceDo.CommodityDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommodityServlet {
    @Autowired
    CommodityDo commodityDo;
    @RequestMapping("/addCommodity")
    public int  addCommodity(String name,String price,String img,String introduct,String quantity){
        Commodity commodity = new Commodity();
        int shop_id=2;
        commodity.setName(name);
        commodity.setShop_id(shop_id);
        commodity.setPrice(Integer.valueOf(price) );
        commodity.setIntroduct(introduct);
        commodity.setQuantity(Integer.valueOf(quantity));
        return commodityDo.addCommodity(commodity) ;
    }
    @RequestMapping("/deleteCommodity")
    public String deleteCommodity(int id){
        if(commodityDo.deleteCommodity(id)>=0)
            return "删除成功";
        else return "删除失败";
    }

    @RequestMapping("/updateCommodity")
    public String updateCommodity(String id,String name,String price,String introduct,int quantity){
        Commodity commodity = new Commodity();
        int shop_id=2;
        System.out.println(123);
        commodity.setId( Integer.valueOf(id));
        commodity.setName(name);
        commodity.setShop_id(shop_id);
        commodity.setPrice(Integer.valueOf(price));
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

    @RequestMapping("/findIdCommodity")
    public Map findIdCommodity(String name,int page,int limit){
        page=(page-1)*limit;
        int id=2;  //id是shop_id
        Map map =new HashMap();
        map.put("code",0);
        map.put("msg","");
        List <Commodity> list=new ArrayList<>();
        if(name!=null)
        {
            list=commodityDo.findIdCommodityByName(name,id,page,limit);
            for(Commodity co:list)
            {
                co.setImg("<a href='https://127.0.0.1/picture?id="+co.getId()+"' target='_Blank'>查看</a>");
            }
            map.put("data",list);
            map.put("count",commodityDo.findAllCountByName(id,name));
        }
        else{
           list = commodityDo.findIdCommodity(id,page,limit);
            for(Commodity co:list)
            {
                co.setImg("<a href='https://127.0.0.1/picture?id="+co.getId()+"' target='_Blank'>查看</a>");
            }
            map.put("data",list);
            map.put("count",commodityDo.findAllCount(id));
        }
        return map;
    }

}
