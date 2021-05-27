package com.neu.mapper;

import com.neu.po.Dept;
import com.neu.po.DeptExample;
import com.neu.po.Emp;
import com.neu.po.EmpExample;
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

public class EmpMapperTest {
    private SqlSession sqlSession;
    private EmpMapper empMapper;

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
        empMapper= sqlSession.getMapper(EmpMapper.class);
    }

    // 1.查询员工姓名等于"smith"并且sal大于等于3000的员工信息
    @Test
    public void problem1(){
        EmpExample empExample = new EmpExample();
        empExample.or().andEnameEqualTo("KING").andSalGreaterThanOrEqualTo(3000.0);

        List<Emp> emps = empMapper.selectByExample(empExample);
        for (int i=0;i<emps.size();i++)
            System.out.println(emps.get(i));
    }

    // 2.查询员工编号为:7783和7876的员工信息
    @Test
    public void problem2(){
        EmpExample empExample = new EmpExample();
        empExample.or().andEmpnoEqualTo(7876);
        empExample.or().andEmpnoEqualTo(7812);

        List<Emp> emps = empMapper.selectByExample(empExample);
        for (int i=0;i<emps.size();i++)
            System.out.println(emps.get(i));
    }

    // 3.查询奖金(comm)不是null的所有员工信息
    @Test
    public void problem3(){
        EmpExample empExample = new EmpExample();
        empExample.or().andCommIsNotNull();

        List<Emp> emps = empMapper.selectByExample(empExample);
        for (int i=0;i<emps.size();i++)
            System.out.println(emps.get(i));
    }

    // 4.更新员工编号为7839的薪水，薪水增加200元
    @Test
    public void problem4(){
        Emp emp = empMapper.selectByPrimaryKey(7839);
        System.out.println(emp);

        emp.setSal(emp.getSal()+200);

        empMapper.updateByPrimaryKey(emp);

        sqlSession.commit();
    }

    // 5.查询工资小于2000元或部门编号为10的所有员工信息
    @Test
    public void problem5(){
        EmpExample empExample = new EmpExample();
        empExample.or().andSalLessThan(2000.0);
        empExample.or().andDeptnoEqualTo(10);

        List<Emp> emps = empMapper.selectByExample(empExample);
        for (int i=0;i<emps.size();i++)
            System.out.println(emps.get(i));
    }

    // 6.根据部门名称查询该部门所有员工(组合DeptExample和EmpExample查询)
    @Test
    public void problem6(){
        // 根据部门名称查出部门编号
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);

        DeptExample deptExample = new DeptExample();
        deptExample.or().andDnameEqualTo("water");

        int deptno = 0;
        List<Dept> depts = deptMapper.selectByExample(deptExample);
        if (depts.size()==1) {
            deptno = depts.get(0).getDeptno();
        }

        // 根据部门编号查询员工
        EmpExample empExample = new EmpExample();
        empExample.or().andDeptnoEqualTo(deptno);

        List<Emp> emps = empMapper.selectByExample(empExample);
        for (int i=0;i<emps.size();i++)
            System.out.println(emps.get(i));
    }

    @After
    public void end(){
        // 关闭会话
        sqlSession.close();
    }
}
