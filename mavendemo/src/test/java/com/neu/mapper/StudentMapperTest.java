package com.neu.mapper;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.neu.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class StudentMapperTest {
    private SqlSession sqlSession;
    private StudentMapper studentMapper;

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
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void insert(){
        int n = studentMapper.insert(new Student(0,"Marry",21,new String[]{"爱游泳","打篮球"}));
        System.out.println(n);

        sqlSession.commit();
    }

    @Test
    public void getById(){
        Student student = studentMapper.getById(2   );
        System.out.println(student);
    }

    @Test
    public void update(){
        int n = studentMapper.update(new Student(2,"curry",23,new String[]{"学习"}));
        System.out.println(n);

        sqlSession.commit();
    }



    @After
    public void end(){
        // 关闭会话
        sqlSession.close();
    }

}
