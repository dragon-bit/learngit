package com.xupt.shop.dao;

import com.xupt.shop.bean.commodity;

import java.util.ArrayList;

public interface shopcat_dao {
    //添加商品
    public int addCommodity(String name, int shop_id,
                            int price,String img,
                            String introduct,
                            int quantity);
    //删除商品
    public int deleteCommodity(int id);
    //查询所有商品
    public ArrayList<commodity> fingAllCommodity();
    //修改商品个数
    public int updateCommodity(int quantity,int id);
}
