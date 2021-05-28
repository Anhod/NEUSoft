package com.neu;

import com.neu.po.Emp;
import com.neu.service.EmpServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

// 这种方法直接给予测试
// 设置配置文件
@ContextConfiguration(classes = {DBConfig.class,MybatisConfig.class,MyBatisMapperScannerConfig.class})
// 相当于测试框架和spring的接口
@RunWith(SpringJUnit4ClassRunner.class)

public class EmpMapperTest {
    @Resource
    private EmpServiceImpl empService;

    @Test
    public void getAll(){
        List<Emp> emps = empService.getAll();
        for (int i=0;i<emps.size();i++)
            System.out.println(emps.get(i));
    }

    @Test
    public void insert(){
        int n = empService.insert(new Emp(1111,null,null,null,null,null,null));
        System.out.println(n);
    }

    @Test
    public void delete(){
        int n = empService.delete(1111);
        System.out.println(n);
    }

    // 分页测试，第二页，一页三条
    @Test
    public void paged(){
        List<Emp> emps = empService.paged(2,3);
        for (int i=0;i<emps.size();i++)
            System.out.println(emps.get(i));
    }
}
