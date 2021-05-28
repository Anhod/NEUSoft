package com.neu;


import org.springframework.context.annotation.*;

// 配置类
// spring容器中注册组件
@Configuration
@ComponentScan(basePackages = {"com.neu.service"})   // 告诉他扫描什么包
public class AppConfig {
//    // 方法名默认是组件名
//    // 也可以起另外的名字，但是原来的名字就不能用了，只能用name里边的
////    @Bean(name = {"empDao1","empDao2"})
//    @Bean
//    public EmpDao empDao(){
//        return new EmpDaoImpl();
//    }
//
//    // 把数据层的dao输入到service中
//    @Bean
//    @Lazy(true) // 延迟加载，在getBean的时候再加载 ，在使用prototype的时候一定是懒加载的
//    // @Scope("prototype")     // 组件多例，默认singleton多例
//    public EmpService empService(){
//        // 属性注入
////        EmpServiceImpl service = new EmpServiceImpl();
////        service.setEmpDao(empDao());
//
//        // 构造注入
//        EmpServiceImpl service = new EmpServiceImpl(empDao());
//        return service;
//    }
}
