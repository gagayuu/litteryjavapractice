package com.gaga.service;

import com.gaga.po.User;

import java.util.List;

public interface IUserManager {

    public User queryUserById(int id) throws Exception;

    public List<User> queryUserByName(String username) throws Exception;

    public int deleteUser(int i);

    public int update(User user);
}
