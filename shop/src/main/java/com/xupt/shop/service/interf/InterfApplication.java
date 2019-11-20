package com.xupt.shop.service.interf;

import com.xupt.shop.bean.Application;

import java.util.List;

public interface InterfApplication {
    //添加申请
    public  int addApplication(Application application);
    //展示所有申请
    public List findAllApplication();
    //展示所有已查看申请
    public List findYesApplication();
    //展示所有未查看申请
    public List findNoApplication();
    //同意申请
    public int  agreeApplication(int id);
    //拒绝申请
    public int  disagreeApplication(int id);
    //删除申请
    public int  deleteApplication(int id);
}
