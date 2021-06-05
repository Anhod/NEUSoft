package com.neu.mapper;

import com.neu.po.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class RoleMapperTest {
    private RoleMapper roleMapper;
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
        roleMapper = sqlSession.getMapper(RoleMapper.class);
    }

    // 常规的根据id获得对象
    @Test
    public void getById(){
        Role role = roleMapper.getById(4);
        System.out.println(role);
    }

    // 给定roleId，查询出所有属于该role的用户
    @Test
    public void getAllUserById(){
        Role role = roleMapper.getAllUserById(4);
        System.out.println(role);

        for (int i=0;i<role.getMyUsers().size();i++)
            System.out.println(role.getMyUsers().get(i));
    }

    @After
    public void end(){
        // 关闭会话
        sqlSession.close();
    }
}
