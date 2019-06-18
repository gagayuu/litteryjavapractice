package com.gaga.service;

import com.gaga.dao.UserDAO;
import com.gaga.po.User;

import java.util.List;

public class UserManagerImp implements IUserManager {

    //数据访问对象
    private UserDAO userDAO;
    public UserManagerImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User queryUserById(int id) throws Exception {
        User user=userDAO.queryUserById(id);
        return user;
    }

    public List<User> queryUserByName(String username) throws Exception {
        return null;
    }

    public int deleteUser(int i) {
        return 0;
    }

    public int update(User user) {
        return 0;
    }
}
