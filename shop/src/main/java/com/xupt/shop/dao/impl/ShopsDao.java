package com.xupt.shop.dao.impl;


import com.xupt.shop.bean.Shops;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopsDao {
    //添加商铺
    public int addShops(Shops shop);
    //删除商铺
    public int deleteShops(int id);
    //修改商铺
    public int updateShops(String name,String introduct,int id);
    //查询拥有店铺
    public List<ShopsDao> findAllShops(int user_id);
}
