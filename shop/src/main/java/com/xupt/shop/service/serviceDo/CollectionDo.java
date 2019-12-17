package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.Collections;
import com.xupt.shop.dao.impl.CollectionDao;
import com.xupt.shop.service.interf.InterfCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionDo implements InterfCollection {

    @Autowired
    CollectionDao collectionDao;
    //添加收藏
    @Override
    public int addCollection(Collections collection) {
        return collectionDao.addCollection(collection);
    }
    //删除收藏
    @Override
    public int deleteCollection(int id) {
        return collectionDao.deleteCollection(id);
    }

    //根据用户id查找收藏
    @Override
    public List findCollectionById(int user_id) {
        return collectionDao.findCollection(user_id);
    }
}
