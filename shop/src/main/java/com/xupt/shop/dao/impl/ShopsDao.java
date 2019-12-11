package com.xupt.shop.dao.impl;


import com.xupt.shop.bean.Shops;
import java.util.List;

public interface ShopsDao {
    public int addShops(Shops shop);
    public int deleteShops(int id);
    public int updateShops(String name,String introduct,int id);
    public List<ShopsDao> findAllShops(int user_id);
}
