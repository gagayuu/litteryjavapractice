package com.gaga.test;

import com.gaga.mapper.ItemsMapper;
import com.gaga.po.Items;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ItemsTest {
    private  SqlSessionFactory sqlSessionFactory=null;

    @BeforeEach
    public void Initial(){
        String file="SqlMapConfig.xml";
        try {
            InputStream inputStream= Resources.getResourceAsStream(file);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryItemsById(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ItemsMapper itemsMapper=sqlSession.getMapper(ItemsMapper.class);
        try {
            Items item=itemsMapper.queryItemsById(1);
            System.out.println(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
