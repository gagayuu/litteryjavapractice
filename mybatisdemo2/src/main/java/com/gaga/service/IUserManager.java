package com.gaga.service;

import com.gaga.po.User;

import java.util.List;



public interface IUserManager {

    User queryUserById(int id) throws Exception;

    List<User> queryUserByName(String username) throws Exception;

    int deleteUser(int id);

    int update(User user);

    int addUser(User user);
}
