package com.xupt.shop.service.interf;


import com.xupt.shop.bean.Commodity;

import java.util.List;

public interface InterfCommodity {

    //删除商品
    int deleteCommodity(int id);
    //添加商品
    int addCommodity(Commodity commodity);
    //修改商品信息
    int updateCommodity(Commodity commodity);
    //查询所有商品
    List<Commodity> findAllCommodity();
    //根据商品名称查询商品信息
    List<Commodity> findNameCommodity(String name);
    //根据商品id查询商品价格
    List<Commodity> findIdCommodity(int id,int page,int limit);
    //根据名字查询自己的商品
    List<Commodity> findIdCommodityByName(String name, int id,int page,int limit);
    //查找个数
    public int findAllCount(int id);
    //根据名字来查找个数
    public int findAllCountByName(int id,String name);
}
