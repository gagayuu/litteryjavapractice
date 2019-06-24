//package com.gaga.dao;
//
//import com.gaga.po.User;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.InputStream;
//import java.util.List;
//
//public class UserDAO {
//    private SqlSessionFactory sqlSessionFactory=null;
//
//    public UserDAO() {
//        try {
//            String strFile = "SqlMapConfig.xml";
//            InputStream inputStream = Resources.getResourceAsStream(strFile);
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public User queryUserById(int id){
//        SqlSession sqlSession = sqlSessionFactory.openSession();//线程不安全的，放入方法体内。用完要关闭
//        try {
//            User user = sqlSession.selectOne("com.gaga.mapper.UserMapper.queryUserById",8);
//            return user;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            sqlSession.close();
//        }
//        return null;
//    }
//
//    public List<User> queryUserByName(String name){
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        try{
//            List<User> userList=sqlSession.selectList("com.gaga.mapper.UserMapper.queryUserByName",name);
//            return userList;
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally {
//            sqlSession.close();
//        }
//        return null;
//    }
//
//    public int addUser(User user){
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        try{
//            int result=sqlSession.insert("com.gaga.mapper.UserMapper.addUser",user);
//            sqlSession.commit();
//            return result;
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            sqlSession.close();
//        }
//        return 0;
//    }
//
//    public int deleteUser(int id){
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        try{
//            int result=sqlSession.delete("com.gaga.mapper.UserMapper.deleteUser",id);
//            sqlSession.commit();
//            return result;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            sqlSession.close();
//        }
//        return 0;
//    }
//
//    public int update(User user){
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        try{
//            int result=sqlSession.update("com.gaga.mapper.UserMapper.modifyUser",user);
//            sqlSession.commit();
//            return result;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally{
//            sqlSession.close();
//        }
//        return 0;
//    }
//}
