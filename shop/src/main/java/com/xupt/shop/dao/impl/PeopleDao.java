package com.xupt.shop.dao.impl;

import com.xupt.shop.bean.People;

public interface PeopleDao {
//根据id查找用户信息
public People findPeopleById(int id);
//根据id修改用户信息
public int  updatePeople(People people);
}
