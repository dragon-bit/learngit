package com.xupt.shop.service;

import com.xupt.shop.bean.customer;
import com.xupt.shop.dao.User_dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements User_s {
    @Autowired
    User_dao user_dao;
    @Override
    public customer regesiter(String username, String password) {
       return  user_dao.login(username,password);
    }
}
