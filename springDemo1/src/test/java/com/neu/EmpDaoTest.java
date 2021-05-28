package com.neu;

import com.neu.dao.EmpDao;
import com.neu.service.EmpService;
import javafx.application.Application;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpDaoTest {
    @Test
    public void insert(){
        // 启动容器
        ApplicationContext c = new AnnotationConfigApplicationContext(AppConfig.class);

//        // 通过类型得到组件
////        EmpDao empDao = c.getBean(EmpDao.class);
//
//        // 通过方法名得到组件（方法名默认是组件名）
//         // EmpDao empDao = (EmpDao) c.getBean("empDao");
//        EmpService empService = c.getBean(EmpService.class);
//
//        // 调用业务方法
//       //  empDao.insert();
//        empService.insert();

        // 关掉容器
        EmpDao empDao = c.getBean(EmpDao.class);
        empDao.insert();

        EmpService service = c.getBean(EmpService.class);
        service.insert();
        // 关闭容器
        ((AnnotationConfigApplicationContext)c).close();
    }
}
