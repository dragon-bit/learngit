package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.application;

import java.util.List;

public interface ApplicationDao {
    //提出申请
    public int addApplication(application application);
    //展示所有申请
    public List<application> showApplication(application application);
    //同意申请
    public int agreeApplication(application application);
    //拒绝申请
    public int refuseApplication(application application);
    //删除申请
    public int deleteApplication(application application);
    //展示待处理申请
    public List<application> showWaitApplication(application application);
    //展示已处理申请
    public List<application> showDoneApplication(application application);
}
