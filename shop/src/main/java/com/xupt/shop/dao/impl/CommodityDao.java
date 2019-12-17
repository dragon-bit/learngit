package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CommodityDao {
    //删除商品
    public int deleteCommodity(int id);
    //添加商品
    public int addCommodity(Commodity commodity);
    //修改商品信息
    public int updateCommodity(Commodity commodity);
    //查询所有商品
    public List<Commodity> findAllCommodity();
    //根据商品名称查询商品信息
    public List<Commodity> findNameCommodity(String name);
    //根据商品id查询商品价格
    public List<Commodity> findIdCommodity(@Param("id") int id,@Param("page")int page,@Param("limit")int limit);
    //根据名字查询自己的商品
    public List<Commodity> findIdCommodityByName(@Param("name")String name, @Param("id")int id,@Param("page")int page,@Param("limit")int limit);
    //查找个数
    public int findAllCount(int id);
    //根据名字来查找个数
    public int findAllCountByName(int id,String name);
}
