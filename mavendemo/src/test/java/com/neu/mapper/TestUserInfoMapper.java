package com.neu.mapper;

import com.neu.po.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestUserInfoMapper {
    private UserInfoMapper userInfoMapper;
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
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
    }

    @Test
    public void insert(){
        UserInfo userInfo = new UserInfo(7,"jane","333");
        int n = userInfoMapper.insert(userInfo);
        System.out.println(userInfo.getId());

        sqlSession.commit();
    }

    @Test
    public void getById(){
        UserInfo userInfo = userInfoMapper.getById(1);
        System.out.println(userInfo);
    }

    @Test
    public void getById1(){
        UserInfo userInfo = userInfoMapper.getById1(1);
        System.out.println(userInfo);
    }

    @After
    public void end(){
        // 关闭会话
        sqlSession.close();
    }
}
