package com.xupt.shop.demo;
import com.xupt.shop.service.User_do;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MapperScan("com.xupt.shop.dao")
public class User {
//    @Autowired
//    User_do user_do;
//    //登录
//    @RequestMapping("/login1")
//    public  String register(String username,String password)
//    {
//        if(user_do.regesiter(username,password)==null)
//        {
//            return "登录失败,用户名或密码错误";
//
//        }
//        return "登录成功";
//    }
//    //添加用户
//    @RequestMapping("/addUser1")
//    public  String addUser(String username,String password,int type)
//    {
//        if(user_do.addUser(username,password,type)!=0)
//        {
//            return "添加成功";
//        }
//        return "添加失败,用户名重复";
//    }
//    //修改用户的类型
//
//    //删除用户
//    @RequestMapping("/deleteUser1")
//    public  String deleteUser(int id1)
//    {
//        if(user_do.deleteUser(id1)!=0)
//        {
//            return "删除成功";
//        }
//        return "删除失败";
//    }

}
