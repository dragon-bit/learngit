package com.xupt.shop.dao.impl;


import java.util.List;

public interface ShopsDao {
    public int addShops(ShopsDao shop);
    public int deleteShops(int id);
    public int updateShops(String name,String introduct,int id);
    public List<ShopsDao> findAllShops(int user_id);
}
