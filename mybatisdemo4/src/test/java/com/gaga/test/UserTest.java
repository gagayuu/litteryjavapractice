package com.gaga.test;

import com.gaga.mapper.UserMapper;
import com.gaga.po.User;
import com.gaga.po.UserBZ;
import com.gaga.po.UserExtend;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class UserTest {
    private SqlSessionFactory sqlSessionFactory=null;

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
    public void testQueryUserById(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        try {
            User user=userMapper.queryUserById(27);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void testQueryUserByNameAndSex(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserExtend userExtend = new UserExtend();
            userExtend.setUsername("%fa%");
            userExtend.setSex("1");
            List<UserExtend> userExtendList = userMapper.queryUserByNameAndSex(userExtend);
            System.out.println(userExtendList);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testQueryUserByIds(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            UserBZ userBZ=new UserBZ();
            List<Integer> list=new ArrayList<Integer>();
            list.add(1);
            list.add(27);
            list.add(28);
            userBZ.setIds(list);

            List<User> users= userMapper.queryUserByIds(userBZ);
            System.out.println(users);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testResultMap(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            User user=userMapper.testResultMap(1);
            System.out.println(user);
        }catch(Exception e){

        }finally {
            sqlSession.close();
        }
    }
}

