package com.xupt.shop.demo;

import com.xupt.shop.bean.Collections;
import com.xupt.shop.bean.Commodity;
import com.xupt.shop.service.serviceDo.CollectionDo;
import com.xupt.shop.service.serviceDo.CommodityDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@MapperScan("com.xupt.shop.dao.impl")
public class CollectionServlet {
    @Autowired
    CollectionDo collectionDo;
    @Autowired
    CommodityDo commodityDo;
    //添加收藏
    @RequestMapping("/addCollection")
    public  String addCollection(String commodity_id )
    {
         Collections collection=new Collections();
         int user_id=2;
         collection.setCommodity_id(Integer.valueOf(commodity_id));
         collection.setUser_id(Integer.valueOf(user_id));
         if(collectionDo.addCollection(collection)>=0)
         {
             return "添加成功";
         }
         return "添加失败";

    }
    //删除收藏
    @RequestMapping("/deleteCollection")
    public  String deleteCollection(int id )
    {
       if( collectionDo.deleteCollection(id)>=0)
        return "删除成功";
       return "删除失败";
    }
    //根据用户查询收藏
    @RequestMapping("/findCollection")
    public Map findCollection( )
    {
        int id=2;
        Map map=new HashMap();
        List<Collections> list= collectionDo.findCollectionById(id);
        List<Commodity> commodity= new ArrayList<>();
        for(Collections co:list)
        {
           Commodity ki=commodityDo.findCommodityById(co.getCommodity_id());
           commodity.add(ki);
        }
        map.put("commodity",commodity);
        map.put("collection",list);
        return map;
    }
}
