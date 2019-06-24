package com.gaga.mapper;

import com.gaga.po.User;
import com.gaga.po.UserBZ;
import com.gaga.po.UserExtend;

import java.util.List;


public interface UserMapper {

    User queryUserById(int id) throws Exception;

    List<User> queryUserByName(String username) throws Exception;

    int deleteUser(int id);

    int update(User user);

    int addUser(User user);

    List<UserExtend> queryUserByNameAndSex(UserExtend userExtend);

   List<User> queryUserByIds(UserBZ userBZ);

   User testResultMap(int id);
}
