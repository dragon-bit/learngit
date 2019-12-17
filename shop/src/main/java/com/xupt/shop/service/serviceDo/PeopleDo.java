package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.People;
import com.xupt.shop.dao.impl.PeopleDao;
import com.xupt.shop.service.interf.InterfPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleDo implements InterfPeople {
    @Autowired
    PeopleDao peopleDao;
    @Override
    public People findPeopleById(int id) {
        return peopleDao.findPeopleById(id);
    }

    @Override
    public int updatePeople(People people) {
        return peopleDao.updatePeople(people);
    }
}
