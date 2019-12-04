package com.xupt.shop.demo;

import com.xupt.shop.bean.Shops;
import com.xupt.shop.service.serviceDo.ShopsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopsServlet {
    @Autowired
    ShopsDo shopsDo;
    //添加商铺
    @RequestMapping("/addShops")
    public String addShops(String name,String introduct,int user_id)
    {
        Shops shops=new Shops();
        shops.setName(name);
        shops.setIntroduct(introduct);
        shops.setUser_id(user_id);
        if(shopsDo.addShops(shops)>=0)
        {
            return "添加成功";
        }
        return"添加失败";
    }
    //修改商铺
    @RequestMapping("/updateShops")
    public String updateShops(String name,String introduct,int user_id,int id)
    {
        Shops shops=new Shops();
        shops.setName(name);
        shops.setId(id);
        shops.setIntroduct(introduct);
        shops.setUser_id(user_id);
        if(shopsDo.updateShops(shops)>=0)
        {
            return "修改成功";
        }
        return"修改失败";
    }
    //删除商铺
    @RequestMapping("/deleteShops")
    public String deleteShops(int id)
    {

        if(shopsDo.deleteShops(id)>=0)
        {
            return "删除成功";
        }
        return"删除失败";
    }
    //查看用户所有商铺
    @RequestMapping("/findAllShops")
    public List findAllShops(int user_id)
    {
        return shopsDo.findAllShops(user_id);
    }
    //查找商铺
    @RequestMapping("/findShops")
    public List findShops(String name)
    {
        return (List) shopsDo.findShops(name);

    }
}
