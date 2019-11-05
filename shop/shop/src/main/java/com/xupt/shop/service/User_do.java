package com.xupt.shop.service;

import com.xupt.shop.bean.customer;
import com.xupt.shop.dao.User_dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_do implements User_s {

//    @Autowired
//    User_dao user_dao;
//    //登录的service层
//    @Override
//    public customer regesiter(String username, String password) {
//       return  user_dao.login(username,password);
//    }
//
//    @Override
//    //添加用户o的service层
//    public int addUser(String username, String password, int type) {
//        if(user_dao.find(username)!=null)
//        {
//            return 0;
//
//        }
//        return  user_dao.addUser(username,password,type);
//    }
//
//    //删除用户的service层
//    @Override
//    public int deleteUser(int id) {
//        return  user_dao.deleteUser(id);
//    }
}
