package com.gaga.test;

import com.gaga.mapper.OrderMapper;
import com.gaga.po.Orders;
import com.gaga.po.OrdersExtend;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class OrdersTest {
    private SqlSessionFactory sqlSessionFactory=null;

    @BeforeEach
    public void initial(){
        try{
            String file="SqlMapConfig.xml";
            InputStream inputStream= Resources.getResourceAsStream(file);
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testQueryOrderUser(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
            List<OrdersExtend> ordersExtends=orderMapper.queryOrderUser();
            System.out.println(ordersExtends);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testQueryOrderUser01(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
            List<Orders> orders=orderMapper.queryOrderUser01();
            System.out.println(orders);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testQueryOO(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            OrderMapper orderMapper=sqlSession.getMapper(OrderMapper.class);
            List<Orders> orders=orderMapper.queryOO();
            for(Orders oo:orders){
                System.out.println(oo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
