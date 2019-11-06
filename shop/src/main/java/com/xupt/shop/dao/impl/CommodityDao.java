package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.Commodity;

import java.util.List;

public interface CommodityDao {
    //删除商品
    public int deleteCommodity(int id);
    //添加商品
    public int addCommodity(Commodity commodity);
    //修改商品信息
    public List<Commodity> updateCommodity(Commodity commodity);
    //查询所有商品
    public List<Commodity> findAllCommodity();
    //根据商品名称查询商品信息
    public List<Commodity> findNameCommodity(String name);
}
