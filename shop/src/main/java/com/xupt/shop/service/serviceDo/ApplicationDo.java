package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.Application;
import com.xupt.shop.dao.impl.ApplicationDao;
import com.xupt.shop.service.interf.InterfApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationDo  implements InterfApplication {
    @Autowired
    ApplicationDao applicationDao;

    @Override
    public int addApplication(Application application) {
        return applicationDao.addApplication(application);
    }
}
