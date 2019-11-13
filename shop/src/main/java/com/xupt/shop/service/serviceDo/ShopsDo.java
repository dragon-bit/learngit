package com.xupt.shop.service.serviceDo;

import com.xupt.shop.dao.impl.ShopsDao;
import com.xupt.shop.service.interf.InterfShops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopsDo implements InterfShops {
    @Autowired
    ShopsDao shopsDao;
    public int deleteShops(int id) {
        return shopsDao.deleteShops(id);
    }
}
