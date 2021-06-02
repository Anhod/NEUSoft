package com.neu;


import org.springframework.context.annotation.*;

// 配置类
// spring容器中注册组件
@Configuration
@ComponentScan(basePackages = {"com.neu.service"})   // 告诉他扫描什么包
public class AppConfig {

}
