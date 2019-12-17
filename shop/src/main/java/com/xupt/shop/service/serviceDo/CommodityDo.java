package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.Commodity;
import com.xupt.shop.dao.impl.CommodityDao;
import com.xupt.shop.service.interf.InterfCommodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityDo implements InterfCommodity {

    @Autowired
    CommodityDao commodityDao;

    @Override
    public int deleteCommodity(int id) {
        return commodityDao.deleteCommodity(id);
    }

    //添加商品
    @Override
    public int addCommodity(Commodity commodity){
        return commodityDao.addCommodity(commodity);
    }
    //修改商品信息
    @Override
    public int updateCommodity(Commodity commodity) {
        return commodityDao.updateCommodity(commodity);
    }
    //查询所有
    @Override
    public List<Commodity> findAllCommodity() {
        return commodityDao.findAllCommodity();
    }
    //根据商品名称查询商品信息
    @Override
    public List<Commodity> findNameCommodity(String name) {
        return commodityDao.findNameCommodity(name);
    }
    //根据商品id查询商品价格
    @Override
    public List<Commodity> findIdCommodity(int id,int page,int limit) {
        return commodityDao.findIdCommodity(id,page,limit);
    }

    @Override
    public List<Commodity> findIdCommodityByName(String name, int id,int page,int limit) {
        return commodityDao.findIdCommodityByName(name,id,page,limit);
    }//查找数据个数
    @Override
    public int findAllCount(int id) {
        return commodityDao.findAllCount( id);
    }
    //根据名字查找数据个数
    @Override
    public int findAllCountByName(int id,String name) {
        return commodityDao.findAllCountByName(id,name);
    }

  //根据商品id查找商品
    @Override
    public Commodity findCommodityById(int id) {
        return commodityDao.findCommodityById(id);
    }

}
