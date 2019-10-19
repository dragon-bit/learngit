package com.xupt.shop.demo;
import com.xupt.shop.service.User_do;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MapperScan("com.xupt.shop.dao")
public class User {
    @Autowired
    User_do user_do;
    @RequestMapping("/huangfu")
    public  String register(String username,String password)
    {
        if(user_do.regesiter(username,password)!=0)
        {
            return "注册成功";
        }
        return "注册失败";
    }

}
