package com.xupt.shop.demo;
import com.xupt.shop.bean.Application;
import com.xupt.shop.bean.Shops;
import com.xupt.shop.service.serviceDo.ApplicationDo;
import com.xupt.shop.service.serviceDo.ShopsDo;
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
    @Autowired
    ShopsDo shopsDo;
    //提交申请
    @RequestMapping("/addApplication1")
    public String addApplication(String title, String content, String name, String telephone)
    {
        int userId=2;
        Application application=new Application();
        application.setUser_id(userId);
        application.setContent(content);
        application.setTitle(title);
        application.setName(name);
        application.setTelephone(Integer.valueOf(telephone));
        if(applicationDo.addApplication(application)!=0){
            return "成功";
       }
        return "失败";
    }
    //查看所有申请
    @RequestMapping("/findAllApplication")
    public List findAllApplication(String ye,String name)
    {   int mi=(Integer.valueOf(ye)-1)*8;
        if (name!=null)
        {
            return applicationDo.findApplicationByName(name);
        }
       List list=applicationDo.findAllApplication(mi);
       return list;
    }
    //查看已处理申请
    @RequestMapping("/findYesApplication")
    public List findYesApplication(int ye)
    {
        ye=(ye-1)*8;
        List list=applicationDo.findYesApplication(ye);
        return list;
    }
    //查看未处理申请
    @RequestMapping("/findNoApplication")
    public List findNoApplication(int ye)
    {
        ye=(ye-1)*8;
        List list=applicationDo.findNoApplication(ye);
        return list;
    }
    //同意申请
    @RequestMapping("/agreeApplication")
    public String agreeApplication(int id)
    {
        if(applicationDo.agreeApplication(id)>=0)
        {
            Application application=applicationDo.findApplicationById(id);
            Shops shops=new Shops();
            shops.setName(application.getTitle());
            shops.setIntroduct(application.getContent());
            shopsDo.addShops(shops);
            return "成功";
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
