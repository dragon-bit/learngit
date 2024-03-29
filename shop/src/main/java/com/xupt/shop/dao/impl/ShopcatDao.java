package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.Commodity;
import com.xupt.shop.bean.Shopcat;

import java.util.ArrayList;

public interface ShopcatDao {
    //添加商品
    public int addCommodity(Shopcat shopcat);
    //删除商品
    public int deleteCommodity(int id);
    //查询所有商品
    public ArrayList<Shopcat> findAllCommodity(int user_id);
    //修改商品个数
    public int updateCommodity(int quantity,int id);
    //查找重复
    public int selectCommodity(int commodity_id);
}
