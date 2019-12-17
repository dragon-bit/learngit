package com.xupt.shop.service.interf;

import com.xupt.shop.bean.Collections;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterfCollection {
    //添加收藏
    int addCollection(Collections collection);
    //删除收藏
    int deleteCollection(int id);
    //根据user_id查询收藏
    List findCollectionById(int user_id);
    //查询是否收藏商品
    public Collections findCollectionById( int user_id, int commodity_id);
}
