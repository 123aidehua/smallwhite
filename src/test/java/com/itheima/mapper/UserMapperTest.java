package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class UserMapperTest {
    SqlSession session=null;
    UserMapper userMapper=null;
    @Before
    public void setUp() throws Exception {
        //读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try {
            //读取mybatis-config.xml文件内容到reader对象中
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis数据库,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlMapper = new
                SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession实例
        session = sqlMapper.openSession();
        userMapper=session.getMapper(UserMapper.class);
    }

    @Test
    public void findById() {
        User u=userMapper.findById(1);
        System.out.println(u);
        session.close();
    }

    @Test
    public void findTotal() {
        int a=userMapper.findTotal();
        System.out.println(a);
       session.close();
    }

    @Test
    public void  addUser(){
        User user=new User();
        user.setUname("王姐");
        user.setUid(5);
        user.setUage(20);
        userMapper.addUser(user);
        System.out.println("添加后");
        System.out.println(user);
        session.commit();
        session.close();
    }
    @Test
    public void  updateUser(){
        User user=new User();
        user.setUid(5);
        user.setUage(28);
        user.setUname("王麻子");
        //System.out.println("更改前信息"+user);
        userMapper.updateUser(user);
        System.out.println("更改后信息："+user);
        //System.out.println(user);
        session.commit();
        session.close();
    }
    @Test
    public  void  deleteUser(){
        userMapper.deleteUser(5);
        System.out.println("删除成功！");
        session.commit();
    }

}