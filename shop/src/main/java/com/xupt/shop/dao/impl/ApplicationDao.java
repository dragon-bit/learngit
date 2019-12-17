package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.Application;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplicationDao {
    //提出申请
    public int addApplication(Application application);
    //展示所有申请
    public List<Application> showApplication(int ye);
    //展示待处理申请
    public List<Application> showWaitApplication(int ye);
    //展示已处理申请
    public List<Application> showDoneApplication(int ye);
    //同意申请
    public int agreeApplication(int id);
    //拒绝申请
    public int refuseApplication(int id);
    //删除申请
    public int deleteApplication(int id);
    //根据名字搜索申请
    public List findApplicationByName(String title);
    //根据id搜索申请
    public Application findApplicationById(int id);
}
