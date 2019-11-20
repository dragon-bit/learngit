package com.xupt.shop.demo;

import com.xupt.shop.bean.Collection;
import com.xupt.shop.service.serviceDo.CollectionDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@MapperScan("com.xupt.shop.dao.impl")
public class CollectionServlet {
    @Autowired
    CollectionDo collectionDo;
    //添加订单
    @RequestMapping("/addCollection")
    public  String addCollection(int user_id,int commodity_id )
    { Collection collection=new Collection();
     collection.setCommodity_id(commodity_id);
     collection.setUser_id(user_id);
     if(collectionDo.addCollection(collection)>=0)
     {
         return "添加成功";
     }
     return "添加失败";

    }
    //删除订单
    @RequestMapping("/deleteCollection")
    public  String deleteCollection(int id )
    {
       if( collectionDo.deleteCollection(id)>=0)
        return "删除成功";
       return "删除失败";
    }
    //根据用户查询收藏
    @RequestMapping("/findCollection")
    public  List findCollection(int id )
    {
       List list= collectionDo.findCollectionById(id);
       return list;
    }
}
