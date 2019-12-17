package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.Shops;
import com.xupt.shop.dao.impl.ShopsDao;
import com.xupt.shop.service.interf.InterfShops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopsDo implements InterfShops {
    @Autowired
    ShopsDao shopsDao;
    public int deleteShops(int id) {
        return shopsDao.deleteShops(id);
    }

    @Override
    public int addShops(Shops shops) {
        return shopsDao.addShops(shops);
    }

    @Override
    public int updateShops(Shops shops) {
        return shopsDao.updateShops(shops);
    }

    @Override
    public List findAllShops(int id) {
        return shopsDao.findAllShops(id);
    }

    @Override
    public List findShops(String name) {
        return shopsDao.findShops(name);
    }

}
