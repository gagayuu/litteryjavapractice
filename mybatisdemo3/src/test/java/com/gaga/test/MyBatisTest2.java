//package com.gaga.test;
//
//import com.gaga.dao.UserDAO;
//import com.gaga.po.User;
//import com.gaga.mapper.UserMapper;
//import com.gaga.mapper.UserMapperImp;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//public class MyBatisTest2 {
//
//    @Test
//    public void testQueryUserById(){
//        UserMapper userMapper =new UserMapperImp(new UserDAO());
//        try {
//            User user= userMapper.queryUserById(1);
//            System.out.println(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void testQueryUserByName(){
//        UserMapper userMapper =new UserMapperImp(new UserDAO());
//        try {
//            List<User> users = userMapper.queryUserByName("%fa%");
//            System.out.println(users);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testAddUser(){
//        UserMapper userMapper =new UserMapperImp(new UserDAO());
//        try{
//            User user=new User();
//            user.setUsername("zzzzz");
//            int result= userMapper.addUser(user);
//            System.out.println(result);
//        }catch (Exception  e){
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testDeleteUser(){
//        UserMapper userMapper =new UserMapperImp(new UserDAO());
//        int result= userMapper.deleteUser(8);//Cannot delete or update a parent row: a foreign key constraint fails,
//                                                    //id=1时报错，删除自己添加的id就可以
//        System.out.println(result);
//    }
//
//    @Test
//    public void testUpdate(){
//        UserMapper userMapper =new UserMapperImp(new UserDAO());
//        User user=new User();
//        user.setId(1);
//        user.setUsername("shanbuliao");
//        int result= userMapper.update(user);
//        System.out.println(result);
//    }
//
//
//}
