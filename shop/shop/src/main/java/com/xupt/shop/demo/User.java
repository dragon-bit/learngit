package com.xupt.shop.demo;
import com.xupt.shop.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MapperScan("com.xupt.shop.dao")
public class User {
    @Autowired
    UserService user_service;
    @RequestMapping("/user")
    public  String register(String username,String password)
    {
        if(user_service.regesiter(username,password)!=null)
        {
            return "登录成功";
        }
        return "登录失败";
    }

}
