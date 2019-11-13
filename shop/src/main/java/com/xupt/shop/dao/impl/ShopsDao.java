package com.xupt.shop.dao.impl;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface ShopsDao {
    @Transactional
    public int addShops(ShopsDao shop);
    public int deleteShops(@Param("id")int id);
    public int updateShops(String name,String introduct,int id);
    public List<ShopsDao> findAllShops(int user_id);
}
