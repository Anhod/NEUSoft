package com.neu.mapper;

import com.neu.po.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmpMapperTest {
    private EmpMapper empMapper;
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
        empMapper = sqlSession.getMapper(EmpMapper.class);
    }

    // 动态查询
    @Test
    public void search(){
        List<Emp> emps = empMapper.search(new Emp(7369,null,null,null,null,null,null,null));
        for (int i=0;i<emps.size();i++)
            System.out.println(emps.get(i));
    }

    // 有选择的插入
    @Test
    public void insert(){
        int n = empMapper.insert(new Emp(4343,"haha",null,null,null,800.0,null,null));
        System.out.println(n);
        sqlSession.commit();
    }

    // 有选择的更新
    @Test
    public void update(){
        int n = empMapper.update(new Emp(7812,null,null,null,null,1412.0,null,null));
        System.out.println(n);

        sqlSession.commit();
    }

    // 批量添加
    @Test
    public void insertBatch() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Emp> emps = new ArrayList<>();
        emps.add(new Emp(1234,"Stephen","Salesman",7722,format.parse("2021-3-12"),700.0,null,20));
        emps.add(new Emp(4321,"July","President",7812,format.parse("2020-4-22"),700.0,null,20));

        int n = empMapper.insertBatch(emps);
        System.out.println(n);

        sqlSession.commit();


    }

    // 批量删除
    @Test
    public void deleteBatch(){
        int[] ids = new int[]{1234,4321};
        int n = empMapper.deleteBatch(ids);

        System.out.println(n);
        sqlSession.commit();
    }

    @After
    public void end(){
        // 关闭会话
        sqlSession.close();
    }
}
