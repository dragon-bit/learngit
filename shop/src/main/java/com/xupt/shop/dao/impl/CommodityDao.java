package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.commodity;

import java.util.List;

public interface CommodityDao {
    //删除商品
    public int deleteCommodity(int id);
    //添加商品
    public int addCommodity(commodity commodity);
    //修改商品信息
    public List<commodity> updateCommodity(commodity commodity);
    //查询所有商品
    public List<commodity> findAllCommodity();
    //根据商品名称查询商品信息
    public List<commodity> findNameCommodity(String name);
}
