package com.gaga.test;

import com.gaga.dao.UserDAO;
import com.gaga.po.User;
import com.gaga.service.IUserManager;
import com.gaga.service.UserManagerImp;
import org.junit.jupiter.api.Test;

public class MyBatisTest2 {

    @Test
    public void testUserManagerImp(){
        IUserManager iUserManager=new UserManagerImp(new UserDAO());
        try {
            User user=iUserManager.queryUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
