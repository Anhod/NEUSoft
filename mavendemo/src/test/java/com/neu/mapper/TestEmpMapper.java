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
import java.util.Date;
import java.util.List;

public class TestEmpMapper {
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

    // 查询全部
    @Test
    public void findAll(){
        List<Emp> emps = empMapper.findAll();
        for (int i=0;i<emps.size();i++)
            System.out.println(emps.get(i));
    }

    // 根据Id进行查询
    @Test
    public void getById(){
        Emp emp = empMapper.getById(7369);
        System.out.println(emp);
    }

    // 插入记录
    @Test
    public void insert(){
        int n = empMapper.insert(new Emp(7812,"Curry","PRESIDENT",7839,new Date(),1300.0,500.0,10));
        System.out.println(n);

        sqlSession.commit();
    }

    // 根据Id更新工资
    @Test
    public void updateSalById(){
        int n = empMapper.updateSalById(7812,1400);
        System.out.println(n);

        sqlSession.commit();
    }

    // 根据Id进行删除
    @Test
    public void  deleteById(){
        int n = empMapper.deleteById(7812);
        System.out.println(n);

        sqlSession.commit();
    }

    @Test
    public void order(){
        List<Emp> list = empMapper.order("sal");
        for (int i = 0;i<list.size();i++)
            System.out.println(list.get(i));
    }

    @Test
    public void getByIdWithDept(){
        Emp emp = empMapper.getByIdWithDept(7369);
        System.out.println(emp.getDept());
    }

    // --------------------------------------------第三天--------------------------------------------
    @Test
    public void getDeptObjectById(){
        Emp emp = empMapper.getDeptObjectById(7812);
        System.out.println(emp);

        System.out.println(emp.getDept());
    }
    @After
    public void end(){
        // 关闭会话
        sqlSession.close();
    }
}
