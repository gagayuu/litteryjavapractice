//package com.gaga.mapper;
//
//import com.gaga.dao.UserDAO;
//import com.gaga.po.User;
//
//import java.util.List;
//
//public class UserMapperImp implements UserMapper {
//
//    //数据访问对象
//    private UserDAO userDAO;
//    public UserMapperImp(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    public User queryUserById(int id)  {
//        User user=userDAO.queryUserById(id);
//        return user;
//    }
//
//    public List<User> queryUserByName(String username) {
//        List<User> users=userDAO.queryUserByName(username);
//        return users;
//    }
//
//    public int deleteUser(int id) {
//       int result=userDAO.deleteUser(id);
//       return result;
//    }
//
//    public int update(User user) {
//        int result=userDAO.update(user);
//        return result;
//    }
//
//    public int addUser(User user) {
//       int result=userDAO.addUser(user);
//       return result;
//    }
//}
