package com.neu.mapper;

import com.neu.po.Dept;
import com.neu.po.DeptExample;
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

public class DeptMapperTest {
    private SqlSession sqlSession;
    private DeptMapper deptMapper;

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
        deptMapper = sqlSession.getMapper(DeptMapper.class);
    }

    // 查询全部记录
    @Test
    public void getAll(){
        List<Dept> depts = deptMapper.selectByExample(new DeptExample());
        for (int i=0;i<depts.size();i++)
            System.out.println(depts.get(i));
    }

    @Test
    // 用主键查询
    public void getById(){
        Dept dept = deptMapper.selectByPrimaryKey(10);
        System.out.println(dept);
    }

    @Test
    public void getByDname(){
        DeptExample deptExample = new DeptExample();

        // 两个条件用and连接在一起
        deptExample.or().andDnameLike("%h%").andDeptnoBetween(10,30);

        // 两个条件用or连接在一起
//        deptExample.or().andDnameLike("%h%");
//        deptExample.or().andDeptnoBetween(10,30);
        List<Dept> depts = deptMapper.selectByExample(deptExample);

        for (int i=0;i<depts.size();i++)
            System.out.println(depts.get(i));
    }
    @After
    public void end(){
        // 关闭会话
        sqlSession.close();
    }
}
