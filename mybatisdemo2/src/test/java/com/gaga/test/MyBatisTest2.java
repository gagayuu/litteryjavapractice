package com.gaga.test;

import com.gaga.dao.UserDAO;
import com.gaga.po.User;
import com.gaga.service.IUserManager;
import com.gaga.service.UserManagerImp;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyBatisTest2 {

    @Test
    public void testQueryUserById(){
        IUserManager iUserManager=new UserManagerImp(new UserDAO());
        try {
            User user=iUserManager.queryUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryUserByName(){
        IUserManager iUserManager=new UserManagerImp(new UserDAO());
        try {
            List<User> users = iUserManager.queryUserByName("%fa%");
            System.out.println(users);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testAddUser(){
        IUserManager iUserManager=new UserManagerImp(new UserDAO());
        try{
            User user=new User();
            user.setUsername("zzzzz");
            int result=iUserManager.addUser(user);
            System.out.println(result);
        }catch (Exception  e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteUser(){
        IUserManager iUserManager=new UserManagerImp(new UserDAO());
        int result=iUserManager.deleteUser(8);//Cannot delete or update a parent row: a foreign key constraint fails,
                                                    //id=1时报错，删除自己添加的id就可以
        System.out.println(result);
    }

    @Test
    public void testUpdate(){
        IUserManager iUserManager=new UserManagerImp(new UserDAO());
        User user=new User();
        user.setId(1);
        user.setUsername("shanbuliao");
        int result=iUserManager.update(user);
        System.out.println(result);
    }


}
