package com.neu.mapper;

import com.neu.po.Dept;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDeptMapper {
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

    // 根据deptid获得记录
    @Test
    public void testGetById() throws IOException {
        Dept dept = deptMapper.getById(10);
        System.out.println(dept);
        System.out.println(dept.getEmps());
    }

    // 得到全部记录
    @Test
    public void testGetAll() throws IOException {
         List<Dept> depts = deptMapper.getAll();
        for (int i=0;i<depts.size();i++)
            System.out.println(depts.get(i));
    }

    // 插入记录
    @Test
    public void insert(){
        int n = deptMapper.insert(new Dept(56,"water","beijing"));
        System.out.println(n);

        // 增删改操作需要提交，查询直接提交了
        sqlSession.commit();
    }

    // 根据deptId更新dept的loc字段
    @Test
    public void update(){
        int n = deptMapper.updateLocById(new Dept(55,"hr","beijing"));
        System.out.println(n);

        sqlSession.commit();
    }

    // 根据deptId删除记录
    @Test
    public void deleteById(){
        int n = deptMapper.deleteById(55);
        System.out.println(n);

        sqlSession.commit();
    }

    @Test
    public void find( ){
        List<Dept> list = deptMapper.find("OPERATIONS","BOSTON");
        System.out.println(list);
    }

    @Test
    public void find2( ){
        List<Dept> depts = deptMapper.find2(new Dept(1,"OPERATIONS","BOSTON"));
        System.out.println(depts);
    }

    @Test
    public void find3( ){
        Map<String,String> map = new HashMap<>();
        map.put("dname","OPERATIONS");
        map.put("loc","BOSTON");

        List<Dept> depts = deptMapper.find3(map);
        System.out.println(depts);
    }

    @Test
    public void updateDnameById(){
        int n = deptMapper.updateDnameById(40,"小米");
        System.out.println(n);

        sqlSession.commit();
    }

    @Test
    public void getAllByOrderDname(){
        List<Dept> depts = deptMapper.getAllByOrderDname("dname");
        for (int i=0;i<depts.size();i++)
            System.out.println(depts.get(i));
    }



    //------------------------------------------------模糊查询------------------------------------------------
    // 注意一下两者的区别
    @Test
    public void getByDname(){
        List<Dept> depts = deptMapper.getByDname("h");
        for (int i=0;i<depts.size();i++)
            System.out.println(depts.get(i));
    }

    @Test
    public void getByDname2(){
        List<Dept> depts = deptMapper.getByDname2("%h%");
        for (int i=0;i<depts.size();i++)
            System.out.println(depts.get(i));
    }


    //------------------------------------------------第二天的内容------------------------------------------------
    @Test
    // 动态根据条件查询
    public void search(){
        List<Dept> depts = deptMapper.search3(new Dept(100,null,null));
        for (int i=0;i<depts.size();i++)
            System.out.println(depts.get(i));
    }

    // 局部字段更新
    @Test
    public void updateLocal(){
        int n = deptMapper.updateLocal(new Dept(20,"XiaoMi",null));
        sqlSession.commit();
        System.out.println(n);
    }

    // 批量删除
    @Test
    public void deleteBatch(){
        deptMapper.deleteBatch(new int[]{55,56});
        sqlSession.commit();
    }

    // 批量插入
    @Test
    public void insertBatch(){
        List<Dept> depts = new ArrayList<>();
        depts.add(new Dept(55,"hr","shenyang"));
        depts.add(new Dept(56,"water","beijing"));
        int n = deptMapper.insertBatch(depts);
        System.out.println(n);

        sqlSession.commit();
    }

    // 根据部门编号得到部门名
    @Test
    public void getDnameById(){
        String dname = deptMapper.getDnameById(10);
        System.out.println(dname);
    }

    // 得到部门数量
    @Test
    public void getNumOfDept(){
        int n = deptMapper.getNumOfDept();
        System.out.println(n);
    }

    @Test
    public void exist(){
        boolean exist = deptMapper.exist("XiaoMi");
        System.out.println(exist);
    }

    @Test
    public void paged(){
        List<Dept> depts = deptMapper.paged(2,3);
        for (int i=0;i<depts.size();i++)
            System.out.println(depts.get(i));
    }
    @After
    public void end(){
        // 关闭会话
        sqlSession.close();
    }
}
