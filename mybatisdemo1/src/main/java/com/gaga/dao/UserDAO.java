package com.gaga.dao;

import com.gaga.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class UserDAO {
    private SqlSessionFactory sqlSessionFactory=null;

    public UserDAO() {
        try {
            String strFile = "SqlMapConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(strFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User queryUserById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();//线程不安全的，放入方法体内。用完要关闭
        try {
            User user = sqlSession.selectOne("mytest.queryUserById",8);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return null;
    }
}
