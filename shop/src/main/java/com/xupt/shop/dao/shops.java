package com.xupt.shop.dao;


import java.util.List;

public interface shops {
    public int addShops(shops shop);
    public int deleteShops(int id);
    public int updateShops(String name,String introduct,int id);
    public List<shops> findAllShops(int user_id);
}
