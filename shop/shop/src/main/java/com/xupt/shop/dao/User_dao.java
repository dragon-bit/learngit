package com.xupt.shop.dao;

import com.xupt.shop.bean.customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface User_dao {
    @Transactional
    customer login(@Param("username")String username, @Param("password")String password);
}
