package com.neu;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration  // 表明该类是个配置文件
@EnableWebMvc   // 启用MVC模块
@ComponentScan(basePackages = "com.neu.controller")
public class SpringMVCConfig  {
    //视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        // 设置前缀
        resolver.setPrefix("/WEB-INF/jsp/");

        // 设置后缀
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
