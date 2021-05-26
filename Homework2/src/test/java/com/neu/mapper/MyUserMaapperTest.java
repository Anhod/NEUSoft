package com.neu.mapper;

import com.neu.po.MyUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyUserMaapperTest {
    private MyUserMapper myUserMapper;
    private SqlSession sqlSession;

    // 公共代码
    @Before
    public void setup() throws IOException {
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 创建SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建连接，相当于Connection
        sqlSession = sessionFactory.openSession();

        // 返回DeptMapper接口的实现类
        myUserMapper = sqlSession.getMapper(MyUserMapper.class);
    }

    // 给定用户id，根据其role编号获得对应的role对象
    @Test
    public void getRoleByMyUser(){
        MyUser myUser = myUserMapper.getRoleByMyUser(1);
        System.out.println(myUser.getRole());
    }

    // 根据roleId进行查询
    @Test
    public void getByRoleId(){
        List<MyUser> myUsers = myUserMapper.getByRoleId(2);
        for (int i=0;i<myUsers.size();i++)
            System.out.println(myUsers.get(i));
    }

    @After
    public void end(){
        // 关闭会话
        sqlSession.close();
    }
}
