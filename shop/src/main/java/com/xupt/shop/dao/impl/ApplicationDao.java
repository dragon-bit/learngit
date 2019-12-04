package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.Application;


import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationDao {
    //提出申请
    public int addApplication(Application application);
    //展示所有申请
    public List<Application> showApplication();
    //展示待处理申请
    public List<Application> showWaitApplication();
    //展示已处理申请
    public List<Application> showDoneApplication();
    //同意申请
    public int agreeApplication(int id);
    //拒绝申请
    public int refuseApplication(int id);
    //删除申请
    public int deleteApplication(int id);

}
