package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.Collections;

import java.util.List;

public interface CollectionDao {
    //删除收藏商品
    public int deleteCollection(int id);
    //添加收藏商品
    public int addCollection(Collections collection);
    //查询所有收藏商品
    public List<Collections> findAllCollection();
    //查询个人收藏商品
    public List<Collections> findCollection(int id);
}
