package com.neu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 创建spring容器
        AnnotationConfigWebApplicationContext c = new AnnotationConfigWebApplicationContext();

        // 注册配置类
        c.register(DBConfig.class);
        c.register(MybatisConfig.class);
        c.register(MyBatisMapperScannerConfig.class);

        // 把spring容器的引用方法ServletContext中
        servletContext.addListener(new ContextLoaderListener(c));
    }
}
