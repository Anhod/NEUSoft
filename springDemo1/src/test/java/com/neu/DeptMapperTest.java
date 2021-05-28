package com.neu;

import com.neu.mapper.DeptMapper;
import com.neu.po.Dept;
import com.neu.service.DeptService;
import com.neu.service.DeptServiceImpl;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

// 这种方法直接给予测试
// 设置配置文件
@ContextConfiguration(classes = {DBConfig.class,MybatisConfig.class,MyBatisMapperScannerConfig.class})
// 相当于测试框架和spring的接口
@RunWith(SpringJUnit4ClassRunner.class)
public class DeptMapperTest {
    @Resource
    private DeptMapper deptMapper;

    @Resource
    private DeptServiceImpl deptService;

    @Test
    public void getById(){
//        Dept dept = deptMapper.getById(10);
//        System.out.println(dept);

        Dept dept = deptService.getById(10);
        System.out.println(dept);
    }
}
