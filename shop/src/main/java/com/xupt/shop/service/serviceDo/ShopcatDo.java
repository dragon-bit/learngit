package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.Shopcat;
import com.xupt.shop.dao.impl.ShopcatDao;
import com.xupt.shop.service.interf.InterfShopcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ShopcatDo implements InterfShopcat {
    @Autowired
    ShopcatDao shopcatDao;
    //添加商品
    @Override
    public int addCommodity(Shopcat shopcat) {
        return shopcatDao.addCommodity(shopcat);
    }
    //删除商品
    @Override
    public int deleteCommodity(int id) {
        return shopcatDao.deleteCommodity(id);
    }
    //查看购物车
    @Override
    public ArrayList<Shopcat> findAllCommodity(int user_id) {
        return shopcatDao.findAllCommodity(user_id);
    }


    //修改商品个数
    @Override
    public int updateCommodity( int id,int quantity) {
        return shopcatDao.updateCommodity(id, quantity);
    }
    //判断商品是否重复
    @Override
    public int selectCommodity(int commodity_id) {
        return shopcatDao.selectCommodity(commodity_id);
    }
}
