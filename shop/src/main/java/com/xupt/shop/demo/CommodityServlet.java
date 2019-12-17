package com.xupt.shop.demo;

import com.xupt.shop.Cache;
import com.xupt.shop.Controller;
import com.xupt.shop.MySessionContext;
import com.xupt.shop.bean.Commodity;
import com.xupt.shop.bean.User;
import com.xupt.shop.service.serviceDo.CollectionDo;
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
    @Autowired
    CollectionDo collectionDo;
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
    public List findAllCommodity(String name,String id,String user_name,String user_addr,String tel,String type){
//        MySessionContext mySessionContext=new MySessionContext();
//        Cache cache=new Cache();
//        User user=new User();
//        user.setId(Integer.valueOf(id));
//        user.setName(name);
//        user.setAddress(user_addr);
//        user.setType(Integer.valueOf(type));
//        user.setTelephone(tel);
//        cache.setKey("user");
//        cache.setValue(user);
//        mySessionContext.put("1",cache);
        if(name!=null)
        {
            List list = commodityDo.findNameCommodity(name);
            return list;
        }else{
            List list = commodityDo.findAllCommodity();
            return list;
        }
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

    @RequestMapping("/findCommodityById")
    public Map commodity(String id){
        int user_id=2;
        Map map=new HashMap();
        int msg= Integer.valueOf(id);
        int m=-1;
        if (collectionDo.findCollectionById(user_id,msg)!=null){
            m=1;
        }
        Commodity c= commodityDo.findCommodityById(msg);
        map.put("commodity",c);
        map.put("status",m);
        return map;
    }
}
