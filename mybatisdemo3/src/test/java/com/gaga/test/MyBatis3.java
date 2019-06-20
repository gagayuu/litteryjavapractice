package com.gaga.test;

import com.gaga.mapper.UserMapper;
import com.gaga.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;


public class MyBatis3 {
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
        }

    }

}

