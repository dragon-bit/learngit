package com.xupt.shop.dao.impl;


import com.xupt.shop.bean.Shops;

import java.util.List;

public interface ShopsDao {
    public int addShops(Shops shops);
    public int deleteShops(int id);
    public int updateShops(Shops shops);
    public List<ShopsDao> findAllShops(int id);
    //查询商铺
    public List findShops(String name);
}
