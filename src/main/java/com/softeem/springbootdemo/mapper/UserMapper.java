package com.softeem.springbootdemo.mapper;

import com.softeem.springbootdemo.pojo.User;

public interface UserMapper {

    public User findUserByNameAndPassword(User user);
    public User findUserByName(String name);
}
