package com.xupt.shop.demo;

import com.xupt.shop.bean.Application;
import com.xupt.shop.service.serviceDo.ApplicationDo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MapperScan("com.xupt.shop.dao.impl")
public class ApplicationServlet {
    @Autowired
    ApplicationDo applicationDo;
    //提交申请
    @RequestMapping("/addApplication")
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

}
