package com.gaga.test;

import com.gaga.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class MyBatisTest {
    public SqlSessionFactory sqlSessionFactory = null;

    @BeforeEach
    public void testInitial() {

        try {
            String strFile = "SqlMapConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(strFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();//线程不安全的，放入方法体内。用完要关闭
        try {
            User user = sqlSession.selectOne("mytest.queryUserById",8);
           // List<User> list = sqlSession.selectList("mytest.queryUserByName", "%小明%");
            System.out.println(user);
           // System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();//线程不安全的，放入方法体内。用完要关闭
        try {
            User user = new User();
            user.setUsername("fairy2");
            user.setBirthday(new Date());
            user.setSex("0");
            user.setAddress("Xian");
            int res = sqlSession.insert("mytest.addUser", user);
            sqlSession.commit();
            System.out.println("Update:"+res);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            int res=sqlSession.delete("mytest.deleteUser",29);
            sqlSession.commit();
            System.out.println("Update:"+res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void modifyUser(){
        SqlSession sqlSession=sqlSessionFactory.openSession();

        try{
            User user = new User();
            user.setId(1);
            user.setUsername("王五");
            user.setBirthday(new Date());
            user.setSex("1");
            user.setAddress("Xian");
            int res =sqlSession.update("mytest.modifyUser",user);
            sqlSession.commit();
            System.out.println("Update:"+res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}