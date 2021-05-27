package com.neu.mapper;

import com.neu.po.Boring;
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
import java.util.Date;
import java.util.TimeZone;

public class BoringMapperTest {
    private SqlSession sqlSession;
    private BoringMapper boringMapper;

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
        boringMapper = sqlSession.getMapper(BoringMapper.class);
    }


    @Test
    public void insert() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Integer n = boringMapper.insert(new Boring(2,simpleDateFormat.parse("1970-1-1")));
        System.out.println(n);

        sqlSession.commit();
    }

    @Test
    public void getById(){
        Boring boring = boringMapper.getById(2);
        System.out.println(boring);
    }

    @After
    public void end(){
        // 关闭会话
        sqlSession.close();
    }
}
