package com.xupt.shop.service.serviceDo;

import com.xupt.shop.bean.Application;
import com.xupt.shop.dao.impl.ApplicationDao;
import com.xupt.shop.service.interf.InterfApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationDo  implements InterfApplication {
    @Autowired
    ApplicationDao applicationDao;
//添加申请
    @Override
    public int addApplication(Application application) {
        return applicationDao.addApplication(application);
    }
//查看所有申请
    @Override
    public List findAllApplication(int ye) {
        return applicationDao.showApplication(ye);
    }
    @Override
    //查看已审阅通过申请
    public List findYesApplication(int ye){
        return applicationDao.showDoneApplication(ye);
    }
    @Override
    //查看所有未审阅申请
    public List findNoApplication(int ye){
        return  applicationDao.showWaitApplication(ye);
    }

    //同意申请

    public int agreeApplication(int id) {
        return applicationDao.agreeApplication(id);
    }
    //拒绝申请

    public int disagreeApplication(int id) {
        return applicationDao.refuseApplication(id);
    }
    //删除申请

    public int deleteApplication(int id) {
        return applicationDao.deleteApplication(id);
    }

    @Override
    public List findApplicationByName(String title) {
        return applicationDao.findApplicationByName(title);
    }

    @Override
    public Application findApplicationById(int id) {
        return applicationDao.findApplicationById( id);
    }

}
