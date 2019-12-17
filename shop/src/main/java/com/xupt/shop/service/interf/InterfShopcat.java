package com.xupt.shop.service.interf;

import com.xupt.shop.bean.Commodity;
import com.xupt.shop.bean.Shopcat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public interface InterfShopcat {
    //添加商品
    public int addCommodity(Shopcat shopcat);
    //删除商品
    public int deleteCommodity(int id);
    //查询所有商品
    public ArrayList<Shopcat> findAllCommodity(int user_id);
    //修改商品个数
    public int updateCommodity(int id,int quantity);
    //查看商品是否重复
    public int selectCommodity(int commodity_id);
}
