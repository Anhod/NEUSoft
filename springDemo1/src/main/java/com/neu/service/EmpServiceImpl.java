package com.neu.service;

import com.neu.dao.EmpDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// get set方法
@Getter
@Setter
@Component  // 注释表明是组件
// service是业务逻辑层
public class EmpServiceImpl implements EmpService{
    // 属性注入
    @Autowired    // 自动装配，默认按类型装配
    @Qualifier("empDaoImpl")   // 实现类的类名首字母小写
    private EmpDao empDao;

    // 构造器注入，需要写一个有参数的构造方法
    public EmpServiceImpl(){}
    public EmpServiceImpl(EmpDao empDao){
        System.out.println("对象应经被创建");
        this.empDao = empDao;
    }

    @Override
    public int insert() {
        return empDao.insert();
    }
}
