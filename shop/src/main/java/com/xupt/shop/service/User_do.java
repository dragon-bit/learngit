package com.xupt.shop.service;

import com.xupt.shop.dao.User_dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_do implements User_s {
    @Autowired
    User_dao user_dao;
    @Override
    public int regesiter(String username, String password) {
       return  user_dao.logon(username,password);
    }
}
