package com.xupt.shop.demo;

import com.xupt.shop.bean.Application;
import com.xupt.shop.service.serviceDo.ApplicationDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@MapperScan("com.xupt.shop.dao.impl")
public class ApplicationServlet {
    @Autowired
    ApplicationDo applicationDo;
    //提交申请
    @RequestMapping("/addApplication1")
    public String addApplication(String title,int userId,String content)
    {
        Application application=new Application();
        application.setUser_id(userId);
        application.setContent(content);
        application.setTitle(title);
        if(applicationDo.addApplication(application)!=0){
            return "申请成功";
        }
        else return "申请失败";

    }
    //查看所有申请
    @RequestMapping("/findAllApplication")
    public List findAllApplication()
    {
        List list=applicationDo.findAllApplication();
        return list;
    }
    //查看已处理申请
    @RequestMapping("/findYesApplication")
    public List findYesApplication()
    {
        List list=applicationDo.findYesApplication();
        return list;
    }
    //查看未处理申请
    @RequestMapping("/findNoApplication")
    public List findNoApplication()
    {
        List list=applicationDo.findNoApplication();
        return list;
    }
    //同意申请
    @RequestMapping("/agreeApplication")
    public String agreeApplication(int id)
    {
        if(applicationDo.agreeApplication(id)>=0)
        {
            return "同意申请";
        }
        return "出现异常";
    }
    //拒绝申请
    @RequestMapping("/disagreeApplication")
    public String disagreeApplication(int id)
    {
        if(applicationDo.disagreeApplication(id)>=0)
        {
            return "拒绝申请";
        }
        return "出现异常";
    }
    //删除申请
    @RequestMapping("/deleteApplication")
    public String deleteApplication(int id)
    {
        if(applicationDo.deleteApplication(id)>=0)
        {
            return "已删除";
        }
        return "删除失败";
    }

}
