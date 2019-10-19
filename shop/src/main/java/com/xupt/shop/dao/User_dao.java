package com.xupt.shop.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface User_dao {
    @Transactional
    int logon(@Param("username")String username, @Param("password")String password);
}
