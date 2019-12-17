package com.xupt.shop.service.interf;

import com.xupt.shop.bean.Collections;

import java.util.List;

public interface InterfCollection {
    //添加收藏
    int addCollection(Collections collection);
    //删除收藏
    int deleteCollection(int id);
    //根据user_id查询收藏
    List findCollectionById(int user_id);
}
