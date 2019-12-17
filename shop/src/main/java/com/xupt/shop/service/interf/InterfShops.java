package com.xupt.shop.service.interf;

import com.xupt.shop.bean.Shops;

import java.util.List;

public interface InterfShops {
    //删除商铺
    public int deleteShops(int id);
    //添加商铺
    public int addShops(Shops shops);
    //修改商铺
    public int updateShops(Shops shops);
    //查询用户所有商铺
    public List findAllShops(int id);
    //查询商铺
    public List findShops(String name);
}
