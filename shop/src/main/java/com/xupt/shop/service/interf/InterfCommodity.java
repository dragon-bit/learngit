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
}
